package com.liuwill.kata.MineField;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by videopls on 2017/5/14.
 */
public class MineField {
    public static final String MINE_ICON = "*";
    public static final String BLANK_ICON = ".";

    private FieldDimension fieldDimension;
    private Map<String,BaseEntity> mineField;

    public MineField(FieldDimension fieldDimension){
        this.fieldDimension = fieldDimension;

        mineField = new LinkedHashMap<>();

        for(int x=0;x<fieldDimension.getWidth();x++){
            for(int y=0;y<fieldDimension.getHeight();y++){
                mineField.put(x+":"+y, new Blank(new FieldPosition(x,y)));
            }
        }
    }

    public void setMine(FieldPosition fieldPosition){
        if(fieldPosition.getX() >= fieldDimension.getWidth() || fieldPosition.getX() <= 0
                || fieldPosition.getY() >= fieldDimension.getHeight() || fieldPosition.getY() <= 0){
            throw new IndexOutOfBoundsException();
        }


    }

    public MineField MineFieldFactory(){
        return new MineField(null);
    }

    public FieldDimension getFieldDimension() {
        return fieldDimension;
    }
}
