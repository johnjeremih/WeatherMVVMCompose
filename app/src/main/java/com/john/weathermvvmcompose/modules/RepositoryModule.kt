package com.john.weathermvvmcompose.modules

import com.john.weathermvvmcompose.data.local.city.CityLocalDataSource
import com.john.weathermvvmcompose.data.local.forecast.ForecastLocalDataSource
import com.john.weathermvvmcompose.data.remote.RemoteDataSource
import com.john.weathermvvmcompose.data.repository.city.CityRepository
import com.john.weathermvvmcompose.data.repository.city.CityRepositoryImpl
import com.john.weathermvvmcompose.data.repository.forecast.ForecastRepository
import com.john.weathermvvmcompose.data.repository.forecast.ForecastRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideCityRepository(
        cityLocalDataSource: CityLocalDataSource,
        forecastLocalDataSource: ForecastLocalDataSource,
        remoteDataSource: RemoteDataSource
    ): CityRepository {
        return CityRepositoryImpl(cityLocalDataSource,forecastLocalDataSource, remoteDataSource)
    }

    @Singleton
    @Provides
    fun provideForecastRepository(
        cityLocalDataSource: CityLocalDataSource,
        forecastLocalDataSource: ForecastLocalDataSource,
        remoteDataSource: RemoteDataSource
    ): ForecastRepository {
        return ForecastRepositoryImpl(cityLocalDataSource,forecastLocalDataSource, remoteDataSource)
    }
}