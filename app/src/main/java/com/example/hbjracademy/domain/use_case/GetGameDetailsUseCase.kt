package com.example.hbjracademy.domain.use_case

import com.example.hbjracademy.common.Resource
import com.example.hbjracademy.domain.models.GameDetailsResponse
import com.example.hbjracademy.domain.repository.GameDetailsRepository

class GetGameDetailsUseCase constructor(private val gameDetailsRepository: GameDetailsRepository) {

    suspend operator fun invoke(gameId: Int): Resource<GameDetailsResponse> {
        val gamesDetailsResponse = gameDetailsRepository.getGameDetails(gameId = gameId)
        return Resource.Success(gamesDetailsResponse)
    }
}