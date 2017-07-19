package com.liuwill.kata.fizzbuzz;

import java.util.List;

/**
 * Created by Liu Will on 2017/7/19.
 */
public class RulableTranslator {
    public static final String FIZZ_WORD = "Fizz";
    public static final String BUZZ_WORD = "Buzz";

    public static String translate(List<TranslateRule> rules, Integer i) {
        StringBuilder builder = new StringBuilder();
        for (TranslateRule rule : rules) {
            rule.handle(builder, i);
        }
        return builder.toString();
    }
}
