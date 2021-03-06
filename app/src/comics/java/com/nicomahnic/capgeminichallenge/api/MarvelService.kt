package com.nicomahnic.capgeminichallenge.api

import com.nicomahnic.capgeminichallenge.data.datasource.network.models.MarvelNetworkResponse
import com.nicomahnic.capgeminichallenge.data.repository.MarvelItemsRepositoryImpl
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelService {

    @GET("v1/public/comics")
    suspend fun getCharacters(
        @Query("ts") ts: Long,
        @Query("hash") hash: String,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int = MarvelItemsRepositoryImpl.ITEMS_PER_PAGE,
    ) : Response<MarvelNetworkResponse>

}
