package com.nicomahnic.capgeminichallenge.repository

import com.nicomahnic.capgeminichallenge.datasource.database.MarvelItemDao
import com.nicomahnic.capgeminichallenge.datasource.database.models.MarvelItemEntity

class LocalRepository constructor(
    private val marvelItemDao: MarvelItemDao,
) {

    suspend fun insertMarvelItem(marvelItemEntity: MarvelItemEntity) {
        marvelItemDao.insertMarvelItem(marvelItemEntity)
    }

    suspend fun deleteMarvelItem(marvelItemEntity: MarvelItemEntity) {
        marvelItemDao.deleteMarvelItem(marvelItemEntity)
    }

    suspend fun getMarvelItem(id: Int) = marvelItemDao.getMarvelItem(id)

    suspend fun readAllMarvelItems() = marvelItemDao.readAllMarvelItems()

}