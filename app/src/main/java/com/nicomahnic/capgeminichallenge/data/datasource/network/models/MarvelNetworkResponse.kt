package com.nicomahnic.capgeminichallenge.data.datasource.network.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MarvelNetworkResponse(
    @SerializedName("code")
    val code: Int?,
    @SerializedName("data")
    val data: MarvelNetworkData?,
) : Parcelable
