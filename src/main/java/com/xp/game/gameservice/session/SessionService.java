package com.xp.game.gameservice.session;

import com.xp.game.gameservice.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SessionService {

    private final SessionRepository repository;

    @Autowired
    public SessionService(final SessionRepository repository) {
        this.repository = repository;
    }

    public void createSession(UserEntity user){
        SessionEntity sessionEntity = new SessionEntity(user.getId());
        repository.insert(sessionEntity);
    }

    public Optional<SessionEntity> getSession(UserEntity user){
        return repository.findById(user.getId());
    }
}
