package com.liuwill.kata.gameoflife;

/**
 * Created by LiuWill on 2017/4/23.
 */
public class GameLife implements BaseLife {
    private boolean isAlive;
    private int posX;
    private int posY;
    private GameWorld myWorld;

    // public GameLife(GameWorld myWorld) {
    //    this.myWorld = myWorld;
    // }

    public GameLife(boolean isAlive, int x, int y, GameWorld myWorld) {
        this.isAlive = isAlive;
        this.posX = x;
        this.posY = y;
        this.myWorld = myWorld;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public GameLife grow(GameWorld newWorld) {
        boolean aliveState = false;
        NeighbourRule[] rules = new NeighbourRule[]{
            new NeighbourRule(-1, -1),
            new NeighbourRule(-1, 0),
            new NeighbourRule(-1, 1),
            new NeighbourRule(0, -1),
            new NeighbourRule(0, 1),
            new NeighbourRule(1, -1),
            new NeighbourRule(1, 0),
            new NeighbourRule(1, 1)
        };

        int nlifeCount = 0;
        for (NeighbourRule rule : rules) {
            int x = rule.calcX(this);
            int y = rule.calcY(this);

            GameLife neighbourLife = myWorld.getLifeAt(x, y);
            if (neighbourLife.isAlive()) {
                nlifeCount++;
            }
        }

        if (!isAlive && nlifeCount == 3) {
            aliveState = true;
        } else if (isAlive && ((nlifeCount == 2) || (nlifeCount == 3))) {
            aliveState = true;
        }
        return new GameLife(aliveState, posX, posY, newWorld);
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public boolean equals(Object object) {
        if (object == null || !(object instanceof GameLife)) {
            return false;
        }
        GameLife gameLife = (GameLife) object;

        if (this.getPosX() != gameLife.getPosX()) {
            return false;
        } else if (this.getPosY() != gameLife.getPosY()) {
            return false;
        } else if (this.isAlive() != gameLife.isAlive()) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        String id = posX + ":" + posY + ":" + myWorld.hashCode();
        return id.hashCode();
    }
}
