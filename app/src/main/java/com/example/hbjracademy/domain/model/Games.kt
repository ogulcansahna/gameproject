package com.example.hbjracademy.domain.model

import com.example.hbjracademy.data.remote.dto.*

data class Games(
    val added: Int?,
    val backgroundImage: String?,
    val clip: String?,
    val communityRating: Int?,
    val dominantColor: String?,
    val genres: List<Genre>?,
    val id: Int?,
    val name: String?,
    val platforms: List<Platform>?,
    val metacritic:Int?,
    val playtime: Int?,
    val rating: Double?,
    val ratingTop: Int?,
    val ratings: List<Rating>?,
    val ratingsCount: Int?,
    val released: String?,
    val reviewsCount: Int?,
    val reviewsTextCount: Int?,
    val saturatedColor: String?,
    val shortScreenshots: List<ShortScreenshot>?,
    val slug: String?,
    val suggestionsCount: Int?,
    val tags: List<Tag>?,
    val tba: Boolean?,
    val updated: String?
)
