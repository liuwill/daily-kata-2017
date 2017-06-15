package com.liuwill.kata.test.phone_numbers;

import com.liuwill.kata.phone_numbers.Contactor;
import com.liuwill.kata.phone_numbers.PhoneNumberReader;
import com.liuwill.kata.phone_numbers.PhoneNumbersArbiter;
import org.junit.AfterClass;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Liu Will on 2017/6/14.
 */
public class PhoneNumbersArbiterTest {
    @Test
    public void testComparePhone(){
        String p1 = "Bob 91 132 424 32";
        String p2 = "Alice 911";
        String p3 = "Alice 91 212";

        Contactor c1 = PhoneNumberReader.contactorFactory(p1);
        Contactor c2 = PhoneNumberReader.contactorFactory(p2);
        Contactor c3 = PhoneNumberReader.contactorFactory(p3);

        assertTrue(PhoneNumbersArbiter.detectInConsistent(c1,c2));
        assertFalse(PhoneNumbersArbiter.detectInConsistent(c2,c3));
    }

    @AfterClass
    public static void outputResult(){
        System.out.println("Phone Numbers Arbiter Test.");
    }
}
