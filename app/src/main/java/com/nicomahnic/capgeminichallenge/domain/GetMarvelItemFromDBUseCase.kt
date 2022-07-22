package com.nicomahnic.capgeminichallenge.domain

import com.nicomahnic.capgeminichallenge.domain.models.MarvelItem
import com.nicomahnic.capgeminichallenge.domain.models.mapper.MarvelEntityItemMapper
import com.nicomahnic.capgeminichallenge.data.repository.MarvelItemsRepositoryImpl

class GetMarvelItemFromDBUseCase(
    private val marvelItemsRepository: MarvelItemsRepositoryImpl,
    private val marvelEntityItemMapper: MarvelEntityItemMapper
) : UseCasesReturnMarvelItem<MarvelItem> {

    override suspend operator fun invoke(id: Int?): MarvelItem? {
        val res = marvelItemsRepository.getMarvelItem(id)
        return marvelEntityItemMapper.mapFromEntity(res)
    }

}