package com.john.weathermvvm.modules

import com.john.weathermvvmcompose.data.remote.UrlMainProvider
import com.john.weathermvvmcompose.data.remote.UrlProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UrlProviderModule {


      @Singleton
      @Binds
      abstract fun provideUrlProvider(urlMainProvider: UrlMainProvider): UrlProvider

}