package com.liuwill.kata.phone_numbers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liu Will on 2017/6/14.
 */
public class PhoneNumbersArbiter {
    private List<Contactor> contactors;
    private boolean consistent;

    public PhoneNumbersArbiter(){
        contactors = new ArrayList<>();
        consistent = true;
    }

    public boolean isConsistent() {
        return consistent;
    }

    public void addContactor(Contactor contactor){
        for(Contactor aContactor : contactors){
            if(detectInConsistent(contactor,aContactor)){
                consistent = false;
            }
        }

        contactors.add(contactor);
    }

    public List<Contactor> getContactors() {
        return contactors;
    }

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
