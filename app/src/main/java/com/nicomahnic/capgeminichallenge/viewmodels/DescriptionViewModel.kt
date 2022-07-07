package com.nicomahnic.capgeminichallenge.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nicomahnic.capgeminichallenge.datasource.database.MarvelItemDao
import com.nicomahnic.capgeminichallenge.datasource.database.models.MarvelItemEntity
import com.nicomahnic.capgeminichallenge.datasource.database.models.MarvelThumbnailEntity
import com.nicomahnic.capgeminichallenge.models.MarvelItem
import com.nicomahnic.capgeminichallenge.models.mapper.MarvelEntityItemMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DescriptionViewModel constructor(
    private val marvelItemDao: MarvelItemDao,
    private val marvelEntityItemMapper: MarvelEntityItemMapper
): ViewModel() {

    fun insertMarvelItem(marvelItem: MarvelItem){
        viewModelScope.launch(Dispatchers.IO) {
            marvelEntityItemMapper.mapToEntity(marvelItem)?.let {
                marvelItemDao.insertMarvelItem(it)

                val res = marvelItemDao.readAllMarvelItem()
                Log.e("NM", "RES -> $res")
                val allItems = marvelEntityItemMapper.mapFromEntityList(res)
                Log.e("NM", "ALLITEMS -> $allItems")

            }
        }
    }

}