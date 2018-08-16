package com.xp.game.gameservice.level.factor;

import com.datastax.driver.core.DataType.Name;
import com.xp.game.gameservice.model.Entity;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.*;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import java.time.Duration;

@Table("LEVEL_FACTOR")
public class LevelFactorEntity implements Entity,Comparable<LevelFactorEntity> {

    @PrimaryKey
    private LevelFactorKey key;

    @Column("min_increasing")
    @NotNull
    private Integer minIncreasing;

    @Column("max_increasing")
    @NotNull
    private Integer maxIncreasing;

    @Column("equation_increasing")
    @NotNull
    private Integer equationsIncreasing;

    @Column("solving_time")
    @CassandraType(type = Name.DURATION)
    private Duration duration;

    public LevelFactorKey getKey() {
        return key;
    }

    public void setKey(LevelFactorKey key) {
        this.key = key;
    }

    public Integer getMinIncreasing() {
        return minIncreasing;
    }

    public void setMinIncreasing(Integer minIncreasing) {
        this.minIncreasing = minIncreasing;
    }

    public Integer getMaxIncreasing() {
        return maxIncreasing;
    }

    public void setMaxIncreasing(Integer maxIncreasing) {
        this.maxIncreasing = maxIncreasing;
    }

    public Integer getEquationsIncreasing() {
        return equationsIncreasing;
    }

    public void setEquationsIncreasing(Integer equationsIncreasing) {
        this.equationsIncreasing = equationsIncreasing;
    }

    @Nullable
    public Duration getDuration() {
        return duration;
    }

    public void setDuration(@Nullable Duration duration) {
        this.duration = duration;
    }

    @Override
    public int compareTo(LevelFactorEntity o) {
        if(key.maxLevel > o.key.maxLevel){
            return 1;
        } else if(key.maxLevel < o.key.maxLevel){
            return -1;
        }
        return 0;
    }


    @PrimaryKeyClass
    public static final class LevelFactorKey{

        @PrimaryKeyColumn(value = "type", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
        @NotNull
        private LevelFactorType levelFactorType;

        @PrimaryKeyColumn(value = "max_level", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
        @NotNull
        private Integer maxLevel;

        public LevelFactorKey(@NotNull LevelFactorType levelFactorType, @NotNull Integer maxLevel) {
            this.levelFactorType = levelFactorType;
            this.maxLevel = maxLevel;
        }

        public LevelFactorKey() {
        }

        public void setLevelFactorType(LevelFactorType levelFactorType) {
            this.levelFactorType = levelFactorType;
        }

        public void setMaxLevel(Integer maxLevel) {
            this.maxLevel = maxLevel;
        }

        public LevelFactorType getLevelFactorType() {
            return levelFactorType;
        }

        public Integer getMaxLevel() {
            return maxLevel;
        }

    }
}
