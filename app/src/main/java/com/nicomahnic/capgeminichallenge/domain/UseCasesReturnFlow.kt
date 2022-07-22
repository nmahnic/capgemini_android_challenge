package com.nicomahnic.capgeminichallenge.domain

import kotlinx.coroutines.flow.Flow

interface UseCasesReturnFlow<Entity> {

    suspend operator fun invoke() : Flow<Entity>

}