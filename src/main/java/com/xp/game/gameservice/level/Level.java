package com.xp.game.gameservice.level;

public class Level {
    private int min;
    private int max;
    private int equations;

    public Level() {
        this.min = 0;
        this.max = 0;
        this.equations = 0;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getEquations() {
        return equations;
    }

    public void setEquations(int equations) {
        this.equations = equations;
    }
}
