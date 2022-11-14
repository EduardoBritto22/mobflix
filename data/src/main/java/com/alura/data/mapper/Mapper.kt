package com.alura.data.mapper

interface Mapper<E, D> {

    fun mapFromEntity(domainType: E): D

    fun mapToEntity(dataType: D): E

}