package com.liuwill.kata.MineField;

/**
 * Created by videopls on 2017/5/14.
 */
public abstract class BaseEntity implements FieldEcho,Printable{

    private FieldPosition fieldPosition;
    protected Integer nearCount;

    public BaseEntity(FieldPosition fieldPosition){
        nearCount = 0;
        this.fieldPosition = fieldPosition;
    }

    public void findMine(){
        nearCount++;
    }

    public FieldPosition getFieldPosition() {
        return fieldPosition;
    }
}
