package com.nicomahnic.capgeminichallenge.data.datasource.database.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MarvelItem")
data class MarvelItemEntity(
    @PrimaryKey
    val itemId: Int,
    val name: String?,
    val modified: String?,
    @Embedded
    val thumbnail: MarvelThumbnailEntity?
)
