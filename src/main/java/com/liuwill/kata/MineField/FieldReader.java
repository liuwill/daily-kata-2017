package com.liuwill.kata.MineField;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by videopls on 2017/5/14.
 */
public class FieldReader {
    public static List<FieldPosition> readMineFieldPositionsFromSource(String rawFieldStr){
        String[] strArr = rawFieldStr.trim().split("\n");
        List<FieldPosition> fieldPositionList = new ArrayList<>();

        int y = 0;
        for(String line: strArr){
            for(int x=0; x<line.length(); x++){
                if(MineField.MINE_ICON.equals(line.substring(x,x+1))){
                    fieldPositionList.add(new FieldPosition(x,y));
                }
            }
            y++;
        }

        return fieldPositionList;
    }

    public static MineField readMineFieldFromSource(int width,int height,String rawFieldStr){
        FieldDimension fieldDimension = new FieldDimension(width,height);
        List<FieldPosition> positionList = readMineFieldPositionsFromSource(rawFieldStr);

        MineField mineField = new MineField(fieldDimension);
        for(FieldPosition minePos: positionList){
            mineField.setMine(minePos);
        }
        return mineField;
    }

    public static MineField readMineFieldFromSource(String rawFieldStr){
        FieldDimension fieldDimension = readDimensionFromSource(rawFieldStr);
        List<FieldPosition> positionList = readMineFieldPositionsFromSource(rawFieldStr);

        MineField mineField = new MineField(fieldDimension);
        for(FieldPosition minePos: positionList){
            mineField.setMine(minePos);
        }
        return mineField;
    }

    public static FieldDimension readDimensionFromSource(String rawFieldStr){
        String[] mineLines = rawFieldStr.trim().split("\n");
        int height = mineLines.length;
        int width = mineLines[0].length();

        return new FieldDimension(width,height);
    }
}
