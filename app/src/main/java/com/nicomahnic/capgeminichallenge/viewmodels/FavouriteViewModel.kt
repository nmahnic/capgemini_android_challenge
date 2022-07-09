package com.nicomahnic.capgeminichallenge.viewmodels

import androidx.lifecycle.ViewModel
import com.nicomahnic.capgeminichallenge.domain.GetFavouriteMarvelItemsFromDBUseCase

class FavouriteViewModel constructor(
    private val getFavouriteMarvelItemsFromDBUseCase: GetFavouriteMarvelItemsFromDBUseCase,
): ViewModel() {

    suspend fun getFavouriteMarvelItems() = getFavouriteMarvelItemsFromDBUseCase()

}