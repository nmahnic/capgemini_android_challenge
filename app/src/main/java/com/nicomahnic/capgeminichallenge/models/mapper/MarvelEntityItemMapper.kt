package com.nicomahnic.capgeminichallenge.models.mapper

import com.nicomahnic.capgeminichallenge.datasource.database.models.MarvelItemEntity
import com.nicomahnic.capgeminichallenge.models.MarvelItem

class MarvelEntityItemMapper constructor(
    private val marvelEntityThumbnailMapper: MarvelEntityThumbnailMapper
): EntityMapper<MarvelItemEntity, MarvelItem> {

    override fun mapFromEntity(entity: MarvelItemEntity?): MarvelItem? {
        return entity?.let {
            MarvelItem(
                id = entity.itemId,
                name = entity.name,
                modified = entity.modified,
                thumbnail = marvelEntityThumbnailMapper.mapFromEntity(entity.thumbnail)
            )
        }
    }

    override fun mapToEntity(domainModel: MarvelItem?): MarvelItemEntity? {
        return domainModel?.let {
            MarvelItemEntity(
                itemId = domainModel.id ?: 0,
                name = domainModel.name,
                modified = domainModel.modified,
                thumbnail = marvelEntityThumbnailMapper.mapToEntity(domainModel.thumbnail)
            )
        }
    }

}