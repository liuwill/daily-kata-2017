package com.liuwill.kata.combinednumber;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by videopls on 2017/3/1.
 */
public class CombinedNumberMain {
    public static int answer(int arg0, int arg1) {
        return arg0 * arg1;
    }

    public static String calc(List<String> dataList) {
        Collections.sort(dataList, (o1, o2) -> CombinedNumber.compareStringValue(o1, o2));

        //StringJoiner joiner = new StringJoiner("","","");
        String joinStr = String.join("", dataList);
        return joinStr;
    }
}
