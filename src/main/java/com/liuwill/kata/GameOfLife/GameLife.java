package com.liuwill.kata.GameOfLife;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiuWill on 2017/4/23.
 */
public class GameLife implements BaseLife{
    private boolean isAlive;
    private int x;
    private int y;
    private GameWorld myWorld;

//    public GameLife(GameWorld myWorld) {
//        this.myWorld = myWorld;
//    }

    public GameLife(boolean isAlive, int x, int y, GameWorld myWorld) {
        this.isAlive = isAlive;
        this.x = x;
        this.y = y;
        this.myWorld = myWorld;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public GameLife grow(GameWorld newWorld) {
        boolean aliveState = false;
        NeighbourRule[] rules = new NeighbourRule[]{
            new NeighbourRule(-1,-1),
            new NeighbourRule(-1,0),
            new NeighbourRule(-1,1),
            new NeighbourRule(0,-1),
            new NeighbourRule(0,1),
            new NeighbourRule(1,-1),
            new NeighbourRule(1,0),
            new NeighbourRule(1,1)
        };

        int nlifeCount = 0;
        for(NeighbourRule rule : rules){
            int x = rule.calcX(this);
            int y = rule.calcY(this);

            GameLife neighbourLife = myWorld.getLifeAt(x,y);
            if(neighbourLife.isAlive()){
                nlifeCount++;
            }
        }

        if(!isAlive && nlifeCount == 3){
            aliveState = true;
        }else if(isAlive && ((nlifeCount == 2) || (nlifeCount == 3))){
            aliveState = true;
        }
        return new GameLife(aliveState,x,y,newWorld);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean equals(GameLife gameLife){
        if(gameLife == null){
            return false;
        }else if(this.getX() != gameLife.getX()){
            return false;
        }else if(this.getY() != gameLife.getY()){
            return false;
        }else if(this.isAlive() != gameLife.isAlive()){
            return false;
        }

        return true;
    }
}
