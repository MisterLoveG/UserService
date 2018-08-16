package com.xp.game.gameservice.user;

import com.xp.game.gameservice.model.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class UserService extends AbstractService<UserEntity,UUID> {

    @Autowired
    public UserService(UserRepository repository) {
        super(repository);
    }
}
