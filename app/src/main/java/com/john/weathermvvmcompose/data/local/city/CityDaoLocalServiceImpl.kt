package com.john.weathermvvmcompose.data.local.city

import com.john.weathermvvmcompose.model.City

class CityDaoLocalServiceImpl
constructor(
    private val cityLocalDataDao: CityLocalDataDao
): CityDaoLocalService {

    override suspend fun insertCity(city: City): Long {
        return cityLocalDataDao.insertCity(city)
    }

    override suspend fun updateCity(city: City) {
        cityLocalDataDao.update(city)
    }

    override suspend fun getCities(): List<City> {
        return cityLocalDataDao.getCities()
    }

    override suspend fun getCity(cityId: Long): City {
       return cityLocalDataDao.getCity(cityId)
    }

    override suspend fun deleteCity(cityId: Long) {
        return cityLocalDataDao.deleteCity(cityId)
    }

    override suspend fun clearALL() {
      return cityLocalDataDao.clearALL()
    }

}