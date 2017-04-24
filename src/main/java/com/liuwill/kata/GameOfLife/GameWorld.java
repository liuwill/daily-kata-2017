package com.liuwill.kata.GameOfLife;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by videopls on 2017/4/23.
 */
public class GameWorld {
    private GodOfWorld godOfWorld;
    private WorldDimension dimension;
    private GameLife[][] worldMap;
    private boolean isAlive;

    private GameWorld(WorldDimension dimension) {
        this.dimension = dimension;

        isAlive = false;
        init(dimension);
    }

    private void init(WorldDimension dimension){
        if(dimension == null){
            throw new NullPointerException("world dimension can not be null");
        }

        worldMap = new GameLife[dimension.getWidth()][dimension.getHeight()];
    }

    public void setGodOfWorld(GodOfWorld godOfWorld){
        this.godOfWorld = godOfWorld;
    }

    public void createLife(List<GameLife> gameLives){
        if(gameLives.size() > dimension.size()){
            throw new OutOfMemoryError();
        }

        for(GameLife life: gameLives){
            int x = life.getX();
            int y = life.getY();
            worldMap[x][y] = life;

            if(life.isAlive()){
                isAlive = true;
            }
        }

        if(godOfWorld != null) {
            godOfWorld.updateWorld(this);
        }
    }

    public GameWorld grow(){
        GameWorld newWorld = null;
        if(godOfWorld == null){
            newWorld = GameWorld.makeWorld(dimension.getWidth(),dimension.getHeight());
        }else{
            newWorld = godOfWorld.createWorld(dimension.getWidth(),dimension.getHeight());
        }

        List<GameLife> newLives = new ArrayList<>();
        for(int x = 0; x < dimension.getWidth(); x++){
            for(int y = 0; y < dimension.getHeight(); y++){
                newLives.add(getLifeAt(x,y).grow(newWorld));
            }
        }

        newWorld.createLife(newLives);
        return newWorld;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public GameLife getLifeAt(int x, int y){
        if(isOutOfTheWorld(x,y)){
            return new NullSpace(this);
        }

        return worldMap[x][y];
    }

    public boolean isOutOfTheWorld(int x, int y){
        if(x < 0 || y < 0){
            return true;
        }else if(x >= dimension.getWidth() || y >= dimension.getHeight()){
            return true;
        }

        return false;
    }

    public WorldDimension getDimension(){
        return dimension;
    }

    public static GameWorld makeWorld(int width,int height){
        WorldDimension dimension = new WorldDimension(width,height);
        return new GameWorld(dimension);
    }

    public boolean equals(GameWorld gameWorld){
        if(gameWorld == null){
            return false;
        }else if(!this.dimension.equals(gameWorld.getDimension())){
            return false;
        }

        for(int i=0;i<this.dimension.getWidth(); i++){
            for(int j=0;j<this.dimension.getHeight();j++){
                if(!this.getLifeAt(i,j).equals(gameWorld.getLifeAt(i,j))){
                    return false;
                }
            }
        }

        return true;
    }
}
