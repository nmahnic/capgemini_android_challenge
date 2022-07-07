package com.nicomahnic.capgeminichallenge.api

import com.nicomahnic.capgeminichallenge.datasource.network.models.MarvelNetworkResponse
import com.nicomahnic.capgeminichallenge.repository.PagingRepository
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelService {

    @GET("v1/public/characters")
    suspend fun getCharacters(
        @Query("ts") ts: Long,
        @Query("hash") hash: String,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int = PagingRepository.ITEMS_PER_PAGE,
    ) : Response<MarvelNetworkResponse>

}
