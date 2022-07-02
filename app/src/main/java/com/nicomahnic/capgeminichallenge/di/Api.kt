package com.nicomahnic.capgeminichallenge.di

import com.nicomahnic.capgeminichallenge.BuildConfig
import com.nicomahnic.capgeminichallenge.api.MarvelService
import com.nicomahnic.capgeminichallenge.repository.CharactersPagingSource
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Api {

    val apiModule = module {
        single {
            val retrofit: Retrofit = get()
            retrofit.create(MarvelService::class.java)
        }
    }

    val networkModule = module {
        factory { provideOkHttpClient() }
        single { provideRetrofit(get()) }
    }

    val pagingModule = module {
        single { CharactersPagingSource( get() ) }
    }

    private fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL_MARVERL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun provideOkHttpClient(): OkHttpClient {

        val builder = OkHttpClient().newBuilder()
            .connectTimeout(15L, TimeUnit.SECONDS)
            .readTimeout(15L, TimeUnit.SECONDS)
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                val originalHttpUrl = chain.request().url
                val url = originalHttpUrl.newBuilder().addQueryParameter("apikey", BuildConfig.MARVEL_API_KEY ).build()
                request.url(url)
                return@addInterceptor chain.proceed(request.build())
            }

        if (BuildConfig.DEBUG) {
            val httpLoggingInterceptor =
                HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
            builder.addInterceptor(httpLoggingInterceptor)
        }
        return builder.build()
    }

}