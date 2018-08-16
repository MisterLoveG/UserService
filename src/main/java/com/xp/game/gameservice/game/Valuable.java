package com.xp.game.gameservice.game;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Valuable {
    private final String description;
    private final Double value;

    @JsonCreator
    public Valuable(
            @JsonProperty("description")
            String description,
            @JsonProperty("value")
            Double value) {
        this.description = description;
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public Double getValue() {
        return value;
    }
}
