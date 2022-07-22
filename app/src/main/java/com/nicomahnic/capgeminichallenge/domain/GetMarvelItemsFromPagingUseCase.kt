package com.nicomahnic.capgeminichallenge.domain

import androidx.paging.PagingData
import com.nicomahnic.capgeminichallenge.data.repository.MarvelItemsRepositoryImpl
import com.nicomahnic.capgeminichallenge.domain.models.MarvelItem

class GetMarvelItemsFromPagingUseCase(
    private val marvelItemsRepository: MarvelItemsRepositoryImpl
) : UseCasesReturnFlow<PagingData<MarvelItem>> {

    override suspend operator fun invoke() = marvelItemsRepository.getItems()

}

