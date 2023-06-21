package com.example.hbjracademy.data.remote

import com.example.hbjracademy.data.remote.dto.gamesDto
import retrofit2.http.GET

interface gamesApi {


    @GET("https://rawg.io/api/games/lists/main?key=0385f9f f9b6a4bef90f44da6e5d34850")
    suspend fun getGames() : List<gamesDto>
}