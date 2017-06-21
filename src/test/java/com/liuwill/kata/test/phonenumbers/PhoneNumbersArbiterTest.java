package com.liuwill.kata.test.phonenumbers;

import com.liuwill.kata.phonenumbers.Contactor;
import com.liuwill.kata.phonenumbers.PhoneNumberReader;
import com.liuwill.kata.phonenumbers.PhoneNumbersArbiter;
import org.junit.AfterClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Liu Will on 2017/6/14.
 */
public class PhoneNumbersArbiterTest {
    @Test
    public void testComparePhone() {
        String p1 = "Bob 91 132 424 32";
        String p2 = "Alice 911";
        String p3 = "Alice 91 212";

        Contactor c1 = PhoneNumberReader.contactorFactory(p1);
        Contactor c2 = PhoneNumberReader.contactorFactory(p2);
        Contactor c3 = PhoneNumberReader.contactorFactory(p3);

        assertTrue(PhoneNumbersArbiter.detectInConsistent(c1, c2));
        assertFalse(PhoneNumbersArbiter.detectInConsistent(c2, c3));
    }

    @Test
    public void testArbiter() {
        String[] rawContactors = {"Bob 91 12 54 26", "Alice 97 625 992", "Emergency 911"};

        PhoneNumbersArbiter arbiter = new PhoneNumbersArbiter();
        assertTrue(arbiter.isConsistent());
        assertNotEquals(arbiter.getContactors().size(), rawContactors.length);
        assertEquals(0, arbiter.getContactors().size());

        for (String rawContactor : rawContactors) {
            Contactor contactor = PhoneNumberReader.contactorFactory(rawContactor);
            arbiter.addContactor(contactor);
        }

        assertEquals(arbiter.getContactors().size(), rawContactors.length);
        assertFalse(arbiter.isConsistent());
    }

    @AfterClass
    public static void outputResult() {
        System.out.println("Phone Numbers Arbiter Test.");
    }
}
