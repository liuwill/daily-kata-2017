package com.liuwill.kata.MineField;

/**
 * Created by videopls on 2017/5/14.
 */
public class FieldDimension {
    private int width;
    private int height;

    public FieldDimension(int width, int height) {
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

    public boolean equals(FieldDimension dimension){
        if(dimension == null){
            return false;
        }else if(this.getHeight() != dimension.getHeight()){
            return false;
        }else if(this.getWidth() != dimension.getWidth()){
            return false;
        }

        return true;
    }

    @Override
    public String toString(){
        return "Dimension [width:"+ width +" - height:"+ height +"]";
    }
}
