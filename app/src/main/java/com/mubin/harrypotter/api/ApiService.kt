package com.mubin.harrypotter.api

import com.mubin.harrypotter.api.models.CharacterDetailsResponse
import com.mubin.harrypotter.api.models.CharacterListResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("characters")
    suspend fun getCharacters() : CharacterListResponse

    @GET("characters/{id}")
    suspend fun getCharacterDetails(@Path("id") id: String) : CharacterDetailsResponse

}