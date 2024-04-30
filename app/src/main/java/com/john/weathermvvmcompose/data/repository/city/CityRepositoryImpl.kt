package com.john.weathermvvmcompose.data.repository.city

import com.john.weathermvvmcompose.data.local.city.CityLocalDataSource
import com.john.weathermvvmcompose.data.local.forecast.ForecastLocalDataSource
import com.john.weathermvvmcompose.data.remote.RemoteDataSource
import com.john.weathermvvmcompose.model.City
import com.john.weathermvvmcompose.model.NetworkDataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.net.UnknownHostException

class CityRepositoryImpl(
    private val cityLocalDataSource: CityLocalDataSource,
    private val forecastLocalDataSource: ForecastLocalDataSource,
    private val remoteDataSourceSource: RemoteDataSource
) : CityRepository {
    override fun getCities(lat: Double?, lon: Double?): Flow<NetworkDataState<List<City>>> = flow {
        emit(NetworkDataState.Loading)

        // If Latitude or Longitude are null get the data from database
        if (lat == null || lon == null) {
            val cachedWeather = cityLocalDataSource.getCities()
            emit(NetworkDataState.Success(cachedWeather))
        } else {

            try {

                val cityFromNetwork = remoteDataSourceSource.getCurrentWeather(lat, lon)
                cityLocalDataSource.insertCity(cityFromNetwork.data[0])
                val cachedList = cityLocalDataSource.getCities()
                emit(NetworkDataState.Success(cachedList))

            } catch (e: HttpException) {
                emit(NetworkDataState.Error(e))
            } catch (e: IOException) {
                emit(NetworkDataState.Error(e))
            } catch (e: UnknownHostException) {
                emit(NetworkDataState.Error(e))

            }

        }

    }

    override fun getCity(cityId: Long, isRefreshing: Boolean): Flow<NetworkDataState<City>> = flow {
        emit(NetworkDataState.Loading)
        var cachedCity = cityLocalDataSource.getCity(cityId)

        //If isRefreshing is true pull from the network, otherwise pull from database
        if (isRefreshing) {

            try {

                val cityFromNetwork =
                    remoteDataSourceSource.getCurrentWeather(cachedCity.lat!!, cachedCity.lon!!)
                cityLocalDataSource.updateCity(cityFromNetwork.data[0], cachedCity, cachedCity.id)

                cachedCity = cityLocalDataSource.getCity(cityId)
                emit(NetworkDataState.Success(cachedCity))

            } catch (e: HttpException) {
                emit(NetworkDataState.Error(e))
            } catch (e: IOException) {
                emit(NetworkDataState.Error(e))
            } catch (e: UnknownHostException) {
                emit(NetworkDataState.Error(e))
            }


        } else {
            cachedCity = cityLocalDataSource.getCity(cityId)
            emit(NetworkDataState.Success(cachedCity))
        }

    }

    override fun deleteCity(cityId: Long): Flow<NetworkDataState<Boolean>> = flow {
        emit(NetworkDataState.Loading)
        cityLocalDataSource.deleteCity(cityId)
        forecastLocalDataSource.deleteForecast(cityId)
        emit(NetworkDataState.Success(true))
    }

}