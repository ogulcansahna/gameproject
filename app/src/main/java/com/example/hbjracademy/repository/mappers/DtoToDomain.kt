package com.example.hbjracademy.repository.mappers

import com.example.hbjracademy.domain.models.GamesResponse
import com.example.hbjracademy.domain.models.Genre
import com.example.hbjracademy.domain.models.PlatformDetail
import com.example.hbjracademy.domain.models.Platforms
import com.example.hbjracademy.domain.models.GameDetailsResponse
import com.example.hbjracademy.domain.models.Rating
import com.example.hbjracademy.domain.models.Game
import com.example.hbjracademy.domain.models.ShortScreenshot
import com.example.hbjracademy.domain.models.Tag
import com.example.hbjracademy.domain.models.Developer
import com.example.hbjracademy.domain.models.Publisher
import com.example.hbjracademy.network.models.GamesResponseDto
import com.example.hbjracademy.network.models.GenreDto
import com.example.hbjracademy.network.models.PlatformDetailDto
import com.example.hbjracademy.network.models.PlatformsDto
import com.example.hbjracademy.network.models.RatingDto
import com.example.hbjracademy.network.models.GameDto
import com.example.hbjracademy.network.models.GameDetailsResponseDto
import com.example.hbjracademy.network.models.ShortScreenshotDto
import com.example.hbjracademy.network.models.TagDto
import com.example.hbjracademy.network.models.DeveloperDto
import com.example.hbjracademy.network.models.PublisherDto

internal fun GamesResponseDto.toDomain(): GamesResponse {
    return GamesResponse(
        count = this.count,
        games_count = this.games_count,
        next = this.next,
        previous = this.previous,
        recommendations_count = this.recommendations_count,
        results = this.games?.map { it.toDomain() },
        reviews_count = this.reviews_count
    )
}

internal fun GenreDto.toDomain(): Genre {
    return Genre(
        games_count = this.gamesCount,
        id = this.id,
        image_background = this.imageBackground,
        name = this.name,
        slug = this.slug
    )
}

internal fun PlatformDetailDto.toDomain(): PlatformDetail {
    return PlatformDetail(
        games_count = this.gamesCount,
        id = this.id,
        image = this.image,
        image_background = this.imageBackground,
        name = this.name,
        slug = this.slug,
        year_end = this.yearEnd,
        year_start = this.yearStart
    )
}

internal fun PlatformsDto.toDomain(): Platforms {
    return Platforms(
        platformDetail = this.platformDetail?.toDomain()
    )

}

internal fun RatingDto.toDomain(): Rating {
    return Rating(
        count = this.count,
        id = this.id,
        percent = this.percent,
        title = this.title
    )
}

internal fun GameDto.toDomain(): Game {
    return Game(
        added = this.added,
        background_image = this.backgroundImage,
        clip = this.clip,
        community_rating = this.communityRating,
        dominant_color = this.dominantColor,
        genres = this.genres?.map { it.toDomain() },
        id = this.id,
        name = this.name,
        platforms = this.platforms?.map { it.toDomain() },
        playtime = this.playtime,
        metacritic = this.metacritic,
        rating = this.rating,
        rating_top = this.ratingTop,
        ratings = this.ratings?.map { it.toDomain() },
        ratings_count = this.ratingsCount,
        released = this.released,
        reviews_count = this.reviewsCount,
        reviews_text_count = this.reviewsTextCount,
        saturated_color = this.saturatedColor,
        short_screenshots = this.shortScreenshots?.map { it.toDomain() },
        slug = this.slug,
        suggestions_count = this.suggestionsCount,
        tags = this.tags?.map { it.toDomain() },
        tba = this.tba,
        updated = this.updated
    )
}

internal fun ShortScreenshotDto.toDomain(): ShortScreenshot {
    return ShortScreenshot(
        id = this.id,
        image = this.image
    )
}

internal fun TagDto.toDomain(): Tag {
    return Tag(
        games_count = this.gamesCount,
        id = this.id,
        image_background = this.imageBackground,
        language = this.language,
        name = this.name,
        slug = this.slug
    )
}

internal fun DeveloperDto.toDomain(): Developer {
    return Developer(
        gamesCount = this.gamesCount,
        id = this.id,
        imageBackground = this.imageBackground,
        name = this.name,
        slug = this.slug
    )
}

internal fun PublisherDto.toDomain(): Publisher {
    return Publisher(
        gamesCount = this.gamesCount,
        id = this.id,
        imageBackground = this.imageBackground,
        name = this.name,
        slug = this.slug
    )
}

internal fun GameDetailsResponseDto.toDomain(): GameDetailsResponse {
    return GameDetailsResponse(
        achievementsCount = this.achievementsCount,
        added = this.added,
        additionsCount = this.additionsCount,
        backgroundImage = this.backgroundImage,
        backgroundImageAdditional = this.backgroundImageAdditional,
        clip = this.clip,
        creatorsCount = this.creatorsCount,
        description = this.description,
        descriptionRaw = this.descriptionRaw,
        developers = this.developer?.map { it.toDomain() },
        gameSeriesCount = this.gameSeriesCount,
        genres = this.genres?.map { it.toDomain() },
        id = this.id,
        metacritic = this.metacritic,
        moviesCount = this.moviesCount,
        name = this.name,
        nameOriginal = this.nameOriginal,
        parentAchievementsCount = this.parentAchievementsCount,
        platforms = this.platforms?.map { it.toDomain() },
        playtime = this.playtime,
        publishers = this.publisher?.map { it.toDomain() },
        rating = this.rating,
        ratingTop = this.ratingTop,
        ratings = this.ratings?.map { it.toDomain() },
        released = this.released,
        screenshotsCount = this.screenshotsCount,
        slug = this.slug,
        suggestionsCount = this.suggestionsCount,
        tags = this.tags?.map { it.toDomain() },
        tba = this.tba,
        updated = this.updated,
        website = this.website
    )
}