package com.example.hbjracademy.data.remote.dto

import com.example.hbjracademy.domain.model.Games

data class gamesDto(
    val added: Int,
    val added_by_status: AddedByStatus,
    val background_image: String,
    val clip: Any,
    val dominant_color: String,
    val esrb_rating: Any,
    val genres: List<Genre>,
    val id: Int,
    val metacritic: Any,
    val name: String,
    val parent_platforms: List<ParentPlatform>,
    val platforms: List<PlatformX>,
    val playtime: Int,
    val rating: Double,
    val rating_top: Int,
    val ratings: List<Rating>,
    val ratings_count: Int,
    val released: String,
    val reviews_count: Int,
    val reviews_text_count: Int,
    val saturated_color: String,
    val short_screenshots: List<ShortScreenshot>,
    val slug: String,
    val stores: List<Store>,
    val suggestions_count: Int,
    val tags: List<Tag>,
    val tba: Boolean,
    val updated: String,
    val user_game: Any
)

fun gamesDto.toGame(): Games{
    return Games(
        added=added,
        added_by_status=added_by_status,
        background_image=background_image,
        clip=clip,
        dominant_color=dominant_color,
        genres=genres,
        esrb_rating=esrb_rating,
        id=id,
        metacritic=metacritic,
        name=name,
        parent_platforms=parent_platforms,
        platforms=platforms,
        playtime=playtime,
        rating=rating,
        rating_top=rating_top,
        ratings=ratings,
        ratings_count=ratings_count,
        released=released,
        reviews_count=reviews_count,
        reviews_text_count=reviews_text_count,
        saturated_color=saturated_color,
        short_screenshots=short_screenshots,
        slug=slug,
        stores=stores,
        suggestions_count=suggestions_count,
        tags=tags,
        updated=updated,
        tba=tba,
        user_game=user_game
    )
}