package com.liuwill.kata.GameOfLife;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by videopls on 2017/4/23.
 */
public class GodOfWorld {
    private Map<String,GameWorld> myWorldMap;
    private GameWorld myWorld;
    private int day;

    public GodOfWorld() {
        day = 0;
        this.myWorldMap = new HashMap<>();
    }

    public GameWorld createWorld(int width,int height){
        String name = getDayName(day++);
        return createWorld(name,width,height);
    }

    public String getDayName(int day){
        return String.format("%d day", day);
    }

    private GameWorld createWorld(String name,int width,int height){
        GameWorld gameWorld = GameWorld.makeWorld(width,height);
        myWorldMap.put(name,gameWorld);
        gameWorld.setGodOfWorld(this);

        return gameWorld;
    }

    public GameWorld getGameWorld(){
        return myWorld;
    }

    public GameWorld getGameWorldByName(String name) {
        if(!myWorldMap.containsKey(name)){
            throw new IndexOutOfBoundsException();
        }
        return myWorldMap.get(name);
    }

    public void updateWorld(GameWorld newWorld){

    }
}
