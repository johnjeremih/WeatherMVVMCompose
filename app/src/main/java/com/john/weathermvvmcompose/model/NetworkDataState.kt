package com.john.weathermvvmcompose.model

sealed class NetworkDataState<out R> {
    data class Success<out T>(val data: T) : NetworkDataState<T>()
    data class Error(val exception: Exception) : NetworkDataState<Nothing>()
    data object Loading : NetworkDataState<Nothing>()
}