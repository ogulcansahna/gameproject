package com.example.hbjracademy.network.models

import com.google.gson.annotations.SerializedName

data class ShortScreenshotDto(
    @SerializedName("id")
    val id: Int?,

    @SerializedName("image")
    val image: String?
)