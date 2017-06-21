package com.liuwill.kata.phonenumbers;

/**
 * Created by Liu Will on 2017/6/20.
 */
public class PhoneNumberMain {
    public static boolean consistent(String[] rawInput) {
        PhoneNumbersArbiter arbiter = PhoneNumberReader.arbiterFactory(rawInput);

        return arbiter.isConsistent();
    }
}
