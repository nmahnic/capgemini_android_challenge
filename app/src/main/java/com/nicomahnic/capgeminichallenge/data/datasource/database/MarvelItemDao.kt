package com.nicomahnic.capgeminichallenge.data.datasource.database

import androidx.room.*
import com.nicomahnic.capgeminichallenge.data.datasource.database.models.MarvelItemEntity

@Dao
interface MarvelItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMarvelItem(item: MarvelItemEntity) : Long

    @Delete
    suspend fun deleteMarvelItem(item: MarvelItemEntity)

    @Query("SELECT * FROM MarvelItem")
    suspend fun readAllMarvelItems(): List<MarvelItemEntity>

    @Query("SELECT * FROM MarvelItem WHERE itemId = :id LIMIT 1")
    suspend fun getMarvelItem(id: Int): MarvelItemEntity?

}