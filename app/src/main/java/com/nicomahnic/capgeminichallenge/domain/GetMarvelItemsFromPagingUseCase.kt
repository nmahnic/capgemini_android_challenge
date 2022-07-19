package com.nicomahnic.capgeminichallenge.domain

import com.nicomahnic.capgeminichallenge.data.repository.MarvelItemsRepositoryImpl
import com.nicomahnic.capgeminichallenge.domain.models.MarvelItem

class GetMarvelItemsFromPagingUseCase(
    private val marvelItemsRepository: MarvelItemsRepositoryImpl
) : UseCases {

    override suspend operator fun invoke() = marvelItemsRepository.getItems()

    override suspend fun invoke(marvelItem: MarvelItem) {
        TODO("Not yet implemented")
    }

    override suspend fun invoke(id: Int?): MarvelItem? {
        TODO("Not yet implemented")
    }

}

