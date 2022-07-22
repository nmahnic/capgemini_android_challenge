package com.nicomahnic.capgeminichallenge.domain

import com.nicomahnic.capgeminichallenge.domain.models.MarvelItem
import com.nicomahnic.capgeminichallenge.domain.models.mapper.MarvelEntityItemMapper
import com.nicomahnic.capgeminichallenge.data.repository.MarvelItemsRepositoryImpl
import kotlinx.coroutines.flow.*

class GetFavouriteMarvelItemsFromDBUseCase(
    private val marvelItemsRepository: MarvelItemsRepositoryImpl,
    private val marvelEntityItemMapper: MarvelEntityItemMapper
) : UseCasesReturnFlow<List<MarvelItem?>?> {

    override suspend operator fun invoke(): Flow<List<MarvelItem?>?> = flow {
        val res = marvelItemsRepository.readAllMarvelItems()
        emit ( marvelEntityItemMapper.mapFromEntityList(res) )
    }

}