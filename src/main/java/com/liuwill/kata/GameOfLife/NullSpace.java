package com.liuwill.kata.GameOfLife;

/**
 * Created by videopls on 2017/4/23.
 */
public class NullSpace extends GameLife{
    private boolean isAlive = false;

    public NullSpace(GameWorld myWorld) {
        super(false, -1, -1, myWorld);
    }

    public boolean isAlive(){
        return isAlive;
    }

    public GameLife grow(GameWorld newWorld) {
        return this;
    }
}
