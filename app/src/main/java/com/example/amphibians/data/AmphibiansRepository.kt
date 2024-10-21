package com.example.amphibians.data

import com.example.amphibians.model.Amphibians
import com.example.amphibians.network.AmphibiansApiService

interface AmphibiansRepository {
    suspend fun getAmphibiansInfo() : List<Amphibians>
}

class NetworkAmphibiansRepository(val AmphibiansApiService:AmphibiansApiService):AmphibiansRepository{

    override suspend fun getAmphibiansInfo(): List<Amphibians> = AmphibiansApiService.getAmphibians()
}
