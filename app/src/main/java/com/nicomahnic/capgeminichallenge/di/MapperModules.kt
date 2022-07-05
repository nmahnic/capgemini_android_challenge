package com.nicomahnic.capgeminichallenge.di

import com.nicomahnic.capgeminichallenge.models.mapper.MarvelNetworkItemMapper
import com.nicomahnic.capgeminichallenge.models.mapper.MarvelNetworkThumbnailMapper
import org.koin.dsl.module

object MapperModules {

    val marvelNetworkItemMapperModule = module {
        single { MarvelNetworkItemMapper( get() ) }
    }

    val marvelNetworkThumbnailMapper = module {
        single { MarvelNetworkThumbnailMapper( ) }
    }

}