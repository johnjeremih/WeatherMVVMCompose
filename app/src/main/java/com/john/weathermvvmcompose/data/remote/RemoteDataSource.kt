package com.john.weathermvvmcompose.data.remote

import com.john.weathermvvmcompose.model.City
import com.john.weathermvvmcompose.model.DataResponse
import com.john.weathermvvmcompose.model.Forecast


interface RemoteDataSource {

    suspend fun getCurrentWeather(lat: Double, lon: Double): DataResponse<City>
    suspend fun getForecast(lat: Double, lon: Double): DataResponse<Forecast>

}