package com.nicomahnic.capgeminichallenge.domain

import com.nicomahnic.capgeminichallenge.repository.PagingRepository

class GetMarvelItemsFromPagingUseCase(
    private val pagingRepository: PagingRepository
) {

    operator fun invoke() = pagingRepository.getItems()

}

