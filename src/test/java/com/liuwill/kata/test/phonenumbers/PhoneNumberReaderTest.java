package com.liuwill.kata.test.phonenumbers;

import com.liuwill.kata.phonenumbers.Contactor;
import com.liuwill.kata.phonenumbers.PhoneNumberReader;
import com.liuwill.kata.phonenumbers.PhoneNumbersArbiter;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Liu Will on 2017/6/14.
 */
public class PhoneNumberReaderTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testArbiter() {
        String[] rawContactors = {"Bob 91 12 54 26", "Alice 97 625 992", "Emergency 911"};
        PhoneNumbersArbiter arbiter = PhoneNumberReader.arbiterFactory(rawContactors);

        List<Contactor> arbiterContactors = arbiter.getContactors();
        assertEquals(rawContactors.length, arbiterContactors.size());

        for (int i = 0; i < rawContactors.length; i++) {
            Contactor newContactor = PhoneNumberReader.contactorFactory(rawContactors[i]);
            assertEquals(newContactor, arbiterContactors.get(i));
        }

        assertFalse(arbiter.isConsistent());
    }

    @Test
    public void readNullError() throws IllegalArgumentException {
        thrown.expect(IllegalArgumentException.class);
        PhoneNumberReader.contactorFactory(null);
    }

    @Test
    public void readBlankError() throws IllegalArgumentException {
        thrown.expect(IllegalArgumentException.class);
        PhoneNumberReader.contactorFactory("");
    }

    @Test
    public void readNameOblyError() throws IllegalArgumentException {
        thrown.expect(IllegalArgumentException.class);
        PhoneNumberReader.contactorFactory("Bob");
    }

    @Test
    public void readWrongNumberError() throws IllegalArgumentException {
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

    /*
    @Test
    public void readContactors() {
        String sample = "Bob 91 12 54 26";
        Contactor contactor = PhoneNumberReader.contactorFactory(sample);

        assertNotNull(contactor);
        assertEquals(contactor.getName(), "Bob");
        assertEquals(contactor.getPhone(), "91125426");
    }
    */

    @AfterClass
    public static void outputResult() {
        System.out.println("Phone Numbers Reader Test.");
    }
}
