package com.liuwill.kata.phone_numbers;

/**
 * Created by Liu Will on 2017/6/14.
 */
public class PhoneNumberReader {
    public static Contactor contactorFactory(String sample) {
        if(sample == null){
            throw new IllegalArgumentException();
        }else if("".equals(sample)){
            throw new IllegalArgumentException();
        }

        String[] sampleItmes = sample.split(" ");
        if(sampleItmes.length < 2){
            throw new IllegalArgumentException();
        }

        String name = sampleItmes[0];
        String[] targetPhoneItems = new String[sampleItmes.length-1];
        System.arraycopy(sampleItmes, 1, targetPhoneItems,0,targetPhoneItems.length);

        return new Contactor(name, joinStr(targetPhoneItems));
    }

    public static String joinStr(String[] strList){
        StringBuilder targetBuilder = new StringBuilder();
        for(String item :strList){
            targetBuilder.append(item);
        }

        return targetBuilder.toString();
    }
}
