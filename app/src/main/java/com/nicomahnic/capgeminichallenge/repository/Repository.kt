package com.nicomahnic.capgeminichallenge.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.nicomahnic.capgeminichallenge.datasource.FetchMarvelCharacter
import com.nicomahnic.capgeminichallenge.models.MarvelCharacter
import com.nicomahnic.capgeminichallenge.viewmodels.HomeViewModel
import kotlinx.coroutines.flow.Flow

class Repository constructor(
    private val charactersPagingSource: CharactersPagingSource
) {

    fun getCharacters() : Flow<PagingData<MarvelCharacter>> = Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE, enablePlaceholders = false),
            pagingSourceFactory = { charactersPagingSource }
        ).flow

    companion object {
        const val ITEMS_PER_PAGE = 15
    }
}