package com.liuwill.kata.isbn;

/**
 * Created by Liu Will on 2017/7/26.
 */
public class IsbnParser {
  public String generateCheckCode(String sample) {
    if (sample.length() != 13) {
      throw new IllegalArgumentException();
    }

    int bitCount = 0;
    for (int i = 0; i < sample.length() - 1; i++) {
      char val = sample.charAt(i);
      int number = charToNum(val);

      int bitNum = 0;
      if (i % 2 == 0) {
        bitNum = number * 1;
      } else {
        bitNum = number * 3;
      }

      bitCount += bitNum;
    }

    int rawBit = 10 - bitCount % 10;
    Integer realBit = rawBit;
    if(rawBit > 9){
      realBit = 0;
    }

    return realBit.toString();
  }

  public boolean isISBN(String sample) {
    String code = generateCheckCode(sample);

    return code.length() == 1 && sample.endsWith(code);
  }

  public static int charToNum(char num) {
    return num - 48;
  }
}
