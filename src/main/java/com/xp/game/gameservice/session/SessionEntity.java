package com.xp.game.gameservice.session;

import com.datastax.driver.core.DataType;
import com.xp.game.gameservice.model.Entity;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Table("session")
public class SessionEntity implements Entity {
    @PrimaryKeyColumn(ordinal = 0, type = PrimaryKeyType.PARTITIONED, name = "user_id")
    private final UUID userId;

    @PrimaryKeyColumn(ordinal = 1, type = PrimaryKeyType.CLUSTERED, name = "start_timestamp")
    @CassandraType(type = DataType.Name.TIMESTAMP)
    private final Timestamp timestamp;

    SessionEntity(final UUID userId) {
        this.timestamp = Timestamp.valueOf(LocalDateTime.now());
        this.userId = userId;
    }

    public UUID getUserId() {
        return userId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
}
