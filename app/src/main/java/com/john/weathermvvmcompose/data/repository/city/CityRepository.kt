package com.john.weathermvvmcompose.data.repository.city

import com.john.weathermvvmcompose.model.City
import com.john.weathermvvmcompose.model.NetworkDataState
import kotlinx.coroutines.flow.Flow

interface CityRepository {

    fun getCities(
        lat: Double?,
        lon: Double?
    ): Flow<NetworkDataState<List<City>>>

    fun getCity(cityId: Long, isRefreshing: Boolean): Flow<NetworkDataState<City>>

    fun deleteCity(cityId: Long): Flow<NetworkDataState<Boolean>>

}
