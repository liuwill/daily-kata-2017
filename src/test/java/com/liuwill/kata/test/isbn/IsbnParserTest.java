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
}
