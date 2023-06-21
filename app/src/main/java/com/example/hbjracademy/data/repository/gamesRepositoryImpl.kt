package com.example.hbjracademy.data.repository

import com.example.hbjracademy.data.remote.dto.gamesDto
import com.example.hbjracademy.data.remote.gamesApi
import com.example.hbjracademy.domain.repository.gamesRepository
import javax.inject.Inject

class gamesRepositoryImpl @Inject constructor(
    private val api: gamesApi
) : gamesRepository {
    override suspend fun getGames(): List<gamesDto> {
        return api.getGames()
    }

}