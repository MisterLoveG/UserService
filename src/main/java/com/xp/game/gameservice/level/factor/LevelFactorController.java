package com.xp.game.gameservice.level.factor;

import com.xp.game.gameservice.model.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/levelFactor")
public class LevelFactorController {

    @Autowired
    LevelFactorService service;

    @Autowired
    EntityMapper<LevelFactorEntity, LevelDTO> entityMapper;

    @PostMapping
    public void createLevel(@RequestBody LevelDTO levelDTO){
        LevelFactorEntity entity = entityMapper.toEntity(levelDTO);
        service.create(entity);
    }
}
