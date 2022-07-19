package com.nicomahnic.capgeminichallenge.domain

import com.nicomahnic.capgeminichallenge.domain.models.MarvelItem
import com.nicomahnic.capgeminichallenge.domain.models.mapper.MarvelEntityItemMapper
import com.nicomahnic.capgeminichallenge.data.repository.MarvelItemsRepositoryImpl
import kotlinx.coroutines.flow.Flow

class InsertMarvelItemToDBUseCase(
    private val marvelItemsRepository: MarvelItemsRepositoryImpl,
    private val marvelEntityItemMapper: MarvelEntityItemMapper
) : UseCases {

    override suspend operator fun invoke(marvelItem: MarvelItem){
        marvelEntityItemMapper.mapToEntity(marvelItem)?.let {
            marvelItemsRepository.insertMarvelItem(it)
        }
    }

    override suspend fun invoke(id: Int?): MarvelItem? {
        TODO("Not yet implemented")
    }

    override suspend fun invoke(): Flow<Any?> {
        TODO("Not yet implemented")
    }

}