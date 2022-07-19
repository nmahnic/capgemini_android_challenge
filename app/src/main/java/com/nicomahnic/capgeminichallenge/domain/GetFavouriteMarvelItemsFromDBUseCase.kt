package com.nicomahnic.capgeminichallenge.domain

import com.nicomahnic.capgeminichallenge.domain.models.MarvelItem
import com.nicomahnic.capgeminichallenge.domain.models.mapper.MarvelEntityItemMapper
import com.nicomahnic.capgeminichallenge.data.repository.MarvelItemsRepositoryImpl
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetFavouriteMarvelItemsFromDBUseCase(
    private val marvelItemsRepository: MarvelItemsRepositoryImpl,
    private val marvelEntityItemMapper: MarvelEntityItemMapper
) : UseCases {

    override suspend operator fun invoke(): Flow<List<MarvelItem?>?> = flow {
        val res = marvelItemsRepository.readAllMarvelItems()
        emit ( marvelEntityItemMapper.mapFromEntityList(res) )
    }

    override suspend fun invoke(marvelItem: MarvelItem) {
        TODO("Not yet implemented")
    }

    override suspend fun invoke(id: Int?): MarvelItem? {
        TODO("Not yet implemented")
    }

}