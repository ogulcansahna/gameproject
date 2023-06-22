package com.example.hbjracademy.repository.data_source

import com.example.hbjracademy.common.Constants
import com.example.hbjracademy.domain.models.GamesResponse
import com.example.hbjracademy.domain.repository.GamesRepository
import com.example.hbjracademy.network.ApiService
import com.example.hbjracademy.network.utils.SafeApiRequest
import com.example.hbjracademy.repository.mappers.toDomain

class GamesRepositoryImpl constructor(private val apiService: ApiService) : GamesRepository,
    SafeApiRequest() {

    override suspend fun getGames(ordering: String, page: Int, perPage: Int): GamesResponse {
        println("Game in gameRepoImpl")

        val getGamesResponse = safeApiRequest {
            apiService.getGames(
                apiKey = Constants.API_KEY,
                ordering = ordering,
                page = page,
                perPage = perPage
            )
        }
        return getGamesResponse.toDomain()
    }
}