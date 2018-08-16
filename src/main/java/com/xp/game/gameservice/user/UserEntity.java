package com.xp.game.gameservice.user;

import com.xp.game.gameservice.model.Entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Table("USER")
public class UserEntity implements Entity {

    @Id
    @PrimaryKeyColumn(type=PrimaryKeyType.PARTITIONED , ordinal = 0)
    private final UUID id;

    @NotNull
    @Column("current_level")
    private Integer currentLevel;

    public UserEntity() {
        id = UUID.randomUUID();
        currentLevel = 0;
    }

    public UUID getId() {
        return id;
    }

    public Integer getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(Integer currentLevel) {
        this.currentLevel = currentLevel;
    }
}
