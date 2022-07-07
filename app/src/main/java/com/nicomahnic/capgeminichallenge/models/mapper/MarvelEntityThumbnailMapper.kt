package com.nicomahnic.capgeminichallenge.models.mapper

import com.nicomahnic.capgeminichallenge.datasource.database.models.MarvelThumbnailEntity
import com.nicomahnic.capgeminichallenge.models.MarvelThumbnail

class MarvelEntityThumbnailMapper : EntityMapper<MarvelThumbnailEntity, MarvelThumbnail> {

    override fun mapFromEntity(entity: MarvelThumbnailEntity?): MarvelThumbnail? {
        return entity?.let {
            MarvelThumbnail(
                path = entity.path,
                extension = entity.extension
            )
        }
    }

    override fun mapToEntity(domainModel: MarvelThumbnail?): MarvelThumbnailEntity? {
        return domainModel?.let {
            MarvelThumbnailEntity(
                path = domainModel.path,
                extension = domainModel.extension
            )
        }
    }

}