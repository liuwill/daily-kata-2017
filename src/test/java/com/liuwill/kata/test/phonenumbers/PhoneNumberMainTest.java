package com.liuwill.kata.test.phonenumbers;

import com.liuwill.kata.phonenumbers.PhoneNumberMain;
import org.junit.AfterClass;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Liu Will on 2017/6/20.
 */
public class PhoneNumberMainTest {
    @Test
    public void testMore() {
        String[] wrongContactors = {"Bob 91 12 54 26", "Alice 97 625 992", "Emergency 911"};
        String[] rightContactors = {
            "Bob 91 12 54 26", "Odin 234 324", "Alice 97 625 992",
            "Emergency 87 53 35", "Will 78 4352 2345"
        };

        assertFalse(PhoneNumberMain.consistent(wrongContactors));
        assertTrue(PhoneNumberMain.consistent(rightContactors));
    }

    @AfterClass
    public static void outputResult() {
        System.out.println("Phone Numbers Main Test.");
    }
}
