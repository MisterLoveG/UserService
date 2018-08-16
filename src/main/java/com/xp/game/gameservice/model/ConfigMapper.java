package com.xp.game.gameservice.model;

import com.xp.game.gameservice.level.factor.LevelDTO;
import com.xp.game.gameservice.level.factor.LevelFactorEntity;
import com.xp.game.gameservice.user.UserDTO;
import com.xp.game.gameservice.user.UserEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ConfigMapper {

    @Bean
    public ModelMapper getModelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper;
    }

    @Bean
    public EntityMapper<UserEntity, UserDTO> getUserMapper(ModelMapper modelMapper){
        TypeMap dtoTypeMap = modelMapper
                .createTypeMap(UserEntity.class, UserDTO.class);

        TypeMap entityTypeMap = modelMapper
                .createTypeMap(UserDTO.class, UserEntity.class);

        return new EntityMapper(entityTypeMap, dtoTypeMap);

    }

    @Bean
    public EntityMapper<LevelFactorEntity, LevelDTO> getLevelMapper(ModelMapper modelMapper){
        TypeMap dtoTypeMap = modelMapper
                .createTypeMap(LevelFactorEntity.class, LevelDTO.class);

        TypeMap entityTypeMap = modelMapper
                .createTypeMap(LevelDTO.class, LevelFactorEntity.class);

        return new EntityMapper(entityTypeMap, dtoTypeMap);
    }
}
