package com.nicomahnic.capgeminichallenge.utils

import com.nicomahnic.capgeminichallenge.models.MarvelCharacter
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

object Utils {

    fun performUls( character: MarvelCharacter ) : String{
        val pathModified = character.thumbnail!!.path!!.replace("http://", "https://")
        return pathModified+"/landscape_medium."+character.thumbnail.extension
    }

    fun parseModifiedDate( date : String? ) : String {
        return date?.let {
            val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ", Locale.ENGLISH)
            val outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyy", Locale.ENGLISH)
            val date = LocalDate.parse(it, inputFormatter)
            outputFormatter.format(date)
        } ?: "Unkwon"
    }
}