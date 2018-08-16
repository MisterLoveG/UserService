package com.xp.game.gameservice.level.factor;

import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;

interface LevelFactorRepository extends CassandraRepository<LevelFactorEntity, LevelFactorEntity.LevelFactorKey> {

    List<LevelFactorEntity> findByKeyLevelFactorTypeAndKeyMaxLevelLessThanEqual(LevelFactorType levelFactorType, int max);
}
