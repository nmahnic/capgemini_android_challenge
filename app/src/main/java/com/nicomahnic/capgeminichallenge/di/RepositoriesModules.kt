package com.nicomahnic.capgeminichallenge.di

import com.nicomahnic.capgeminichallenge.data.datasource.network.FetchMarvelApiService
import com.nicomahnic.capgeminichallenge.data.repository.MarvelItemsRepositoryImpl
import org.koin.dsl.module

object RepositoriesModules {

    val pagingDataSourceModule = module {
        single { FetchMarvelApiService( get(), get() ) }
    }

    val repositoryModule = module {
        single { MarvelItemsRepositoryImpl( get(), get() ) }
    }

}