package com.liuwill.kata.codem.travel;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Liu Will on 2017/7/29.
 */
public class TravelPuzzle {
    public static int[] run(String input) {
        String[] lines = input.split("\n");

        String[] cityData = lines[0].split(" ");

        int citySize = Integer.parseInt(cityData[0]);
        int travelTimes = Integer.parseInt(cityData[1]);

        String[] cityValue = lines[1].split(" ");
        List<String> cityValueList = Arrays.asList(cityValue);

        int[][] roadMatrix = new int[citySize][citySize];
        for (int i = 0; i < citySize; i++) {
            for (int j = 0; j < citySize; j++) {
                roadMatrix[i][j] = 0;
            }
        }

        int step = 2;
        for (int i = 0; i < citySize - 1; i++) {
            String roadLine = lines[step++];

            String[] roadData = roadLine.split(" ");
            int start = Integer.parseInt(roadData[0]);
            int end = Integer.parseInt(roadData[1]);

            roadMatrix[start - 1][end - 1] = 1;
            roadMatrix[end - 1][start - 1] = 1;
        }

        int[] results = new int[travelTimes];
        for (int i = 0; i < travelTimes; i++) {
            String travelLine = lines[step++];

            String[] travelRoute = travelLine.split(" ");
            int startCity = Integer.parseInt(travelRoute[0]);
            int endCity = Integer.parseInt(travelRoute[1]);
            int initPearl = Integer.parseInt(travelRoute[2]);

            int[][] pathStack = new int[citySize][2];
            int[] routeStack = new int[citySize];
            int stackPos = 0;

            int[] currnetStruct = {startCity, 0};
            routeStack[stackPos] = startCity;
            pathStack[stackPos++] = currnetStruct;

            while (pathStack[stackPos - 1][0] != endCity || startCity < 1) {
                boolean find = false;
                int beforePos = stackPos - 1;
                int startT = pathStack[beforePos][1];
                int current = pathStack[beforePos][0];

                for (int t = startT; t < citySize; t++) {
                    int toCity = t + 1;
                    if (roadMatrix[current - 1][t] == 1 && !Arrays.asList(routeStack).contains(toCity)) {

                        int[] inCurStruct = {toCity, 0};
                        int[] beforeCurStruct = {current, t};

                        pathStack[beforePos] = beforeCurStruct;
                        pathStack[stackPos] = inCurStruct;
                        routeStack[stackPos] = toCity;
                        stackPos++;
                        find = true;
                        break;
                    }
                }

                if (!find) {
                    stackPos--;
                }
            }

            int changeCount = 0;
            int maxPearl = initPearl;

            for (int p = 0; p < stackPos; p++) {
                int current = routeStack[p];
                int cityPearl = Integer.parseInt(cityValue[current - 1]);

                if (cityPearl > maxPearl) {
                    changeCount++;
                    maxPearl = cityPearl;
                }
            }

            results[i] = changeCount;
        }

        return results;
    }
}
