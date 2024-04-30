package com.john.weathermvvmcompose.data.mapper

interface EntityMapper<T, R, Q> {

    fun buildModel(entity: T, cachedEntity: R, id:Q?): R

}