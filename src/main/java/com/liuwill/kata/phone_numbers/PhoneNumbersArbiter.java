package com.liuwill.kata.phone_numbers;

import java.util.List;

/**
 * Created by Liu Will on 2017/6/14.
 */
public class PhoneNumbersArbiter {
    public List<Contactor> contactors;
    private boolean consistent;

    public static boolean detectInConsistent(Contactor contact1, Contactor contact2) {
        String bigPhone;
        String smallPhone;

        if(contact1.compareTo(contact2)>0){
            bigPhone = contact1.getPhone();
            smallPhone = contact2.getPhone();
        }else{
            bigPhone = contact2.getPhone();
            smallPhone = contact1.getPhone();
        }

        return smallPhone.equals(bigPhone.substring(0, smallPhone.length()));
    }
}
