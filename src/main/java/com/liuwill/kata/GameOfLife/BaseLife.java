package com.liuwill.kata.GameOfLife;

/**
 * Created by LiuWill on 2017/4/23.
 */
public interface BaseLife {
    boolean isAlive();
    BaseLife grow(GameWorld gameWorld);

    int getX();

    int getY();
}
