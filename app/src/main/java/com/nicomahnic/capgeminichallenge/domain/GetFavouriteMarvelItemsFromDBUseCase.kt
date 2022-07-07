package com.nicomahnic.capgeminichallenge.domain

import com.nicomahnic.capgeminichallenge.models.MarvelItem
import com.nicomahnic.capgeminichallenge.models.mapper.MarvelEntityItemMapper
import com.nicomahnic.capgeminichallenge.repository.LocalRepository

class GetFavouriteMarvelItemsFromDBUseCase(
    private val localRepository: LocalRepository,
    private val marvelEntityItemMapper: MarvelEntityItemMapper
) {

    suspend fun task(): List<MarvelItem?>? {
        val res = localRepository.readAllMarvelItems()
        return marvelEntityItemMapper.mapFromEntityList(res)
    }

}