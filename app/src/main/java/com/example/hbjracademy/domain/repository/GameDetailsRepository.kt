package com.example.hbjracademy.domain.repository

import com.example.hbjracademy.domain.models.GameDetailsResponse

interface GameDetailsRepository {

    suspend fun getGameDetails(gameId:Int): GameDetailsResponse

}