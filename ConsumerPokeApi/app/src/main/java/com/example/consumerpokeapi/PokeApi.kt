package com.example.consumerpokeapi

import com.example.consumerpokeapi.models.Pokemon
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApi {
    @GET("pokemon/{name}")
    suspend fun getPersonagem(@Path("name") name: String) : Response<Pokemon>
}