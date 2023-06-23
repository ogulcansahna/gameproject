package com.example.hbjracademy.domain.repository

import com.example.hbjracademy.domain.models.GamesResponse

interface GamesRepository {

    suspend fun getGames(ordering:String, page:Int, perPage:Int): GamesResponse
}