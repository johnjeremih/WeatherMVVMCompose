package com.john.weathermvvmcompose.data.local.forecast

import com.john.weathermvvmcompose.model.City
import com.john.weathermvvmcompose.model.Forecast
import com.john.weathermvvmcompose.data.local.city.CityDaoLocalService
import com.john.weathermvvmcompose.data.local.forecast.ForecastDaoLocalService
import com.john.weathermvvmcompose.data.mapper.ForecastMapper
import com.john.weathermvvmcompose.data.mapper.CityMapper

class ForecastLocalDataSourceImpl
constructor(
    private val forecastDaoLocalService: ForecastDaoLocalService,
    private val forecastMapper: ForecastMapper,
) : ForecastLocalDataSource {


    override suspend fun insertForecast(forecastList: List<Forecast>, cityId: Long) {

        for (forecast in forecastList.take(5)) {

            forecastDaoLocalService.insertForecast(forecastMapper.buildModel(forecast, null, cityId))

        }
    }

    override suspend fun updateForecast(
        forecastList: List<Forecast>,
        forecastCacheList: List<Forecast>,
        cityId: Long
    ) {

        for ((positionCounter, forecast) in forecastList.take(5).withIndex()) {

            forecastDaoLocalService.updateForecast(
                forecastMapper.buildModel(
                    forecast,
                    forecastCacheList[positionCounter],
                    cityId
                )
            )

        }
    }

    override suspend fun getForecast(cityId: Long): List<Forecast> {
        return forecastDaoLocalService.getForecast(cityId)
    }

    override suspend fun deleteForecast(cityId: Long) {
        forecastDaoLocalService.deleteForecast(cityId)
    }

    override suspend fun clearAllForecast() {
        forecastDaoLocalService.clearAllForecast()
    }


}
