package com.liuwill.kata.GameOfLife;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by videopls on 2017/4/23.
 */
public class LifeCreator {
    public List<GameLife> generateLivedFromData(Integer[][] source,GameWorld gameWorld){
        List<GameLife> resultList = new ArrayList<>();

        for(int i=0;i<source.length;i++){
            Integer[] line = source[i];
            for(int j = 0;j<line.length;j++){
                Integer item = line[j];
                boolean isAlive = (item == 1);

                resultList.add(new GameLife(isAlive,i,j,gameWorld));
            }
        }

        return resultList;
    }

    public Integer[][] parseBitsFromMap(String mapStr){
        mapStr = mapStr.trim();
        String[] rows = mapStr.split("\n");

        WorldDimension dimension = parseDimension(mapStr);
        int width = dimension.getWidth();
        int height = dimension.getHeight();

        Integer[][] resultBits = new Integer[width][height];
        int i = 0;
        for(String line:rows){
            for(int j=0;j<line.length();j++){
                resultBits[i][j] = parseBit(line.substring(j,j+1));
            }
            i++;
        }

        return resultBits;
    }

    public WorldDimension parseDimension(String input){
        input = input.trim();

        String[] rows = input.split("\n");
        int width = rows.length;
        int height = rows.length>0?rows[0].length():0;

        return new WorldDimension(width,height);
    }

    public int parseBit(String bit){
        if(".".equals(bit)){
            return 0;
        }else if("*".equals(bit)){
            return 1;
        }

        throw new IndexOutOfBoundsException();
    }

    public List<GameLife> parseLivesFromMap(String mapStr,GameWorld gameWorld){
        return generateLivedFromData(parseBitsFromMap(mapStr),gameWorld);
    }
}
