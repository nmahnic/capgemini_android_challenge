package com.nicomahnic.capgeminichallenge.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.nicomahnic.capgeminichallenge.models.MarvelCharacter
import kotlin.math.max

class CharactersPagingSource constructor(
    private val fetchMarvelCharacter: FetchMarvelCharacter
) : PagingSource<Int, MarvelCharacter>() {

    companion object {
        private const val STARTING_KEY = 0
    }

    private fun ensureValidKey(key: Int) = max(STARTING_KEY, key)

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MarvelCharacter> {
        val start = params.key ?: STARTING_KEY
        val range = start.until(start + params.loadSize)

        val characters = fetchMarvelCharacter.request(start).body()?.data?.results

        return LoadResult.Page(
            data = characters!!,
            prevKey = when (start) {
                STARTING_KEY -> null
                else -> ensureValidKey(key = range.first - params.loadSize)
            },
            nextKey = range.last + 10
        )
    }

    override fun getRefreshKey(state: PagingState<Int, MarvelCharacter>): Int? {
        TODO("Not yet implemented")
    }
}