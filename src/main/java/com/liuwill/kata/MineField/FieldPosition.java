package com.liuwill.kata.MineField;

/**
 * Created by videopls on 2017/5/14.
 */
public class FieldPosition {
    private Integer x;
    private Integer y;

    public FieldPosition(int x,int y){
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public String toString(){
        return "Position [x:"+x+" - y:"+y+"]";
    }
}
