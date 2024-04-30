package com.john.weathermvvmcompose.data.mapper

import com.john.weathermvvmcompose.data.mapper.EntityMapper
import com.john.weathermvvmcompose.model.Forecast
import javax.inject.Inject

class ForecastMapper
@Inject constructor() : EntityMapper<Forecast, Forecast?, Long> {
    override fun buildModel(entity: Forecast, cachedEntity: Forecast?, id: Long?): Forecast {
        return Forecast(
            id = cachedEntity?.id,
            tempInF = entity.tempInF,
            tempInC = entity.tempInC,
            precipitation = entity.precipitation,
            cityId = id,
            weather = entity.weather,
            lastUpdate = entity.lastUpdate,
            timeStamp = entity.timeStamp,
            highTemp = entity.highTemp,
            lowTemp = entity.lowTemp,
            dateTime = entity.dateTime

        )
    }

}