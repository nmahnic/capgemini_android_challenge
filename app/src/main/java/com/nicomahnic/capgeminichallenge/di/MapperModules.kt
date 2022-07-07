package com.nicomahnic.capgeminichallenge.di

import com.nicomahnic.capgeminichallenge.models.mapper.MarvelEntityItemMapper
import com.nicomahnic.capgeminichallenge.models.mapper.MarvelEntityThumbnailMapper
import com.nicomahnic.capgeminichallenge.models.mapper.MarvelNetworkItemMapper
import com.nicomahnic.capgeminichallenge.models.mapper.MarvelNetworkThumbnailMapper
import org.koin.dsl.module

object MapperModules {

    val marvelNetworkMapper = module {
        single { MarvelNetworkThumbnailMapper( ) }
        single { MarvelNetworkItemMapper( get() ) }
    }

    val marvelEntityModule = module {
        single { MarvelEntityItemMapper( get() ) }
        single { MarvelEntityThumbnailMapper( ) }
    }

}