package com.nicomahnic.capgeminichallenge.datasource.network

import com.nicomahnic.capgeminichallenge.BuildConfig
import com.nicomahnic.capgeminichallenge.api.MarvelService
import com.nicomahnic.capgeminichallenge.models.MarvelItem
import com.nicomahnic.capgeminichallenge.models.mapper.MarvelNetworkItemMapper
import java.math.BigInteger
import java.security.MessageDigest
import java.util.*

class FetchMarvelApiService constructor(
    private val service: MarvelService,
    private val marvelNetworkItemMapper: MarvelNetworkItemMapper
) {

    suspend fun request( offset:Int = 1 ) : List<MarvelItem>?{
        val ts = Date().time
        val hashInfo = ts.toString() + BuildConfig.MARVEL_PRIVATE_KEY + BuildConfig.MARVEL_API_KEY
        val md = MessageDigest.getInstance("MD5")
        val hashMd5 = BigInteger(1, md.digest(hashInfo.toByteArray())).toString(16).padStart(32, '0')

        val response = service.getCharacters(ts, hashMd5, offset).body()?.data?.results

        return marvelNetworkItemMapper.mapFromEntityList(response)?.filterIsInstance<MarvelItem>()

    }


}