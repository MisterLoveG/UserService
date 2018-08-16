package com.xp.game.gameservice.session;

import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;


public interface SessionRepository extends CassandraRepository<SessionEntity, UUID> {

}
