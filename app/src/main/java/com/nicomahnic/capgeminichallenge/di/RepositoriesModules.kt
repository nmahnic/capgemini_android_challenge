package com.nicomahnic.capgeminichallenge.di

import com.nicomahnic.capgeminichallenge.datasource.network.FetchMarvelApiService
import com.nicomahnic.capgeminichallenge.repository.Repository
import org.koin.dsl.module

object RepositoriesModules {

    val dataSourceModule = module {
        single { FetchMarvelApiService( get(), get() ) }
    }

    val repositoryModule = module {
        single { Repository( get() ) }
    }

}