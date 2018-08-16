package com.xp.game.gameservice.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO {
    private Integer currentLevel;

    @JsonCreator
    public UserDTO(
            @JsonProperty("currentLevel")
            Integer currentLevel) {
        this.currentLevel = currentLevel;
    }

    public Integer getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(Integer currentLevel) {
        this.currentLevel = currentLevel;
    }
}
