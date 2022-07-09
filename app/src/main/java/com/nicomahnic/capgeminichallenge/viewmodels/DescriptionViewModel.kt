package com.nicomahnic.capgeminichallenge.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nicomahnic.capgeminichallenge.domain.DeleteMarvelItemFromDBUseCase
import com.nicomahnic.capgeminichallenge.domain.GetMarvelItemFromDBUseCase
import com.nicomahnic.capgeminichallenge.domain.InsertMarvelItemToDBUseCase
import com.nicomahnic.capgeminichallenge.models.MarvelItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DescriptionViewModel constructor(
    private val insertMarvelItemToDBUseCase: InsertMarvelItemToDBUseCase,
    private val deleteMarvelItemFromDBUseCase: DeleteMarvelItemFromDBUseCase,
    private val getMarvelItemFromDBUseCase: GetMarvelItemFromDBUseCase,
): ViewModel() {

    fun insertMarvelItem(marvelItem: MarvelItem){
        viewModelScope.launch(Dispatchers.IO) {
            insertMarvelItemToDBUseCase.task(marvelItem)
        }
    }

    fun deleteMarvelItem(marvelItem: MarvelItem){
        viewModelScope.launch(Dispatchers.IO) {
            deleteMarvelItemFromDBUseCase.task(marvelItem)
        }
    }

    fun exitsMarvelItem(marvelItem: MarvelItem, action: (Boolean) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            marvelItem.id?.let{
                getMarvelItemFromDBUseCase.task(marvelItem.id).collect {
                    it?.let { action(true) } ?: run { action(false) }
                }
            } ?: run { run { action(false) } }
        }
    }

}