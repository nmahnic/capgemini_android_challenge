package com.nicomahnic.capgeminichallenge.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.nicomahnic.capgeminichallenge.models.MarvelItem
import kotlinx.coroutines.flow.Flow

class Repository constructor(
    private val charactersPagingSource: CharactersPagingSource,
) {

    fun getCharacters() : Flow<PagingData<MarvelItem>> = Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE, enablePlaceholders = false),
            pagingSourceFactory = { charactersPagingSource }
        ).flow

    companion object {
        const val ITEMS_PER_PAGE = 15
    }
}