package com.john.weathermvvmcompose.data.remote

import com.john.weathermvvmcompose.model.City
import com.john.weathermvvmcompose.model.DataResponse
import com.john.weathermvvmcompose.model.Forecast
import com.john.weathermvvm.repository.service.WeatherService


class RemoteDataSourceSourceImpl(var weatherService: WeatherService): RemoteDataSource {

    override suspend fun getCurrentWeather(lat: Double, lon: Double): DataResponse<City> {
        return weatherService.getCurrentWeather(lat, lon,"imperial")
    }

    override suspend fun getForecast(lat: Double, lon: Double): DataResponse<Forecast> {
        return weatherService.getForecast(lat, lon,"imperial")
    }


}