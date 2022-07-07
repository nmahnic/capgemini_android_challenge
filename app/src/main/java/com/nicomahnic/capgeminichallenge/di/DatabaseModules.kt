package com.nicomahnic.capgeminichallenge.di

import androidx.room.Room
import com.nicomahnic.capgeminichallenge.datasource.database.ApplicationDatabase
import com.nicomahnic.capgeminichallenge.datasource.database.MarvelItemDao
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

object DatabaseModules {
    val db = module {
        fun provideMarvelItemDao(database: ApplicationDatabase): MarvelItemDao {
            return database.marvelItemDao()
        }

        single {
            Room.databaseBuilder(androidContext(), ApplicationDatabase::class.java, ApplicationDatabase.DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
        }
        single { provideMarvelItemDao(get()) }
    }
}
