package com.john.weathermvvmcompose.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.john.weathermvvmcompose.data.local.city.CityLocalDataDao
import com.john.weathermvvmcompose.data.local.forecast.ForecastLocalDataDao
import com.john.weathermvvmcompose.model.City
import com.john.weathermvvmcompose.model.Forecast

@Database(entities = [City::class, Forecast::class], version = 1,exportSchema = false)
abstract class Database : RoomDatabase() {

    abstract fun cityLocalDataDao(): CityLocalDataDao
    abstract fun forecastLocalDataDao(): ForecastLocalDataDao

    companion object{
        const val DATABASE_NAME: String = "weather_db"
    }
}