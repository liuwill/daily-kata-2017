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
    private Map<FieldPosition,Block> mineField;

    public MineField(FieldDimension fieldDimension){
        this.fieldDimension = fieldDimension;

        mineField = new LinkedHashMap<>();

        for(int x=0;x<fieldDimension.getWidth();x++){
            for(int y=0;y<fieldDimension.getHeight();y++){
                FieldPosition fieldPosition = new FieldPosition(x,y);
                BaseEntity baseEntity = new Blank(new FieldPosition(x,y));
                mineField.put(fieldPosition, new Block(baseEntity));
            }
        }
    }

    public void setMine(FieldPosition fieldPosition){
        if(fieldPosition.getX() >= fieldDimension.getWidth() || fieldPosition.getX() < 0
                || fieldPosition.getY() >= fieldDimension.getHeight() || fieldPosition.getY() < 0){
            throw new IndexOutOfBoundsException();
        }

        int x = fieldPosition.getX();
        int y = fieldPosition.getY();

        BaseEntity baseEntity = new Mine(new FieldPosition(x,y));
        Block block = mineField.get(new FieldPosition(x,y));

        block.setBlockItem(baseEntity);

        for(FieldPosition neighbourPosition : block.getFieldPosition().getNeighbours(fieldDimension)){
            Block neighbourBlock = mineField.get(neighbourPosition);
            neighbourBlock.updateCount();
        }
    }

    public Map<FieldPosition, Block> getMineField() {
        return mineField;
    }

    public Block getItemFromPos(FieldPosition fieldPosition){
        return mineField.get(fieldPosition);
    }

    public MineField MineFieldFactory(){
        return new MineField(null);
    }

    public FieldDimension getFieldDimension() {
        return fieldDimension;
    }
}
