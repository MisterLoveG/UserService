package com.xp.game.gameservice.model;

import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.Optional;

public class AbstractService<E extends Entity, ID> {

    protected final CassandraRepository<E, ID> repository;

    public AbstractService(CassandraRepository<E, ID> repository) {
        this.repository = repository;
    }

    public void save(E entity) {
        repository.save(entity);
    }

    public E findById(ID id){
        Optional<E> foundEntity = repository.findById(id);
        return foundEntity.orElseThrow(()->
                new IllegalArgumentException("Entidade com id "+id + " não foi achado"));
    }

}
