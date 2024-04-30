package com.john.weathermvvmcompose.modules

import android.content.Context
import androidx.room.Room
import com.john.weathermvvmcompose.data.local.city.CityDaoLocalService
import com.john.weathermvvmcompose.data.local.city.CityDaoLocalServiceImpl
import com.john.weathermvvmcompose.data.mapper.CityMapper
import com.john.weathermvvmcompose.data.mapper.ForecastMapper
import com.john.weathermvvmcompose.data.local.Database
import com.john.weathermvvmcompose.data.local.city.CityLocalDataDao
import com.john.weathermvvmcompose.data.local.city.CityLocalDataSource
import com.john.weathermvvmcompose.data.local.city.CityLocalDataSourceImpl
import com.john.weathermvvmcompose.data.local.forecast.ForecastDaoLocalService
import com.john.weathermvvmcompose.data.local.forecast.ForecastDaoLocalServiceImpl
import com.john.weathermvvmcompose.data.local.forecast.ForecastLocalDataDao
import com.john.weathermvvmcompose.data.local.forecast.ForecastLocalDataSource
import com.john.weathermvvmcompose.data.local.forecast.ForecastLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Singleton
    @Provides
    fun provideCacheMapper(): ForecastMapper {
        return ForecastMapper()
    }

    @Singleton
    @Provides
    fun provideCitiesDb(@ApplicationContext context: Context): Database {
        return Room
            .databaseBuilder(
                context,
                Database::class.java,
                Database.DATABASE_NAME
            )
            .fallbackToDestructiveMigration()
            .build()
    }


    @Singleton
    @Provides
    fun provideCityLocalDataDao(database: Database): CityLocalDataDao {
        return database.cityLocalDataDao()
    }

    @Singleton
    @Provides
    fun provideForecastLocalDataDao(database: Database): ForecastLocalDataDao {
        return database.forecastLocalDataDao()
    }

    @Singleton
    @Provides
    fun provideCityDaoService(
        localDataDao: CityLocalDataDao
    ): CityDaoLocalService {
        return CityDaoLocalServiceImpl(localDataDao)
    }

    @Singleton
    @Provides
    fun provideForecastDaoService(
        localDataDao: ForecastLocalDataDao
    ): ForecastDaoLocalService {
        return ForecastDaoLocalServiceImpl(localDataDao)
    }

    @Singleton
    @Provides
    fun provideCityLocalDataSource(
        cityDaoLocalService: CityDaoLocalService,
        cityMapper: CityMapper
    ): CityLocalDataSource {
        return CityLocalDataSourceImpl(cityDaoLocalService,cityMapper)
    }

    @Singleton
    @Provides
    fun provideForecastLocalDataSource(
        forecastDaoLocalService: ForecastDaoLocalService,
        forecastMapper: ForecastMapper
    ): ForecastLocalDataSource {
        return ForecastLocalDataSourceImpl(forecastDaoLocalService,forecastMapper)
    }

}

























