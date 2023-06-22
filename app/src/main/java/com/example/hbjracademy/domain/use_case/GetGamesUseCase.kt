package com.example.hbjracademy.domain.use_case

import com.example.hbjracademy.common.Resource
import com.example.hbjracademy.domain.models.GamesResponse
import com.example.hbjracademy.domain.repository.GamesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetGamesUseCase constructor(private val gameRepository: GamesRepository) {

    operator fun invoke(ordering: String, page: Int, perPage: Int): Flow<Resource<GamesResponse>> =
        flow {
            emit(Resource.Loading())
            val gamesResponse = gameRepository.getGames(ordering, page, perPage)
            emit(Resource.Success(gamesResponse))
        }

}