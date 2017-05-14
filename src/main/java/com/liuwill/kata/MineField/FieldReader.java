package com.liuwill.kata.MineField;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by videopls on 2017/5/14.
 */
public class FieldReader {
    public static List<FieldPosition> readMineFieldFromSource(String rawFieldStr){
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
}
