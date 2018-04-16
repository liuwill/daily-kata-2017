package com.liuwill.kata.combinednumber;

import java.util.List;

/**
 * Created by liuwill on 2017/3/7.
 */
public class CombinedNumber {
    private String[] sortHeapArr;

    public CombinedNumber(List<String> sourceList) {
        String[] storeArr = sourceList.toArray(new String[0]);

        sortHeapArr = generateSortedHeap(storeArr);
    }

    public CombinedNumber(String[] storeArr) {
        sortHeapArr = generateSortedHeap(storeArr);
    }

    public int size() {
        return sortHeapArr.length;
    }

    public String concat() {
        String[] itemArr = sortHeapArr;
        StringBuilder strBuilder = new StringBuilder(itemArr.length);
        while (itemArr.length > 0) {
            strBuilder.append(itemArr[0]);
            itemArr = popHeapTop(itemArr);
        }
        return strBuilder.toString();
    }

    public String popMax() {
        String item = sortHeapArr[0];

        sortHeapArr = popHeapTop(sortHeapArr);
        return item;
    }

    public static String[] generateSortedHeap(String[] storeArr) {
        String[] rawHeapArr = new String[0];

        for (String item : storeArr) {
            rawHeapArr = insertHeapItem(rawHeapArr, item);
        }
        return rawHeapArr;
    }

    public static String[] popHeapTop(String[] sortHeapArr) {
        if (sortHeapArr.length == 1) {
            return new String[0];
        }

        int last = sortHeapArr.length;
        String lastItem = sortHeapArr[last - 1];
        String[] newHeapArr = new String[sortHeapArr.length - 1];
        sortHeapArr[0] = lastItem;
        for (int i = 0; i < last - 1; ) {
            int left = i * 2 + 1;
            int right = i * 2 + 2;
            if (left > last - 2) {
                break;
            } else if (right > last - 2) {
                if (compareStringValue(sortHeapArr[left], sortHeapArr[i]) >= 0) {
                    break;
                } else {
                    sortHeapArr[i] = sortHeapArr[left];
                    sortHeapArr[left] = lastItem;
                    i = left;
                }
            } else {
                int compareResult = compareStringValueTripple(sortHeapArr[i], sortHeapArr[left], sortHeapArr[right]);
                if (compareResult == 1) {
                    break;
                } else if (compareResult == 2) {
                    sortHeapArr[i] = sortHeapArr[left];
                    sortHeapArr[left] = lastItem;
                    i = left;
                } else if (compareResult == 3) {
                    sortHeapArr[i] = sortHeapArr[right];
                    sortHeapArr[right] = lastItem;
                    i = right;
                }
            }
        }
        for (int i = 0; i < newHeapArr.length; i++) {
            newHeapArr[i] = sortHeapArr[i];
        }

        return newHeapArr;
    }

    public static String[] insertHeapItem(String[] sortHeapArr, String item) {
        String[] newHeapArr = new String[sortHeapArr.length + 1];
        if (newHeapArr.length == 1) {
            newHeapArr[0] = item;
            return newHeapArr;
        }
        System.arraycopy(sortHeapArr, 0, newHeapArr, 0, sortHeapArr.length);

        newHeapArr[sortHeapArr.length] = item;
        for (int i = sortHeapArr.length; i > 0; ) {
            int parentPos = (i - 1) / 2;

            if (parentPos < 0) {
                break;
            }
            if (compareStringValue(newHeapArr[parentPos], item) == 1) {
                newHeapArr[i] = newHeapArr[parentPos];
                i = parentPos;

                if (parentPos == 0) {
                    newHeapArr[parentPos] = item;
                }
            } else {
                newHeapArr[i] = item;
                break;
            }

        }

        return newHeapArr;
    }

    public static int compareStringValueTripple(String first, String second, String third) {
        if (compareStringValue(first, third) > 0 && compareStringValue(second, third) > 0) {
            return 3;
        } else if (compareStringValue(first, second) > 0 && compareStringValue(third, second) >= 0) {
            return 2;
        }
        return 1;
    }

    public static int compareStringValue(String first, String second) {
        // int maxLength = first.length()>second.length()?first.length():second.length();
        int firstLength = first.length();
        int secondLength = second.length();

        int firstindex = 0;
        int secondIndex = 0;
        boolean firstMark = false;
        boolean secondMark = false;

        if (first.equals(second)) {
            return 0;
        }

        int count = 0;
        while (!firstMark || !secondMark) {
            if (firstindex < firstLength && secondIndex < secondLength) {
                char oneStart = first.charAt(firstindex);
                char twoStart = second.charAt(secondIndex);

                if (oneStart != twoStart) {
                    return twoStart > oneStart ? 1 : -1;
                }
            } else if (firstindex == firstLength && secondIndex == secondLength) {
                return 0;
            }

            if (firstindex == firstLength) {
                firstMark = true;
            } else if (secondIndex == secondLength) {
                secondMark = true;
            }

            firstindex = (firstindex + 1) % firstLength;
            secondIndex = (secondIndex + 1) % secondLength;
            count++;

            if (count > firstLength + secondLength) {
                break;
            }
        }

        return second.compareTo(first);
    }
}
