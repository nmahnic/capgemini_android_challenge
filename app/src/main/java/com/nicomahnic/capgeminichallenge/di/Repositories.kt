package com.nicomahnic.capgeminichallenge.di

import com.nicomahnic.capgeminichallenge.datasource.FetchMarvelCharacter
import com.nicomahnic.capgeminichallenge.repository.Repository
import org.koin.dsl.module

object Repositories {

    val dataSourceModule = module {
        single { FetchMarvelCharacter( get() ) }
    }

    val repositoryModule = module {
        single { Repository( get() ) }
    }

}