package com.liuwill.kata.GameOfLife;

/**
 * Created by videopls on 2017/4/23.
 */
public class NeighbourRule {
    private int posX;
    private int posY;

    public NeighbourRule(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public int calcX(GameLife gameLife){
        return gameLife.getX() + posX;
    }

    public int calcY(GameLife gameLife){
        return gameLife.getY() + posY;
    }
}
