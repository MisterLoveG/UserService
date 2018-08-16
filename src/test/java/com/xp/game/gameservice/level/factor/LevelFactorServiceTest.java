package com.xp.game.gameservice.level.factor;

import com.xp.game.gameservice.level.Level;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class LevelFactorServiceTest {

    @Mock
    private LevelFactorRepository repository;

    @InjectMocks
    LevelFactorService subject;

    @Test
    public void shouldCalculateCurrentLevelWhenUseMoreThanOneLevelFactory() {
        //given
        int currentLevel = 7;
        List<LevelFactorEntity> levelFactors = createLevelFactor(2);

        //when
        when(repository.findByKeyLevelFactorTypeAndKeyMaxLevelLessThanEqual(LevelFactorType.BASIC_ARITHMETIC,currentLevel)).thenReturn(levelFactors);
        Level level = subject.findLevel(currentLevel);
        //then
        Assert.assertEquals("Max should be 9", level.getMax(), 9);
        Assert.assertEquals("Min should be -9", level.getMin(), -9);
        Assert.assertEquals("Equations should be 9", level.getEquations(), 9);


    }
    private static List<LevelFactorEntity> createLevelFactor(int quantity){
        List<LevelFactorEntity>  levelFactors = new ArrayList<>();

        for(int i = 1; i <= quantity; i++){
            LevelFactorEntity levelFactor = new LevelFactorEntity();
            levelFactor.setMaxIncreasing(i);
            levelFactor.setMinIncreasing(-i);
            levelFactor.setEquationsIncreasing(i);
            levelFactor.setKey(createKey(i*5));
            levelFactors.add(levelFactor);
        }
        return levelFactors;

    }

    private static LevelFactorEntity.LevelFactorKey createKey(int maxLevel) {
        return new LevelFactorEntity.LevelFactorKey(LevelFactorType.BASIC_ARITHMETIC, maxLevel);
    }

}