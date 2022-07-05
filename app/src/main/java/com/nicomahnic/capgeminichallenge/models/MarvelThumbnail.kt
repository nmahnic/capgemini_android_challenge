package com.nicomahnic.capgeminichallenge.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MarvelThumbnail (
    val path: String?,
    val extension: String?,
) : Parcelable