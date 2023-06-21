package com.example.hbjracademy.domain.repository

import com.example.hbjracademy.data.remote.dto.gamesDto

interface gamesRepository {
    suspend fun getGames() : List<gamesDto>
}