package com.xp.game.gameservice.user;

import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

interface UserRepository extends CassandraRepository<UserEntity, UUID> {

}
