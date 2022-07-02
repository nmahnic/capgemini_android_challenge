package com.nicomahnic.capgeminichallenge.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.nicomahnic.capgeminichallenge.models.MarvelCharacter
import com.nicomahnic.capgeminichallenge.repository.CharactersPagingSource
import kotlinx.coroutines.flow.Flow

class HomeViewModel constructor(
    private val charactersPagingSource: CharactersPagingSource
): ViewModel() {

    val items: Flow<PagingData<MarvelCharacter>> = Pager(
        config = PagingConfig(pageSize = ITEMS_PER_PAGE, enablePlaceholders = false),
        pagingSourceFactory = { charactersPagingSource }
    )
        .flow
        .cachedIn(viewModelScope)

    companion object {
        private const val ITEMS_PER_PAGE = 10
    }

}