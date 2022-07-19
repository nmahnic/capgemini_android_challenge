package com.nicomahnic.capgeminichallenge.data.datasource.network.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.nicomahnic.capgeminichallenge.domain.models.network.MarvelNetworkItem
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MarvelNetworkData(
    @SerializedName("results")
    val results: List<MarvelNetworkItem>?,
) : Parcelable
