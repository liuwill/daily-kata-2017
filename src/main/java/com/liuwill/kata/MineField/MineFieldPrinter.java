package com.liuwill.kata.MineField;

/**
 * Created by videopls on 2017/5/15.
 */
public class MineFieldPrinter {
    public String printRawField(MineField mineField){
        StringBuilder stringBuilder = new StringBuilder();
        FieldDimension fieldDimension = mineField.getFieldDimension();
        for(int y = 0 ; y < fieldDimension.getHeight(); y++){
            for(int x = 0 ; x < fieldDimension.getWidth(); x++){
                FieldPosition fieldPosition = new FieldPosition(x,y);
                Block block = mineField.getItemFromPos(fieldPosition);
                stringBuilder.append(block.getRawIcon());
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString().trim();
    }

    public String printField(MineField mineField){
        StringBuilder stringBuilder = new StringBuilder();
        FieldDimension fieldDimension = mineField.getFieldDimension();
        for(int y = 0 ; y < fieldDimension.getHeight(); y++){
            for(int x = 0 ; x < fieldDimension.getWidth(); x++){
                FieldPosition fieldPosition = new FieldPosition(x,y);
                Block block = mineField.getItemFromPos(fieldPosition);
                stringBuilder.append(block.getIcon());
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString().trim();
    }
}
