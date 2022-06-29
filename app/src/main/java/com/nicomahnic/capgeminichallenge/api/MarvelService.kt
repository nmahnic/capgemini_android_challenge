package com.nicomahnic.capgeminichallenge.api

import com.nicomahnic.capgeminichallenge.models.MarvelCharacterResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelService {

    @GET("v1/public/characters")
    suspend fun getCharacters(
        @Query("ts") ts: Long,
        @Query("hash") hash: String,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int = 10,
    ) : Response<MarvelCharacterResponse>

}
