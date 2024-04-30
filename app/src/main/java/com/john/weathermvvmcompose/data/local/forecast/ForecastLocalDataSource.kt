package com.john.weathermvvmcompose.data.local.forecast

import com.john.weathermvvmcompose.model.City
import com.john.weathermvvmcompose.model.Forecast

interface ForecastLocalDataSource {

    //Forecast
    suspend fun insertForecast(forecastList: List<Forecast>, cityId: Long)

    suspend fun updateForecast(forecastList: List<Forecast>, forecastCacheList: List<Forecast>, cityId: Long)

    suspend fun getForecast(cityId: Long): List<Forecast>

    suspend fun deleteForecast(cityId: Long)

    suspend fun clearAllForecast()

}