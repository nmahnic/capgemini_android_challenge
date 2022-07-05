package com.nicomahnic.capgeminichallenge

import android.app.Application
import com.nicomahnic.capgeminichallenge.di.ApiModules
import com.nicomahnic.capgeminichallenge.di.MapperModules
import com.nicomahnic.capgeminichallenge.di.RepositoriesModules
import com.nicomahnic.capgeminichallenge.di.ViewModelsModules
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
                ViewModelsModules.modules,
                ApiModules.apiModule,
                ApiModules.networkModule,
                ApiModules.pagingModule,
                RepositoriesModules.repositoryModule,
                RepositoriesModules.dataSourceModule,
                MapperModules.marvelNetworkItemMapperModule,
                MapperModules.marvelNetworkThumbnailMapper,
            ))
        }
    }
}