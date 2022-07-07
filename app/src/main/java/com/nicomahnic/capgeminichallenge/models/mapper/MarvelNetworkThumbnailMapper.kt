package com.nicomahnic.capgeminichallenge.models.mapper

import com.nicomahnic.capgeminichallenge.datasource.network.models.MarvelNetworkThumbnail
import com.nicomahnic.capgeminichallenge.models.MarvelThumbnail

class MarvelNetworkThumbnailMapper : EntityMapper<MarvelNetworkThumbnail, MarvelThumbnail> {

    override fun mapFromEntity(entity: MarvelNetworkThumbnail?): MarvelThumbnail? {
        return entity?.let {
            MarvelThumbnail(
                path = entity.path,
                extension = entity.extension
            )
        }
    }

    override fun mapToEntity(domainModel: MarvelThumbnail?): MarvelNetworkThumbnail? {
        return domainModel?.let {
            MarvelNetworkThumbnail(
                path = domainModel.path,
                extension = domainModel.extension
            )
        }
    }

}