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
}
