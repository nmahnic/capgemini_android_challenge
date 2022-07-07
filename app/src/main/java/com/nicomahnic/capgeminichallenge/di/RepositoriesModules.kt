package com.nicomahnic.capgeminichallenge.di

import com.nicomahnic.capgeminichallenge.datasource.network.FetchMarvelApiService
import com.nicomahnic.capgeminichallenge.repository.LocalRepository
import com.nicomahnic.capgeminichallenge.repository.PagingRepository
import org.koin.dsl.module

object RepositoriesModules {

    val pagingDataSourceModule = module {
        single { FetchMarvelApiService( get(), get() ) }
    }

    val repositoryModule = module {
        single { PagingRepository( get() ) }
        single { LocalRepository( get() ) }
    }

}