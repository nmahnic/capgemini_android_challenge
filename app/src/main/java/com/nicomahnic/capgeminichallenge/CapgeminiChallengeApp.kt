package com.nicomahnic.capgeminichallenge

import android.app.Application
import com.nicomahnic.capgeminichallenge.di.Api
import com.nicomahnic.capgeminichallenge.di.Repositories
import com.nicomahnic.capgeminichallenge.di.ViewModelsModule
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
                ViewModelsModule.modules,
                Api.apiModule,
                Api.networkModule,
                Repositories.repositoryModule
            ))
        }
    }
}