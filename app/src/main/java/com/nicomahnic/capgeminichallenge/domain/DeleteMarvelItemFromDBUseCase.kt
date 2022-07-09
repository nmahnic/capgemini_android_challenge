package com.nicomahnic.capgeminichallenge.domain

import com.nicomahnic.capgeminichallenge.models.MarvelItem
import com.nicomahnic.capgeminichallenge.models.mapper.MarvelEntityItemMapper
import com.nicomahnic.capgeminichallenge.repository.LocalRepository

class DeleteMarvelItemFromDBUseCase(
    private val localRepository: LocalRepository,
    private val marvelEntityItemMapper: MarvelEntityItemMapper
) {

    suspend fun task(marvelItem: MarvelItem){
            marvelEntityItemMapper.mapToEntity(marvelItem)?.let {
                localRepository.deleteMarvelItem(it)
            }
        }
    }