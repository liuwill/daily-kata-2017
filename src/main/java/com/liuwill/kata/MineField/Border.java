package com.liuwill.kata.MineField;

/**
 * Created by videopls on 2017/5/14.
 */
public class Border extends BaseEntity{
    public Border(FieldPosition fieldPosition) {
        super(fieldPosition);
    }

    @Override
    public String getIcon() {
        return "";
    }

    @Override
    public boolean isMine() {
        return false;
    }

    @Override
    public int getCount() {
        return 0;
    }
}