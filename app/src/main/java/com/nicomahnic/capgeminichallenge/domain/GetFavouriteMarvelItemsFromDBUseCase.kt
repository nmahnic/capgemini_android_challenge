package com.nicomahnic.capgeminichallenge.domain

import com.nicomahnic.capgeminichallenge.models.MarvelItem
import com.nicomahnic.capgeminichallenge.models.mapper.MarvelEntityItemMapper
import com.nicomahnic.capgeminichallenge.repository.LocalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetFavouriteMarvelItemsFromDBUseCase(
    private val localRepository: LocalRepository,
    private val marvelEntityItemMapper: MarvelEntityItemMapper
) {

    suspend fun task(): Flow<List<MarvelItem?>?> = flow {
        val res = localRepository.readAllMarvelItems()
        emit ( marvelEntityItemMapper.mapFromEntityList(res) )
    }

}