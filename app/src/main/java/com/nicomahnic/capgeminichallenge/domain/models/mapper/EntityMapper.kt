package com.nicomahnic.capgeminichallenge.domain.models.mapper

interface EntityMapper<Entity, DomainModel> {

    fun mapFromEntity(entity: Entity? = null): DomainModel?

    fun mapToEntity(domainModel: DomainModel? = null): Entity?

    fun mapFromEntityList(entities: List<Entity?>? = null) : List<DomainModel?>? = entities?.let {  it.map { t -> mapFromEntity(t) } }

    fun mapToEntityList(domainModel: List<DomainModel?>? = null) : List<Entity?>? = domainModel?.let { it.map { t ->  mapToEntity(t) } }

}