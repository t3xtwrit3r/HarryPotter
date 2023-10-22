package com.mubin.harrypotter.repository

import com.mubin.harrypotter.api.ApiService
import javax.inject.Inject

class AppRepository
@Inject
constructor(private val apiService: ApiService) {
    suspend fun getCharacters()  = apiService.getCharacters()

}