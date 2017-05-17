package com.liuwill.kata.GameOfLife;

/**
 * Created by LiuWill on 2017/4/23.
 */
public class WorldDimension {
    private int width;
    private int height;

    public WorldDimension(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int size(){
        return width * height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean equals(WorldDimension dimension){
        if(dimension == null){
            return false;
        }else if(this.getHeight() != dimension.getHeight()){
            return false;
        }else if(this.getWidth() != dimension.getWidth()){
            return false;
        }

        return true;
    }
}
