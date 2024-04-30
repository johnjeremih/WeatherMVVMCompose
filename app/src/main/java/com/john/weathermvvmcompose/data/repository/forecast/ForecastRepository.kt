package com.john.weathermvvmcompose.data.repository.forecast

import com.john.weathermvvmcompose.model.Forecast
import com.john.weathermvvmcompose.model.NetworkDataState
import kotlinx.coroutines.flow.Flow

interface ForecastRepository {

    fun getForecast(
        cityId: Long?,
        isRefreshing: Boolean
    ): Flow<NetworkDataState<List<Forecast>>>
}