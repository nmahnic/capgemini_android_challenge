package com.nicomahnic.capgeminichallenge.data.repository

import androidx.paging.PagingData
import com.nicomahnic.capgeminichallenge.data.datasource.database.models.MarvelItemEntity
import com.nicomahnic.capgeminichallenge.domain.models.MarvelItem
import kotlinx.coroutines.flow.Flow

interface MarvelItemsRepository {

    suspend fun insertMarvelItem(marvelItemEntity: MarvelItemEntity)

    suspend fun deleteMarvelItem(marvelItemEntity: MarvelItemEntity)

    suspend fun getMarvelItem(id: Int? = null) : MarvelItemEntity?

    suspend fun readAllMarvelItems() : List<MarvelItemEntity?>?

    fun getItems() : Flow<PagingData<MarvelItem>>

}