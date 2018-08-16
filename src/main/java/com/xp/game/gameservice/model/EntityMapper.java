package com.xp.game.gameservice.model;

import org.modelmapper.TypeMap;

public class EntityMapper<E extends  Entity,T> {
    private TypeMap<T,E> entityMapper;
    private TypeMap<E,T> dtoMapper;

    public EntityMapper(TypeMap<T, E> entityMapper, TypeMap<E, T> dtoMapper) {
        this.entityMapper = entityMapper;
        this.dtoMapper = dtoMapper;
    }

    public T toDTO(E entity){
        return dtoMapper.map(entity);
    }

    public E toEntity(T dto) {
        return entityMapper.map(dto);
    }
}
