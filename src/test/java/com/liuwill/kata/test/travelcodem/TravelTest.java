package com.liuwill.kata.test.travelcodem;

import com.liuwill.kata.codem.travel.TravelPuzzle;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by Liu Will on 2017/7/29.
 */
public class TravelTest {
    @Test
    public void testTraval() {
        String input = "5 4\n"
            + "3 5 1 2 4\n"
            + "1 2\n"
            + "1 3\n"
            + "2 4\n"
            + "3 5\n"
            + "4 2 1\n"
            + "4 2 2\n"
            + "4 2 3\n"
            + "5 1 5";

        String[] lines = input.split("\n");

        String[] cityData = lines[0].split(" ");

        int citySize = Integer.parseInt(cityData[0]);
        int travelTimes = Integer.parseInt(cityData[1]);
        assertEquals(cityData.length, 2);


        int[] results = TravelPuzzle.run(input);
        assertEquals(results.length, travelTimes);
        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i]);
        }
    }
}
