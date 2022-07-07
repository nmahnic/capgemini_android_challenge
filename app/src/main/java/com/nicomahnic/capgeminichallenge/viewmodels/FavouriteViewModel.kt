package com.nicomahnic.capgeminichallenge.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nicomahnic.capgeminichallenge.domain.GetFavouriteMarvelItemsFromDBUseCase
import com.nicomahnic.capgeminichallenge.domain.GetMarvelItemsFromPagingUseCase
import com.nicomahnic.capgeminichallenge.models.MarvelItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavouriteViewModel constructor(
    private val getFavouriteMarvelItemsFromDBUseCase: GetFavouriteMarvelItemsFromDBUseCase,
): ViewModel() {

    fun getFavouriteMarvelItems(){
        viewModelScope.launch(Dispatchers.IO) {
            val res = getFavouriteMarvelItemsFromDBUseCase.task()
            Log.d("NM", "getMarvelItemsFromPagingUseCase -> $res")
        }
    }

}