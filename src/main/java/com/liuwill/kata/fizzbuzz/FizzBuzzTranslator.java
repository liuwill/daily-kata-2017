package com.liuwill.kata.fizzbuzz;

/**
 * Created by Liu Will on 2017/7/19.
 */
public class FizzBuzzTranslator {
    public static final String FIZZ_WORD = "fizz";
    public static final String BUZZ_WORD = "buzz";

    public static String translate(Integer i) {
        StringBuilder builder = new StringBuilder();
        if (isFizz(i)) {
            builder.append(FIZZ_WORD);
        } else if (isBuzz(i)) {
            builder.append(BUZZ_WORD);
        }

        if (builder.length() == 0) {
            builder.append(i.toString());
        }
        return builder.toString();
    }

    public static boolean isFizz(int i) {
        return i % 3 == 0;
    }

    public static boolean isBuzz(int i) {
        return i % 5 == 0;
    }
}
