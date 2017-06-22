package com.liuwill.kata.phonenumbers;

import java.util.regex.Pattern;

/**
 * Created by Liu Will on 2017/6/14.
 */
public abstract class PhoneNumberReader {
    public static PhoneNumbersArbiter arbiterFactory(String[] rawContactors) {
        PhoneNumbersArbiter phoneNumbersArbiter = new PhoneNumbersArbiter();

        for (String rawContactor : rawContactors) {
            Contactor contactor = contactorFactory(rawContactor);

            phoneNumbersArbiter.addContactor(contactor);
        }

        return phoneNumbersArbiter;
    }

    public static Contactor contactorFactory(String sample) {
        if (sample == null) {
            throw new IllegalArgumentException();
        } else if ("".equals(sample)) {
            throw new IllegalArgumentException();
        }

        String[] sampleItmes = sample.split(" ");
        if (sampleItmes.length < 2) {
            throw new IllegalArgumentException();
        }

        String name = sampleItmes[0];
        String[] targetPhoneItems = new String[sampleItmes.length - 1];
        System.arraycopy(sampleItmes, 1, targetPhoneItems, 0, targetPhoneItems.length);

        String phoneNumber = joinStr(targetPhoneItems);
        if(!isNumeric(phoneNumber)){
            throw new IllegalArgumentException();
        }
        return new Contactor(name, phoneNumber);
    }

    private static String joinStr(String[] strList) {
        StringBuilder targetBuilder = new StringBuilder();
        for (String item : strList) {
            targetBuilder.append(item);
        }

        return targetBuilder.toString();
    }

    private static boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }
}
