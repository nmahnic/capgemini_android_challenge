package com.nicomahnic.capgeminichallenge.utils

import com.nicomahnic.capgeminichallenge.models.MarvelCharacter

object Utils {

    fun performUls( character: MarvelCharacter ) : String{
        val pathModified = character.thumbnail!!.path!!.replace("http://", "https://")
        return pathModified+"/landscape_medium."+character.thumbnail.extension
    }
}