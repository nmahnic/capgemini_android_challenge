package com.nicomahnic.capgeminichallenge.models

import android.os.Parcelable
import com.nicomahnic.capgeminichallenge.models.MarvelThumbnail
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MarvelItem (
    val id: Int?,
    val name: String?,
    val modified: String?,
    val thumbnail: MarvelThumbnail?
) : Parcelable



