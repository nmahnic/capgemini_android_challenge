package com.nicomahnic.capgeminichallenge.domain

import android.util.Log
import com.nicomahnic.capgeminichallenge.models.MarvelItem
import com.nicomahnic.capgeminichallenge.models.mapper.MarvelEntityItemMapper
import com.nicomahnic.capgeminichallenge.repository.LocalRepository

class InsertMarvelItemToDBUseCase(
    private val localRepository: LocalRepository,
    private val marvelEntityItemMapper: MarvelEntityItemMapper
) {

    suspend operator fun invoke(marvelItem: MarvelItem){
        marvelEntityItemMapper.mapToEntity(marvelItem)?.let {
            localRepository.insertMarvelItem(it)

            val res = localRepository.readAllMarvelItems()
            val allItems = marvelEntityItemMapper.mapFromEntityList(res)
        }
    }

}