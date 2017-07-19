package com.liuwill.kata.fizzbuzz;

/**
 * Created by Liu Will on 2017/7/19.
 */
public class TemplateTranslator {
    public static final String FIZZ_WORD = "Fizz";
    public static final String BUZZ_WORD = "Buzz";

    public static String translate(Integer i) {
        StringBuilder builder = new StringBuilder();
        handleFizz(builder, i);

        handleBuzz(builder, i);

        handleOther(builder, i);
        return builder.toString();
    }

    public static void handleFizz(StringBuilder builder, Integer i) {
        if(isFizz(i)){
            builder.append(FIZZ_WORD);
        }
    }

    public static void handleBuzz(StringBuilder builder, Integer i) {
        if(isBuzz(i)){
            builder.append(BUZZ_WORD);
        }
    }

    public static void handleOther(StringBuilder builder, Integer i) {
        if(builder.length() == 0){
            builder.append(i.toString());
        }
    }

    public static boolean isFizz(int i) {
        return i % 3 == 0;
    }

    public static boolean isBuzz(int i) {
        return i % 5 == 0;
    }
}
