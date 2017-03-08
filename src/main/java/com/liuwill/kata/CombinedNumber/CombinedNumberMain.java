package com.liuwill.kata.CombinedNumber;

import java.util.*;

/**
 * Created by videopls on 2017/3/1.
 */
public class CombinedNumberMain {
    public static int answer(int arg0,int arg1){
        return arg0*arg1;
    }

    public static String calc(List<String> dataList) {
        Collections.sort(dataList,new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return CombinedNumber.compareStringValue(o1,o2);
            }
        });

        //StringJoiner joiner = new StringJoiner("","","");
        String joinStr = String.join("",dataList);
        return joinStr;
    }
}
