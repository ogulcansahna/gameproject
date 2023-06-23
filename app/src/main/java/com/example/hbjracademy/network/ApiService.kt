package com.example.hbjracademy.network

import com.example.hbjracademy.network.models.GameDetailsResponseDto
import com.example.hbjracademy.network.models.GamesResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("lists/main")
    suspend fun getGames(
        @Query("key") apiKey: String,
        @Query("ordering") ordering: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): Response<GamesResponseDto>

    @GET("{id}")
    suspend fun getGameDetails(
        @Path("id") gameId: Int,
        @Query("key") apiKey: String
    ): Response<GameDetailsResponseDto>
}