package com.nicomahnic.capgeminichallenge.models.network

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.nicomahnic.capgeminichallenge.datasource.network.models.MarvelNetworkThumbnail
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MarvelNetworkItem (
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("modified")
    val modified: String?,
    @SerializedName("thumbnail")
    val thumbnail: MarvelNetworkThumbnail?
) : Parcelable

