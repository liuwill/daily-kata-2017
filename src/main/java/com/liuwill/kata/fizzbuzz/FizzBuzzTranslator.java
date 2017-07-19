package com.liuwill.kata.fizzbuzz;

/**
 * Created by Liu Will on 2017/7/19.
 */
public class FizzBuzzTranslator {
    public static final String FIZZ_WORD = "fizz";
    public static final String BUZZ_WORD = "buzz";

    public static String translate(Integer i) {
        if (i % 3 == 0) {
            return FIZZ_WORD;
        } else if (i % 5 == 0) {
            return BUZZ_WORD;
        }
        return i.toString();
    }
}
