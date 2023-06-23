package com.example.hbjracademy.repository.data_source

import com.example.hbjracademy.common.Constants
import com.example.hbjracademy.domain.models.GameDetailsResponse
import com.example.hbjracademy.domain.repository.GameDetailsRepository
import com.example.hbjracademy.network.ApiService
import com.example.hbjracademy.network.utils.SafeApiRequest
import com.example.hbjracademy.repository.mappers.toDomain

class GameDetailsRepositoryImpl constructor(private val apiService: ApiService) :
    GameDetailsRepository, SafeApiRequest() {

    override suspend fun getGameDetails(gameId: Int): GameDetailsResponse {
        println("GameId in gameDetailsRepoImpl: $gameId")
        val gameDetailsResponse = safeRequest {
            apiService.getGameDetails(
                apiKey = Constants.API_KEY,
                gameId = gameId
            )
        }
        return gameDetailsResponse.toDomain()
    }
}