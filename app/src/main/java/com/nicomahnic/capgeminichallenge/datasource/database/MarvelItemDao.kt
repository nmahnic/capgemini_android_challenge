package com.nicomahnic.capgeminichallenge.datasource.database

import androidx.room.*
import com.nicomahnic.capgeminichallenge.datasource.database.models.MarvelItemEntity

@Dao
interface MarvelItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMarvelItem(item: MarvelItemEntity) : Long

    @Query("SELECT * FROM MarvelItem")
    suspend fun readAllMarvelItem(): List<MarvelItemEntity>

}