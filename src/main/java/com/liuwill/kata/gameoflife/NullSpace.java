package com.liuwill.kata.gameoflife;

/**
 * Created by LiuWill on 2017/4/23.
 */
public class NullSpace extends GameLife {

    public NullSpace(GameWorld myWorld) {
        super(false, -1, -1, myWorld);
    }

    public boolean isAlive() {
        return false;
    }

    public GameLife grow(GameWorld newWorld) {
        return this;
    }
}
