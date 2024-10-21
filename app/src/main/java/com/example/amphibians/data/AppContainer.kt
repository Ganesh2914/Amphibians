package com.example.amphibians.data

import com.example.amphibians.network.AmphibiansApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val AmphibiansRepository:AmphibiansRepository
}

class DefaultAppContainer:AppContainer{
    private val baseUrl="https://android-kotlin-fun-mars-server.appspot.com/"

    private val retrofit : Retrofit= Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType())) // Fix here
        .build()


    private val retrofitService : AmphibiansApiService by lazy {
        retrofit.create(AmphibiansApiService::class.java)
    }
    override val AmphibiansRepository:AmphibiansRepository by lazy {
        NetworkAmphibiansRepository(retrofitService)
    }
}