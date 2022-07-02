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
    val results: List<MarvelItem>?,
) : Parcelable

