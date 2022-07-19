package com.nicomahnic.capgeminichallenge.data.datasource.network.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MarvelNetworkThumbnail (
    @SerializedName("path")
    val path: String?,
    @SerializedName("extension")
    val extension: String?,
) : Parcelable