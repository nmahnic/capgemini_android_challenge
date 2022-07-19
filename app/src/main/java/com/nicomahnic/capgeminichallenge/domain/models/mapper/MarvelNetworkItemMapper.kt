package com.nicomahnic.capgeminichallenge.domain.models.mapper

import com.nicomahnic.capgeminichallenge.domain.models.MarvelItem
import com.nicomahnic.capgeminichallenge.domain.models.network.MarvelNetworkItem

class MarvelNetworkItemMapper constructor(
    private val marvelNetworkThumbnailMapper : MarvelNetworkThumbnailMapper
): EntityMapper<MarvelNetworkItem, MarvelItem> {

    override fun mapFromEntity(entity: MarvelNetworkItem?): MarvelItem? {
        return entity?.let {
            MarvelItem(
                id = entity.id,
                name = entity.name,
                modified = entity.modified,
                thumbnail = marvelNetworkThumbnailMapper.mapFromEntity(entity.thumbnail)
            )
        }
    }

    override fun mapToEntity(domainModel: MarvelItem?): MarvelNetworkItem? {
        return domainModel?.let {
            MarvelNetworkItem(
                id = domainModel.id,
                name = domainModel.name,
                modified = domainModel.modified,
                thumbnail = marvelNetworkThumbnailMapper.mapToEntity(domainModel.thumbnail)
            )
        }
    }

}