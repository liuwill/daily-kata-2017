package com.liuwill.kata.gameoflife;

/**
 * Created by LiuWill on 2017/4/23.
 */
public interface BaseLife {
    boolean isAlive();

    BaseLife grow(GameWorld gameWorld);

    int getPosX();

    int getPosY();
}
