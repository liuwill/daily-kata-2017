package com.liuwill.kata.test.phonenumbers;

import com.liuwill.kata.phonenumbers.Contactor;
import com.liuwill.kata.phonenumbers.PhoneNumberReader;
import org.junit.AfterClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Liu Will on 2017/6/14.
 */
public class ContactorTest {
    @Test
    public void testCompare() {
        String p1 = "Bob 21 4324 2432";
        String p2 = "Alice 4 324 2432";

        Contactor c1 = PhoneNumberReader.contactorFactory(p1);
        Contactor c2 = PhoneNumberReader.contactorFactory(p2);

        assertTrue(c1.compareTo(c2) > 0);
    }

    @Test
    public void testSort() {
        String[] strList = {"Bob 21 4324 2432", "Clark 624 2432", "Alice 4 324 2432"};

        List<Contactor> contactors = new ArrayList<>();
        for (String str : strList) {
            contactors.add(PhoneNumberReader.contactorFactory(str));
        }

        Collections.sort(contactors, new Comparator<Contactor>() {
            @Override
            public int compare(Contactor b1, Contactor b2) {
                return b1.compareTo(b2);
            }
        });

        Contactor firstContactor = contactors.get(0);
        Contactor lastContactor = contactors.get(contactors.size() - 1);

        Contactor rawFirstContactor = PhoneNumberReader.contactorFactory(strList[1]);
        Contactor rawLastContactor = PhoneNumberReader.contactorFactory(strList[0]);

        assertEquals(firstContactor.getName(), rawFirstContactor.getName());
        assertEquals(lastContactor.getName(), rawLastContactor.getName());
        assertEquals(lastContactor.getPhone(), rawLastContactor.getPhone());

        assertNotEquals(lastContactor, firstContactor);
        assertEquals(rawFirstContactor, firstContactor);
    }

    @AfterClass
    public static void outputResult() {
        System.out.println("Phone Numbers Contactor Test.");
    }
}
