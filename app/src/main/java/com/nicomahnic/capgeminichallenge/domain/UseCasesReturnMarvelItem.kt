package com.nicomahnic.capgeminichallenge.domain

interface UseCasesReturnMarvelItem<Entity> {

    suspend operator fun invoke(id: Int? = null) : Entity?

}