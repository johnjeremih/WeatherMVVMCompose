package com.john.weathermvvmcompose.data.local.forecast

import com.john.weathermvvmcompose.model.Forecast


interface ForecastDaoLocalService {

    suspend fun insertForecast(forecast: Forecast): Long

    suspend fun updateForecast(forecast: Forecast)

    suspend fun getForecast(cityId: Long): List<Forecast>

    suspend fun deleteForecast(cityId: Long)

    suspend fun clearAllForecast()
}