package com.nicomahnic.capgeminichallenge.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MarvelCharacterResponse(
    @SerializedName("code")
    val code: Int?,
    @SerializedName("data")
    val data: MarvelData?,
) : Parcelable

@Parcelize
data class MarvelData(
    @SerializedName("results")
    val results: List<MarvelCharacter>?,
) : Parcelable

@Parcelize
data class MarvelCharacter (
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("modified")
    val modified: String?,
    @SerializedName("thumbnail")
    val thumbnail: Marvelthumbnail?
) : Parcelable

@Parcelize
data class Marvelthumbnail (
    @SerializedName("path")
    val path: String?,
    @SerializedName("extension")
    val extension: String?,
) : Parcelable


