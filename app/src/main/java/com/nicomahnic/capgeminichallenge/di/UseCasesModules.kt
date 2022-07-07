package com.nicomahnic.capgeminichallenge.di

import com.nicomahnic.capgeminichallenge.domain.GetFavouriteMarvelItemsFromDBUseCase
import com.nicomahnic.capgeminichallenge.domain.GetMarvelItemsFromPagingUseCase
import com.nicomahnic.capgeminichallenge.domain.InsertMarvelItemToDBUseCase
import org.koin.dsl.module

object UseCasesModules {

    val usecases = module {
        single { InsertMarvelItemToDBUseCase( get() , get() ) }
        single { GetFavouriteMarvelItemsFromDBUseCase( get() , get() ) }
        single { GetMarvelItemsFromPagingUseCase( get() ) }
    }

}