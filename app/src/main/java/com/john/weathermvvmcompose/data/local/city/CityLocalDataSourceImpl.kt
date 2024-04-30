package com.john.weathermvvmcompose.data.local.city

import com.john.weathermvvmcompose.model.City
import com.john.weathermvvmcompose.model.Forecast
import com.john.weathermvvmcompose.data.local.city.CityDaoLocalService
import com.john.weathermvvmcompose.data.local.forecast.ForecastDaoLocalService
import com.john.weathermvvmcompose.data.mapper.ForecastMapper
import com.john.weathermvvmcompose.data.mapper.CityMapper

class CityLocalDataSourceImpl
constructor(
    private val cityDaoLocalService: CityDaoLocalService,
    private val cityMapper: CityMapper
) : CityLocalDataSource {

    override suspend fun insertCity(city: City): Long {
        return cityDaoLocalService.insertCity(city)
    }

    override suspend fun updateCity(city: City, cachedCity: City, cityId: Long?) {
         cityDaoLocalService.updateCity(cityMapper.buildModel(city, cachedCity, cityId))
    }

    override suspend fun getCities(): List<City> {
        return cityDaoLocalService.getCities()
    }

    override suspend fun getCity(cityId: Long): City {
        return cityDaoLocalService.getCity(cityId)
    }

    override suspend fun deleteCity(cityId: Long) {
        cityDaoLocalService.deleteCity(cityId).toString()
    }

    override suspend fun clearALL() {
        return cityDaoLocalService.clearALL()
    }


}
