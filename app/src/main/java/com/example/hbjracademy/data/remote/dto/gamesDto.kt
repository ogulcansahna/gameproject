package com.example.hbjracademy.data.remote.dto

import com.example.hbjracademy.domain.model.Games
import com.google.gson.annotations.SerializedName

data class gamesDto(
    @SerializedName("added")
    val added: Int?,

    @SerializedName("background_image")
    val backgroundImage: String?,

    @SerializedName("clip")
    val clip: String?,

    @SerializedName("community_rating")
    val communityRating: Int?,

    @SerializedName("dominant_color")
    val dominantColor: String?,

    @SerializedName("genres")
    val genres: List<Genre>?,

    @SerializedName("id")
    val id: Int?,

    @SerializedName("name")
    val name: String?,

    @SerializedName("platforms")
    val platforms: List<Platform>?,

    @SerializedName("metacritic")
    val metacritic: Int?,

    @SerializedName("playtime")
    val playtime: Int?,

    @SerializedName("rating")
    val rating: Double?,

    @SerializedName("rating_top")
    val ratingTop: Int?,

    @SerializedName("ratings")
    val ratings: List<Rating>?,

    @SerializedName("ratings_count")
    val ratingsCount: Int?,

    @SerializedName("released")
    val released: String?,

    @SerializedName("reviews_count")
    val reviewsCount: Int?,

    @SerializedName("reviews_text_count")
    val reviewsTextCount: Int?,

    @SerializedName("saturated_color")
    val saturatedColor: String?,

    @SerializedName("short_screenshots")
    val shortScreenshots: List<ShortScreenshot>?,

    @SerializedName("slug")
    val slug: String?,

    @SerializedName("suggestions_count")
    val suggestionsCount: Int?,

    @SerializedName("tags")
    val tags: List<Tag>?,

    @SerializedName("tba")
    val tba: Boolean?,

    @SerializedName("updated")
    val updated: String?
)

fun gamesDto.toGame(): Games{
    return Games(
        added=added,
        backgroundImage = backgroundImage,
        clip=clip,
        communityRating = communityRating,
        dominantColor = dominantColor,
        genres=genres,
        id=id,
        metacritic=metacritic,
        name=name,
        platforms=platforms,
        playtime=playtime,
        rating=rating,
        ratingTop=ratingTop,
        ratings=ratings,
        ratingsCount=ratingsCount,
        released=released,
        reviewsCount=reviewsCount,
        reviewsTextCount=reviewsTextCount,
        saturatedColor=saturatedColor,
        shortScreenshots=shortScreenshots,
        slug=slug,
        suggestionsCount=suggestionsCount,
        tags=tags,
        tba=tba,
        updated=updated
    )
}