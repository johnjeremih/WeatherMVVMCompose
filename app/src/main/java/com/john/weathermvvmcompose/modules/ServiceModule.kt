package com.john.weathermvvmcompose.modules

import com.john.weathermvvmcompose.data.remote.RemoteDataSource
import com.john.weathermvvmcompose.data.remote.RemoteDataSourceSourceImpl
import com.john.weathermvvm.repository.service.WeatherService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Singleton
    @Provides
    fun provideServiceRepository(
        weatherService: WeatherService,
    ): RemoteDataSource {
        return RemoteDataSourceSourceImpl(weatherService = weatherService)
    }

}