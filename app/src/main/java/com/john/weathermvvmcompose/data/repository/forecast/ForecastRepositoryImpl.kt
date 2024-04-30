package com.john.weathermvvmcompose.data.repository.forecast

import com.john.weathermvvmcompose.data.local.city.CityLocalDataSource
import com.john.weathermvvmcompose.data.local.forecast.ForecastLocalDataSource
import com.john.weathermvvmcompose.data.remote.RemoteDataSource
import com.john.weathermvvmcompose.model.Forecast
import com.john.weathermvvmcompose.model.NetworkDataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.net.UnknownHostException

class ForecastRepositoryImpl(
    private val cityLocalDataSource: CityLocalDataSource,
    private val forecastLocalDataSource: ForecastLocalDataSource,
    private val remoteDataSourceSource: RemoteDataSource
) : ForecastRepository {
    override fun getForecast(
        cityId: Long?,
        isRefreshing: Boolean
    ): Flow<NetworkDataState<List<Forecast>>> = flow {
        emit(NetworkDataState.Loading)

        var cachedWeather = forecastLocalDataSource.getForecast(cityId!!)
        val cachedCity = cityLocalDataSource.getCity(cityId)
        // If the forecast is not cached in the database or isRefreshing is true pull from the network, otherwise pull from database
        when {
            cachedWeather.isEmpty() -> {
                val networkForecast =
                    remoteDataSourceSource.getForecast(cachedCity.lat!!, cachedCity.lon!!)
                forecastLocalDataSource.insertForecast(networkForecast.data, cityId)
                cachedWeather = forecastLocalDataSource.getForecast(cityId)
                emit(NetworkDataState.Success(cachedWeather))
            }

            isRefreshing -> {
                try {

                    val networkForecast =
                        remoteDataSourceSource.getForecast(cachedCity.lat!!, cachedCity.lon!!)

                    forecastLocalDataSource.updateForecast(
                        networkForecast.data,
                        cachedWeather,
                        cityId
                    )

                    val cityFromNetwork =
                        remoteDataSourceSource.getCurrentWeather(cachedCity.lat!!, cachedCity.lon!!)

                    cityLocalDataSource.updateCity(
                        cityFromNetwork.data[0],
                        cachedCity,
                        cachedCity.id
                    )
                    cachedWeather = forecastLocalDataSource.getForecast(cityId)
                    emit(NetworkDataState.Success(cachedWeather))

                } catch (e: HttpException) {
                    emit(NetworkDataState.Error(e))
                } catch (e: IOException) {
                    emit(NetworkDataState.Error(e))
                } catch (e: UnknownHostException) {
                    emit(NetworkDataState.Error(e))

                }


            }

            else -> {

                emit(NetworkDataState.Success(cachedWeather))

            }
        }
    }
}