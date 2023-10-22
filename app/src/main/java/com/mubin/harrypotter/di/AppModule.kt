package com.mubin.harrypotter.di

import com.google.gson.Gson
import com.mubin.harrypotter.api.ApiService
import com.mubin.harrypotter.api.RetrofitUtils.retrofitInstance
import com.mubin.harrypotter.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Named("apiHarryPotter")
    fun provideBaseUrlUnsplash() = Constants.baseUrl


    @Provides
    @Singleton
    fun provideRetrofitInstance(@Named("apiHarryPotter") baseUrl: String, gson: Gson, httpClient: OkHttpClient): ApiService =
        retrofitInstance(baseUrl = baseUrl, gson, httpClient)
            .create(ApiService::class.java)

}