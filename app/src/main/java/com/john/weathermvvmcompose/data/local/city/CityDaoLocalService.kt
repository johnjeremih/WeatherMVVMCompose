package com.john.weathermvvmcompose.data.local.city

import com.john.weathermvvmcompose.model.City


interface CityDaoLocalService {

    //City

    suspend fun insertCity(city: City): Long

    suspend fun updateCity(city: City)

    suspend fun getCities(): List<City>

    suspend fun getCity(cityId: Long): City

    suspend fun deleteCity(cityId: Long)

    suspend fun clearALL()

}