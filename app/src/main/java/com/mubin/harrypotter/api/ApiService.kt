package com.mubin.harrypotter.api

import com.mubin.harrypotter.api.models.CharacterDetailsResponse
import com.mubin.harrypotter.api.models.CharacterListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("characters")
    suspend fun getCharacters() : Response<CharacterListResponse>

    @GET("character/{id}")
    suspend fun getCharacterDetails(@Path("id") id: String) : Response<CharacterDetailsResponse>

}