package com.john.weathermvvmcompose.data.local.forecast

import com.john.weathermvvmcompose.model.Forecast

class ForecastDaoLocalServiceImpl
constructor(
    private val forecastLocalDataDao: ForecastLocalDataDao
): ForecastDaoLocalService {

    override suspend fun insertForecast(forecast: Forecast): Long {
        return forecastLocalDataDao.insertForecast(forecast)
    }

    override suspend fun updateForecast(forecast: Forecast) {
        return forecastLocalDataDao.updateForecast(forecast)
    }

    override suspend fun getForecast(cityId: Long): List<Forecast> {
        return forecastLocalDataDao.getForecast(cityId)
    }

    override suspend fun deleteForecast(cityId: Long) {
        forecastLocalDataDao.deleteForecast(cityId)
    }

    override suspend fun clearAllForecast() {
        forecastLocalDataDao.clearAllForecast()
    }



}