package com.nicomahnic.capgeminichallenge.domain

import com.nicomahnic.capgeminichallenge.domain.models.MarvelItem
import kotlinx.coroutines.flow.Flow

interface UseCases {

    suspend operator fun invoke(): Flow<Any?>
    suspend operator fun invoke(marvelItem: MarvelItem)
    suspend operator fun invoke(id: Int? = null): MarvelItem?

}