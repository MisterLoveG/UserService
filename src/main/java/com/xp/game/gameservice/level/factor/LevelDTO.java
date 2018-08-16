package com.xp.game.gameservice.level.factor;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LevelDTO {
    private final Integer minLevelRange;
    private final Integer maxLevelRange;
    private final Integer minIncreasing;
    private final Integer maxIncreasing;
    private final Integer equationsIncreasing;
    private final LevelFactorType levelFactorType;

    @JsonCreator
    public LevelDTO(
            @JsonProperty("minLevelRange")
            Integer minLevelRange,
            @JsonProperty("maxLevelRange")
            Integer maxLevelRange,
            @JsonProperty("minIncreasing")
            Integer minIncreasing,
            @JsonProperty("maxIncreasing")
            Integer maxIncreasing,
            @JsonProperty("equationsIncreasing")
            Integer equationsIncreasing,
            @JsonProperty("levelFactorType")
            final LevelFactorType levelFactorType) {
        this.minLevelRange = minLevelRange;
        this.maxLevelRange = maxLevelRange;
        this.minIncreasing = minIncreasing;
        this.maxIncreasing = maxIncreasing;
        this.equationsIncreasing = equationsIncreasing;
        this.levelFactorType = levelFactorType;
    }

    public Integer getMinLevelRange() {
        return minLevelRange;
    }

    public Integer getMaxLevelRange() {
        return maxLevelRange;
    }

    public Integer getMinIncreasing() {
        return minIncreasing;
    }

    public Integer getMaxIncreasing() {
        return maxIncreasing;
    }

    public Integer getEquationsIncreasing() {
        return equationsIncreasing;
    }

    public LevelFactorType getLevelFactorType() {
        return levelFactorType;
    }
}
