package jpass.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StringUtilsTest {

	/*
	 * stripNonValidXMLCharacters
	 * 
	 * This method ensures that the output String has only valid XML unicode characters
	 * 
	 * 1. Parameters:
	 * in
	 * 
	 * 2. Characteristics:
	 * in -> null, empty, N number of Y chars (N: number from 1 to +infinity; Y: any char from ASCII table)
	 * 
	 * 3. Restrictions:
	 * There are no special restrictions defined by the method
	 * Categories:
	 * in - null, empty, (!empty && !containsInvalid) or (!empty && containsInvalid).
	 * 
	 * 4. Combinations:
	 * in - null -> empty
	 * in - empty -> empty
	 * in - !empty && !containsInvalid -> string without invalid xml characters
	 * in - !empty && containsInvalid -> string without invalid xml characters
	 */
	
	/**
	 * Attempts to strip a null object which, according to the method documentation, should return an empty string 
	 */
	@Test
	public void shouldStripNullTest() {
		String in = null;
		
		String result = StringUtils.stripNonValidXMLCharacters(in);
		String expected = "";
		
		assertEquals(expected, result);
		
	}
	
	/**
	 * Attempts to strip a empty string which, according to the method documentation, should return an empty string 
	 */
	@Test
	public void shouldStripEmptyTest() {
		String in = "";
		
		String result = StringUtils.stripNonValidXMLCharacters(in);
		String expected = "";
		
		assertEquals(expected, result);
		
	}
	
	/**
	 * Attempts to strip a string without invalid xml characters which, 
	 * according to the method documentation, should return an string without invalid xml characters 
	 */
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
	
	/**
	 * Attempts to strip a string with invalid xml characters which, 
	 * according to the method documentation, should return an string without invalid xml characters 
	 */
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
