package jpass.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StringUtilsTest {

	
	@Test
	public void shouldStripNullTest() {
		String in = null;
		
		String result = StringUtils.stripNonValidXMLCharacters(in);
		String expected = "";
		
		assertEquals(expected, result);
		
	}

	@Test
	public void shouldStripEmptyTest() {
		String in = "";
		
		String result = StringUtils.stripNonValidXMLCharacters(in);
		String expected = "";
		
		assertEquals(expected, result);
		
	}

	@Test
	public void shouldStripNotEmptyHasNotInvalidTest() {
		char[] string = {'H','e','l','l','o','!'};
		String in = new String(string);
		
		String result = StringUtils.stripNonValidXMLCharacters(in);
		boolean expected = true;
		char current;
        for (int i = 0; i < result.length(); i++) {
            current = result.charAt(i);
            if ((current == 0x9) || (current == 0xA) || (current == 0xD)
                    || ((current >= 0x20) && (current <= 0xD7FF))
                    || ((current >= 0xE000) && (current <= 0xFFFD))
                    || ((current >= 0x10000) && (current <= 0x10FFFF))) {
                expected = true;
            } else {
                expected = false;
                break;
            }
        }
		
		assertTrue(expected);
		
	}

	@Test
	public void shouldStripNotEmptyHasInvalidTest() {
		char[] string = {'H','e','l','l',(char) 0xB,'o','!'};
		String in = new String(string);
		
		String result = StringUtils.stripNonValidXMLCharacters(in);
		boolean expected = true;
		char current;
        for (int i = 0; i < result.length(); i++) {
            current = result.charAt(i);
            if ((current == 0x9) || (current == 0xA) || (current == 0xD)
                    || ((current >= 0x20) && (current <= 0xD7FF))
                    || ((current >= 0xE000) && (current <= 0xFFFD))
                    || ((current >= 0x10000) && (current <= 0x10FFFF))) {
                expected = true;
            } else {
                expected = false;
                break;
            }
        }
		
		assertTrue(expected);
		
	}
}
