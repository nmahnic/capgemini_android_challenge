package com.nicomahnic.capgeminichallenge.di

import com.nicomahnic.capgeminichallenge.domain.*
import org.koin.dsl.module

object UseCasesModules {

    val useCases = module {
        single { InsertMarvelItemToDBUseCase( get() , get() ) }
        single { DeleteMarvelItemFromDBUseCase( get() , get() ) }
        single { GetMarvelItemFromDBUseCase( get() , get() ) }
        single { GetFavouriteMarvelItemsFromDBUseCase( get() , get() ) }
        single { GetMarvelItemsFromPagingUseCase( get() ) }
    }

}