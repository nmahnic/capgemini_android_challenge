package com.nicomahnic.capgeminichallenge.domain

import com.nicomahnic.capgeminichallenge.domain.models.MarvelItem
import com.nicomahnic.capgeminichallenge.domain.models.mapper.MarvelEntityItemMapper
import com.nicomahnic.capgeminichallenge.data.repository.MarvelItemsRepositoryImpl

class DeleteMarvelItemFromDBUseCase(
    private val marvelItemsRepository: MarvelItemsRepositoryImpl,
    private val marvelEntityItemMapper: MarvelEntityItemMapper
) : UseCasesNotReturn<MarvelItem> {

    override suspend operator fun invoke(entity: MarvelItem){
        marvelEntityItemMapper.mapToEntity(entity)?.let {
            marvelItemsRepository.deleteMarvelItem(it)
        }
    }

}