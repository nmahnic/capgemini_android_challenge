package com.nicomahnic.capgeminichallenge.di

import com.nicomahnic.capgeminichallenge.repository.FetchMarvelCharacter
import org.koin.dsl.module

object Repositories {

    val repositoryModule = module {
        single { FetchMarvelCharacter( get() ) }
    }

}