package com.nicomahnic.capgeminichallenge.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MarvelItem (
    @SerializedName("id")
    val id: Int?,
    @SerializedName("title")
    val name: String?,
    @SerializedName("modified")
    val modified: String?,
    @SerializedName("thumbnail")
    val thumbnail: Marvelthumbnail?
) : Parcelable



