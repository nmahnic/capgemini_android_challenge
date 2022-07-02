package com.nicomahnic.capgeminichallenge.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Marvelthumbnail (
    @SerializedName("path")
    val path: String?,
    @SerializedName("extension")
    val extension: String?,
) : Parcelable