package com.liuwill.kata.GameOfLife;

/**
 * Created by LiuWill on 2017/4/23.
 */
public interface BaseLife {
    public boolean isAlive();
    public BaseLife grow(GameWorld gameWorld);

    public int getX();

    public int getY();
}
