package com.liuwill.kata.CombinedNumber;

import java.util.*;

/**
 * Created by videopls on 2017/3/1.
 */
public class CombinedNumberMain {
    public static int answer(List<String> dataList){
        return dataList.size();
    }

    public static String calc(List<String> dataList) {
        Collections.sort(dataList,new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
            String oneStr = o1.toString();
            String twoStr = o2.toString();

            int maxLength = oneStr.length()>twoStr.length()?oneStr.length():twoStr.length();
            int firstLength = oneStr.length();
            int secondLength = twoStr.length();

            int firstindex = 0;
            int secondIndex = 0;
            boolean firstMark = false;
            boolean secondMark = false;
            while(!firstMark || !secondMark){

                if(firstindex < firstLength && secondIndex < secondLength){
                    char oneStart = oneStr.charAt(firstindex);
                    char twoStart = twoStr.charAt(secondIndex);

                    if(oneStart != twoStart){
                        return oneStart < twoStart ? 1:-1;
                    }
                }else if(firstindex == firstLength && secondIndex == secondLength){
                    return 0;
                }else if(firstindex == firstLength){
                    firstMark = true;
                }else if(secondIndex == secondLength){
                    secondMark = true;
                }

                firstindex = (firstindex+1)%firstLength;
                secondIndex = (secondIndex+1)%secondLength;
            }

            return o2.compareTo(o1);
            }
        });

        //StringJoiner joiner = new StringJoiner("","","");
        String joinStr = String.join("",dataList);
        return joinStr;
    }
}
