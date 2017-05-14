package com.liuwill.kata.MineField;

/**
 * Created by videopls on 2017/5/14.
 */
public class Blank extends BaseEntity{
    public Blank(FieldPosition fieldPosition) {
        super(fieldPosition);
    }

    @Override
    public String getIcon() {
        if(nearCount > 0){
            return nearCount.toString();
        }
        return MineField.BLANK_ICON;
    }

    @Override
    public String getRawIcon() {
        return MineField.BLANK_ICON;
    }

    @Override
    public boolean isMine() {
        return false;
    }

    @Override
    public int getCount() {
        return nearCount;
    }
}
