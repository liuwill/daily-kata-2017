package com.liuwill.kata.Diversion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by videopls on 2017/3/9.
 */
public class DiversionMain {
    public static int countMatch(String[] datas){
        if(datas == null){
            return 0;
        }

        int count = 0;
        for(String item : datas){
            if (match(item)) {
                count++;
            }
        }
        return count;
    }

    public static boolean match(String str) {
        boolean mark = false;

        for(int i=0; i<str.length();i++){
            char character = str.charAt(i);
            if(character != '0' && character != '1'){
                return false;
            }

            if(character == '1' && mark){
                return false;
            }else if(character == '1'){
                mark = true;
            }else{
                mark = false;
            }
        }
        return true;
    }

    public static int countCombinations(int bit){
        return (int)Math.pow(2, bit);
    }

    public static String[] build(int bit) {
        String[] resultArr = new String[]{""};

        String[] bits = new String[]{"0","1"};
        for(int i = 0; i<bit ; i++){
            String[] tempArr = new String[resultArr.length*2];
            int tempPos = 0;
            for(int j = 0;j < resultArr.length;j++){
                String rawStr = resultArr[j];

                for(String header:bits){
                    String targetStr = header + rawStr;
                    tempArr[tempPos] = targetStr;
                    tempPos++;
                }
            }
            resultArr = tempArr;
        }

        return resultArr;
    }
}
