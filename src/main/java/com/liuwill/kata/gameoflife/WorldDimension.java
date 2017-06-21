package com.liuwill.kata.gameoflife;

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

    public int size() {
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

    public boolean equals(Object object) {
        if (object == null || !(object instanceof WorldDimension)) {
            return false;
        }
        WorldDimension dimension = (WorldDimension) object;

        if (this.getHeight() != dimension.getHeight()) {
            return false;
        } else if (this.getWidth() != dimension.getWidth()) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        String id = width + ":" + height;
        return id.hashCode();
    }
}
