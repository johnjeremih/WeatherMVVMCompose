package com.john.weathermvvmcompose.model

import com.google.gson.annotations.SerializedName


data class DataResponse<T>(
    @SerializedName("data")
    val `data`: ArrayList<T>)
