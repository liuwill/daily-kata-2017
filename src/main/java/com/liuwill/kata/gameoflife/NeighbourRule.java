package com.liuwill.kata.gameoflife;

/**
 * Created by LiuWill on 2017/4/23.
 */
public class NeighbourRule {
    private int posX;
    private int posY;

    public NeighbourRule(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public int calcX(GameLife gameLife) {
        return gameLife.getPosX() + posX;
    }

    public int calcY(GameLife gameLife) {
        return gameLife.getPosY() + posY;
    }
}
