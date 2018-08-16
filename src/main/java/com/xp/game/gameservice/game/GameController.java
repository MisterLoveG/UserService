package com.xp.game.gameservice.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService service;

    @PostMapping("/create/{userId}")
    public List<Valuable> createGame(@PathVariable UUID userId){
        return service.createGame(userId);
    }

}

