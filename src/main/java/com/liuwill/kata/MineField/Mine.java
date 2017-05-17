package com.liuwill.kata.MineField;

/**
 * Created by LiuWill on 2017/5/14.
 */
public class Mine extends BaseEntity {
    public Mine(FieldPosition fieldPosition) {
        super(fieldPosition);
    }

    @Override
    public String getIcon() {
        return MineField.MINE_ICON;
    }

    @Override
    public String getRawIcon() {
        return MineField.MINE_ICON;
    }

    @Override
    public boolean isMine() {
        return true;
    }

    @Override
    public int getCount() {
        return nearCount;
    }
}
