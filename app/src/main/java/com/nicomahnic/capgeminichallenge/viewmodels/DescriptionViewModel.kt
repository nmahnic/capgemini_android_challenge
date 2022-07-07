package com.nicomahnic.capgeminichallenge.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nicomahnic.capgeminichallenge.domain.InsertMarvelItemToDBUseCase
import com.nicomahnic.capgeminichallenge.models.MarvelItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DescriptionViewModel constructor(
    private val insertMarvelItemToDBUseCase: InsertMarvelItemToDBUseCase,
): ViewModel() {

    fun insertMarvelItem(marvelItem: MarvelItem){
        viewModelScope.launch(Dispatchers.IO) {
            insertMarvelItemToDBUseCase.task(marvelItem)
        }
    }

}