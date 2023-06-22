package com.example.hbjracademy.data.remote

import com.example.hbjracademy.data.remote.dto.gamesDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface gamesApi {

   // @GET("https://rawg.io/api/games/lists/main?key=0385f9ff9b6a4bef90f44da6e5d34850")
    @GET("lists/main?")
    suspend fun getGames(@Query("key") apiKey: String, @Query("ordering") ordering: String,
    @Query("page") page: Int,
    @Query("per_page") perPage: Int) : List<gamesDto>

}