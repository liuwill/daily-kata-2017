package com.liuwill.kata.diversion;

/**
 * Created by liuwill on 2017/3/10.
 */
public class DiversionHelper {
    public static int count(int number) {
        int[] resultArr = new int[number + 1];

        for (int i = 0; i <= number; i++) {
            if (i == 0) {
                resultArr[i] = 1;
            } else if (i == 1) {
                resultArr[i] = 2;
            } else {
                resultArr[i] = resultArr[i - 1] + resultArr[i - 2];
            }
        }

        return resultArr[number];
    }
}
