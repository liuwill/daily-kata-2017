package com.liuwill.kata.test.phone_numbers;

import com.liuwill.kata.phone_numbers.Contactor;
import com.liuwill.kata.phone_numbers.PhoneNumberReader;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Liu Will on 2017/6/14.
 */
public class PhoneNumberReaderTest {
    @Rule
    public ExpectedException thrown= ExpectedException.none();

    @Test
    public void readSingleLineError() throws IllegalArgumentException {
        thrown.expect(IllegalArgumentException.class);
        PhoneNumberReader.contactorFactory(null);

        thrown.expect(IllegalArgumentException.class);
        PhoneNumberReader.contactorFactory("");

        thrown.expect(IllegalArgumentException.class);
        PhoneNumberReader.contactorFactory("Bob");

        thrown.expect(IllegalArgumentException.class);
        PhoneNumberReader.contactorFactory("Bob 91 liu 54 26");
    }

    @Test
    public void readSingleLine() {
        String sample = "Bob 91 12 54 26";
        Contactor contactor = PhoneNumberReader.contactorFactory(sample);

        assertNotNull(contactor);
        assertEquals(contactor.getName(), "Bob");
        assertEquals(contactor.getPhone(), "91125426");
    }

//    @Test
//    public void readContactors() {
//        String sample = "Bob 91 12 54 26";
//        Contactor contactor = PhoneNumberReader.contactorFactory(sample);
//
//        assertNotNull(contactor);
//        assertEquals(contactor.getName(), "Bob");
//        assertEquals(contactor.getPhone(), "91125426");
//    }

    @AfterClass
    public static void outputResult(){
        System.out.println("Phone Numbers Reader Test.");
    }
}
