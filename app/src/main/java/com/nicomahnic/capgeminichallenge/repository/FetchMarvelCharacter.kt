package com.nicomahnic.capgeminichallenge.repository

import com.nicomahnic.capgeminichallenge.BuildConfig
import com.nicomahnic.capgeminichallenge.api.MarvelService
import com.nicomahnic.capgeminichallenge.models.MarvelCharacterResponse
import retrofit2.Response
import java.math.BigInteger
import java.security.MessageDigest
import java.util.*

class FetchMarvelCharacter constructor(
    private val service: MarvelService
) {

    suspend fun request( offset:Int = 1 ) : Response<MarvelCharacterResponse> {
        val ts = Date().time
        val hashInfo = ts.toString() + BuildConfig.MARVEL_PRIVATE_KEY + BuildConfig.MARVEL_API_KEY
        val md = MessageDigest.getInstance("MD5")
        val hashMd5 = BigInteger(1, md.digest(hashInfo.toByteArray())).toString(16).padStart(32, '0')

        return service.getCharacters(ts, hashMd5, offset)
    }


}