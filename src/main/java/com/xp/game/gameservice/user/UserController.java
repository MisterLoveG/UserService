package com.xp.game.gameservice.user;

import com.xp.game.gameservice.model.AbstractController;
import com.xp.game.gameservice.model.AbstractService;
import com.xp.game.gameservice.model.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController extends AbstractController<UserDTO, UserEntity, UUID> {

    @Autowired
    public UserController(AbstractService<UserEntity, UUID> service, EntityMapper<UserEntity, UserDTO> entityMapper) {
        super(service, entityMapper);
    }
}
