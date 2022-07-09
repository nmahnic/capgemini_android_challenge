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

    suspend operator fun invoke(id: Int? = null): MarvelItem? {
        val res = localRepository.getMarvelItem(id)
        return marvelEntityItemMapper.mapFromEntity(res)
    }

}