package com.nicomahnic.capgeminichallenge.datasource.network.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.nicomahnic.capgeminichallenge.models.network.MarvelNetworkItem
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MarvelNetworkData(
    @SerializedName("results")
    val results: List<MarvelNetworkItem>?,
) : Parcelable
