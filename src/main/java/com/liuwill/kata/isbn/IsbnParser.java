package com.liuwill.kata.isbn;

/**
 * Created by Liu Will on 2017/7/26.
 */
public class IsbnParser {
  public String generateCheckCode(String sample) {
    sample = sample.replace(" ", "");
    sample = sample.replace("-", "");

    if(sample.length() == 10){
      return generateCheckCodeWith10Bit(sample);
    }
    return generateCheckCodeWith13Bit(sample);
  }

  public String generateCheckCodeWith13Bit(String sample){
    int bitCount = 0;
    for (int i = 0; i < sample.length() - 1; i++) {
      char val = sample.charAt(i);
      int number = charToNum(val);

      int bitNum;
      if (i % 2 == 0) {
        bitNum = number * 1;
      } else {
        bitNum = number * 3;
      }

      bitCount += bitNum;
    }

    int rawBit = 10 - bitCount % 10;
    Integer realBit = rawBit;
    if (rawBit > 9) {
      realBit = 0;
    }

    return realBit.toString();
  }

  public String generateCheckCodeWith10Bit(String sample){
    int bitCount = 0;

    for (int i = 0; i < sample.length() - 1; i++) {
      char val = sample.charAt(i);
      int number = charToNum(val);

      int bitNum = number * (10 - i);

      bitCount += bitNum;
    }

    Integer rawBit = 11 - bitCount % 11;
    String realBit = rawBit.toString();
    if (rawBit == 10) {
      realBit = "X";
    }else if (rawBit == 11) {
      realBit = "0";
    }

    return realBit;
  }

  public boolean isISBN(String sample) {
    if (!sample.matches("[X \\-0-9]+")) {
      return false;
    }

    sample = sample.replace(" ", "");
    sample = sample.replace("-", "");
    if (sample.length() != 13 && sample.length() != 10) {
      return false;
    }

    String code = generateCheckCode(sample);
    return code.length() == 1 && sample.endsWith(code);
  }

  public static int charToNum(char num) {
    return num - 48;
  }
}
