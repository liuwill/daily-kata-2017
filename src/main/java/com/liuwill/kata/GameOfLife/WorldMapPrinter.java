package com.liuwill.kata.GameOfLife;

/**
 * Created by LiuWill on 2017/4/23.
 */
public class WorldMapPrinter {
    public String stringify(GameWorld gameWorld){
        WorldDimension dimension = gameWorld.getDimension();

        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<dimension.getWidth();i++){
            for(int j=0;j<dimension.getHeight();j++){
                GameLife gameLife = gameWorld.getLifeAt(i,j);
                if(gameLife.isAlive()){
                    stringBuilder.append("*");
                }else{
                    stringBuilder.append(".");
                }
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString().trim();
    }

    public void print(GameWorld gameWorld){
        System.out.println(stringify(gameWorld));
    }

    public void println(GameWorld gameWorld){
        print(gameWorld);
        System.out.println();
    }
}
