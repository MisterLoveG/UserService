package com.xp.game.gameservice.game;

import com.xp.game.gameservice.level.Level;
import com.xp.game.gameservice.level.factor.LevelFactorEntity;
import com.xp.game.gameservice.level.factor.LevelFactorService;
import com.xp.game.gameservice.session.SessionService;
import com.xp.game.gameservice.user.UserEntity;
import com.xp.game.gameservice.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GameService {

    @Autowired
    private UserService userService;

    @Autowired
    private SessionService sessionService;

    @Autowired
    private LevelFactorService levelFactorService;

    @Autowired
    private MathClient mathClient;

    public List<Valuable> createGame(UUID userId){
        UserEntity userEntity = getUserEntity(userId);
        Integer currentLevel = userEntity.getCurrentLevel();
        Level level = levelFactorService.findLevel(currentLevel);
        sessionService.createSession(userEntity);
        mathClient.getEquations(level.getMin(), level.getMax(), level.getEquations());
        return null;
    }

    private UserEntity getUserEntity(UUID userId) {
        return userService.
                findById(userId);
    }
}
