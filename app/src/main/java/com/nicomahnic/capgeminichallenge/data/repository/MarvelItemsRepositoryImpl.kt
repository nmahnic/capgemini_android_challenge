package com.nicomahnic.capgeminichallenge.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.nicomahnic.capgeminichallenge.data.datasource.database.MarvelItemDao
import com.nicomahnic.capgeminichallenge.data.datasource.database.models.MarvelItemEntity
import com.nicomahnic.capgeminichallenge.domain.models.MarvelItem
import kotlinx.coroutines.flow.Flow

class MarvelItemsRepositoryImpl constructor(
    private val marvelItemDao: MarvelItemDao,
    private val charactersPagingSource: CharactersPagingSource,
) : MarvelItemsRepository {

    override suspend fun insertMarvelItem(marvelItemEntity: MarvelItemEntity) {
        marvelItemDao.insertMarvelItem(marvelItemEntity)
    }

    override suspend fun deleteMarvelItem(marvelItemEntity: MarvelItemEntity) {
        marvelItemDao.deleteMarvelItem(marvelItemEntity)
    }

    override suspend fun getMarvelItem(id: Int?) = id?.let { marvelItemDao.getMarvelItem(id) }

    override suspend fun readAllMarvelItems() = marvelItemDao.readAllMarvelItems()


    override fun getItems() : Flow<PagingData<MarvelItem>> = Pager(
        config = PagingConfig(pageSize = ITEMS_PER_PAGE, enablePlaceholders = false),
        pagingSourceFactory = { charactersPagingSource }
    ).flow

    companion object {
        const val ITEMS_PER_PAGE = 15
    }

}