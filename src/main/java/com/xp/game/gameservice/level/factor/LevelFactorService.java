package com.xp.game.gameservice.level.factor;

import com.xp.game.gameservice.level.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
public class LevelFactorService{
    @Autowired
    private LevelFactorRepository repository;

    @Cacheable
    public Level findLevel(int currentLevel){
        List<LevelFactorEntity> levelFactors = repository
                .findByKeyLevelFactorTypeAndKeyMaxLevelLessThanEqual(LevelFactorType.BASIC_ARITHMETIC, currentLevel);
        return getLevel(currentLevel, levelFactors);
    }

    private static Level getLevel(final int currentLevel,final List<LevelFactorEntity> levelFactors) {
        Collections.sort(levelFactors);

        Level level = new Level();
        int previousLevelFaotory = 0;
        for (LevelFactorEntity levelFactory : levelFactors) {
            Integer maxLevel = levelFactory.getKey().getMaxLevel();
            if(currentLevel >= maxLevel){
                increaseToMax(level, previousLevelFaotory, levelFactory, maxLevel);
                previousLevelFaotory = maxLevel;
            }else if(currentLevel < maxLevel){
                increaseToCurrentLevel(level, levelFactory, currentLevel);
            }
        }
        return level;
    }

    private static void increaseToMax(Level level, int previousLevelFaotory, LevelFactorEntity levelFactory, Integer maxLevel) {
        level.setMin(level.getMin()+ (levelFactory.getMinIncreasing() * (maxLevel - previousLevelFaotory)));
        level.setMax(level.getMax()+ (levelFactory.getMaxIncreasing() * (maxLevel - previousLevelFaotory)));
        level.setEquations(level.getEquations()+(levelFactory.getEquationsIncreasing() * (maxLevel - previousLevelFaotory)));
    }

    private static void increaseToCurrentLevel(Level level, LevelFactorEntity levelFactory, Integer currentLevel) {
        level.setMin(level.getMin()+ (levelFactory.getMinIncreasing() * currentLevel));
        level.setMax(level.getMax()+ (levelFactory.getMaxIncreasing() * currentLevel));
        level.setEquations(level.getEquations()+(levelFactory.getEquationsIncreasing() * currentLevel));
    }

    public void create(LevelFactorEntity entity) {
        repository.save(entity);
    }
}
