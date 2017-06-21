package com.liuwill.kata.diversion

/**
 * Created by LiuWill on 2017/3/14.
 */

class BinaryDiversion {

    fun count(number: Int): Int {
        val resultArr = IntArray(number + 1)

        for (i in 0..number) {
            if (i == 0) {
                resultArr[i] = 1
            } else if (i == 1) {
                resultArr[i] = 2
            } else {
                resultArr[i] = resultArr[i - 1] + resultArr[i - 2]
            }
        }

        return resultArr[number]
    }
}