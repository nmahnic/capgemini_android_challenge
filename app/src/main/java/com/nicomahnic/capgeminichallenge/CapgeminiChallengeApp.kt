package com.nicomahnic.capgeminichallenge

import android.app.Application
import com.nicomahnic.capgeminichallenge.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CapgeminiChallengeApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@CapgeminiChallengeApp)
            modules(listOf(
                DatabaseModules.db,
                ViewModelsModules.homeViewModel,
                ViewModelsModules.descriptionViewModel,
                ApiModules.apiModule,
                ApiModules.networkModule,
                ApiModules.pagingModule,
                RepositoriesModules.repositoryModule,
                RepositoriesModules.pagingDataSourceModule,
                MapperModules.marvelNetworkMapper,
                MapperModules.marvelEntityModule,
            ))
        }
    }
}