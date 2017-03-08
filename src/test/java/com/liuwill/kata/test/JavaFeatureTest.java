package com.liuwill.kata.test;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by videopls on 2017/3/7.
 */
public class JavaFeatureTest {
    @Test
    public void test() throws Throwable {
        String[] strList = new String[]{};
        assertEquals(0,strList.length);
        System.out.println(strList.length);

        String[] strList1 = new String[]{"",""};
        assertEquals(2,strList1.length);

        String[] strList2 = new String[2];
        assertEquals(2,strList2.length);
    }
}
