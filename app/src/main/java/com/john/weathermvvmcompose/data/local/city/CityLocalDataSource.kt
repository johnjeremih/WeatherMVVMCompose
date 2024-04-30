package com.john.weathermvvmcompose.data.local.city

import com.john.weathermvvmcompose.model.City
import com.john.weathermvvmcompose.model.Forecast

interface CityLocalDataSource {

    //City

    suspend fun insertCity(city: City): Long

    suspend fun updateCity(city: City, cachedCity: City, cityId: Long?)

    suspend fun getCities(): List<City>

    suspend fun getCity(cityId: Long): City

    suspend fun deleteCity(cityId: Long)

    suspend fun clearALL()

}