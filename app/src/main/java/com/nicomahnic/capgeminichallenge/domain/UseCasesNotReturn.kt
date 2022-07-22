package com.nicomahnic.capgeminichallenge.domain

interface UseCasesNotReturn<Entity> {

    suspend operator fun invoke(entity: Entity)

}