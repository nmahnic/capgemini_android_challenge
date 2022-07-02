package com.nicomahnic.capgeminichallenge.utils

import android.util.Log
import com.nicomahnic.capgeminichallenge.models.MarvelItem
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

object Utils {

    fun performUls( character: MarvelItem ) : String{
        val pathModified = character.thumbnail!!.path!!.replace("http://", "https://")
        return pathModified+"/landscape_medium."+character.thumbnail.extension
    }

    fun parseModifiedDate( date : String? ) = try {
        date?.let {
            val inputFormatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ", Locale.ENGLISH)
            val outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyy", Locale.ENGLISH)
            val date = LocalDate.parse(it, inputFormatter)
            outputFormatter.format(date)
        } ?: "Unknown"
    }catch (e: Exception){
        Log.e("NM", "parseModifiedDate -> ${e.stackTrace}")
        date ?: "Unknown"
    }

}