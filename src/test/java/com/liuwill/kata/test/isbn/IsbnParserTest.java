package com.liuwill.kata.test.isbn;

import com.liuwill.kata.isbn.IsbnParser;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Liu Will on 2017/7/26.
 */
public class IsbnParserTest {
  @Test
  public void testBasic() {
    String sample = "9780470059029";
    String expectCode = "9";
    IsbnParser parser = new IsbnParser();

    String code = parser.generateCheckCode(sample);

    assertEquals(code.length(), 1);
    assertEquals(expectCode, code);
    assertTrue(sample.endsWith(code));

    assertTrue(parser.isISBN(sample));
  }

  @Test
  public void testError() {
    String sample = "9780470059023";
    String expectCode = "9";
    IsbnParser parser = new IsbnParser();

    String code = parser.generateCheckCode(sample);

    assertEquals(expectCode, code);
    assertFalse(sample.endsWith(code));

    assertFalse(parser.isISBN(sample));
  }

  @Test
  public void testWithBlank() {
    String sample = "978 0 471 48648 0";
    String expectCode = "0";
    IsbnParser parser = new IsbnParser();

    String code = parser.generateCheckCode(sample);

    assertEquals(code.length(), 1);
    assertEquals(expectCode, code);
    assertTrue(sample.endsWith(code));

    assertTrue(parser.isISBN(sample));
  }

  @Test
  public void testWithSplit() {
    String sample = "978-0-262-13472-9";
    String expectCode = "9";
    IsbnParser parser = new IsbnParser();

    String code = parser.generateCheckCode(sample);

    assertEquals(code.length(), 1);
    assertEquals(expectCode, code);
    assertTrue(sample.endsWith(code));

    assertTrue(parser.isISBN(sample));
  }

  @Test
  public void testShortISBN() {
    String sample = "0-470-84525-2";
    String expectCode = "2";
    IsbnParser parser = new IsbnParser();

    String code = parser.generateCheckCode(sample);

    assertEquals(code.length(), 1);
    assertEquals(expectCode, code);
    assertTrue(sample.endsWith(code));

    assertTrue(parser.isISBN(sample));
  }

  @Test
  public void testShortISBNWithX() {
    String sample = "7-144-00316-X";
    String expectCode = "X";
    IsbnParser parser = new IsbnParser();

    String code = parser.generateCheckCode(sample);

    assertEquals(code.length(), 1);
    assertEquals(expectCode, code);
    assertTrue(sample.endsWith(code));

    assertTrue(parser.isISBN(sample));
  }

  @Test
  public void testShortISBNEndWith0() {
    String sample = "0-321-14653-0";
    String expectCode = "0";
    IsbnParser parser = new IsbnParser();

    String code = parser.generateCheckCode(sample);

    assertEquals(code.length(), 1);
    assertEquals(expectCode, code);
    assertTrue(sample.endsWith(code));

    assertTrue(parser.isISBN(sample));
  }

  @Test
  public void testIllegelISBN() {
    String sample = "7-144-00316-=X";
    String sampleLong = "714400324352345234516";
    String sampleShort = "123421354";

    IsbnParser parser = new IsbnParser();
    assertFalse(parser.isISBN(sample));
    assertFalse(parser.isISBN(sampleShort));
    assertFalse(parser.isISBN(sampleLong));
  }
}
