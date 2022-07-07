package com.nicomahnic.capgeminichallenge.models.mapper

interface EntityMapper<Entity, DomainModel> {

    fun mapFromEntity(entity: Entity?): DomainModel?

    fun mapToEntity(domainModel: DomainModel?): Entity?

    fun mapFromEntityList(entities: List<Entity?>?) : List<DomainModel?>? = entities?.let {  it.map { t -> mapFromEntity(t) } }

    fun mapToEntityList(domainModel: List<DomainModel?>?) : List<Entity?>? = domainModel?.let { it.map { t ->  mapToEntity(t) } }

}