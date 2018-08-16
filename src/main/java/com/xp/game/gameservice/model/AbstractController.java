package com.xp.game.gameservice.model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class AbstractController <T, E extends Entity, ID>{

    private final AbstractService service;
    private final EntityMapper<E,T> entityMapper;

    public AbstractController(AbstractService<E, ID> service, EntityMapper<E,T> entityMapper) {
        this.service = service;
        this.entityMapper = entityMapper;
    }

    @GetMapping("/{id}")
    public T getEntity(ID id){
        E entity = (E) service.findById(id);
        return entityMapper.toDTO(entity);
    }

    @PostMapping
    public void create(@RequestBody T dto) {
        E entity = entityMapper.toEntity(dto);
        service.save(entity);
    }

    @PutMapping
    public void update(@RequestBody T dto) {
        E entity = entityMapper.toEntity(dto);
        service.save(entity);
    }
}
