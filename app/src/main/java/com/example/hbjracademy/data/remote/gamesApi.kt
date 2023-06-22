package com.example.hbjracademy.data.remote

import com.example.hbjracademy.data.remote.dto.gamesDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface gamesApi {

    @GET("lists/main?")
    suspend fun getGames(@Query("key") apiKey: String, @Query("ordering") ordering: String,
                         @Query("page") page: Int,
                         @Query("per_page") perPage: Int) : List<gamesDto>

}