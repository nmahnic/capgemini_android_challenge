package com.nicomahnic.capgeminichallenge.data.datasource.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nicomahnic.capgeminichallenge.data.datasource.database.models.MarvelItemEntity

@Database(entities = [MarvelItemEntity::class], version = 1)
abstract class ApplicationDatabase : RoomDatabase() {

    abstract fun marvelItemDao(): MarvelItemDao

    companion object{
        const val DATABASE_NAME: String = "application_database"
    }

}