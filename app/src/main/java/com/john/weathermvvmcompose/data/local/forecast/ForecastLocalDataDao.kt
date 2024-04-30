package com.john.weathermvvmcompose.data.local.forecast

import androidx.room.*
import com.john.weathermvvmcompose.model.City
import com.john.weathermvvmcompose.model.Forecast

@Dao
interface ForecastLocalDataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertForecast(forecast: Forecast): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateForecast(forecast: Forecast)

    @Query("SELECT * FROM forecast WHERE cityId = :cityId")
    suspend fun getForecast(cityId: Long): List<Forecast>

    @Query("DELETE FROM forecast WHERE cityId = :cityId")
    suspend fun deleteForecast(cityId: Long)

    @Query("DELETE FROM forecast")
    suspend fun clearAllForecast()
}