package com.nicomahnic.capgeminichallenge.domain

import com.nicomahnic.capgeminichallenge.models.MarvelItem
import com.nicomahnic.capgeminichallenge.models.mapper.MarvelEntityItemMapper
import com.nicomahnic.capgeminichallenge.repository.LocalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetMarvelItemFromDBUseCase(
    private val localRepository: LocalRepository,
    private val marvelEntityItemMapper: MarvelEntityItemMapper
) {

    suspend fun task(id: Int): Flow<MarvelItem?> = flow {
        val res = localRepository.getMarvelItem(id)
        emit ( marvelEntityItemMapper.mapFromEntity(res) )
    }
}