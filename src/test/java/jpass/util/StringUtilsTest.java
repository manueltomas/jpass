package jpass.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StringUtilsTest {

///////////////////////////////////BOUNDARY VALUE ANALYSIS///////////////////////////////////
	@Test
	public void shouldStripLengthZeroTest() {
		String in = "";
		
		String result = StringUtils.stripNonValidXMLCharacters(in);
		String expected = "";
		
		assertEquals(expected, result);
		
	}
	
	@Test
	public void shouldStripLengthOneTest() {
		String in = "a";
		
		String result = StringUtils.stripNonValidXMLCharacters(in);
		String expected = "a";
		
		assertEquals(expected, result);
		
	}
	
	@Test
	public void shouldStripChar0x9Test() {
		char[] string = {'a',(char) 0x9,'a'};
		String in = new String(string);
		
		String result = StringUtils.stripNonValidXMLCharacters(in);
		
		String expected = new String(string);
		
		assertEquals(expected, result);		
	}
	
	@Test
	public void shouldStripChar0x9MinusOneTest() {
		char[] string = {'a',(char) (0x9-1),'a'};
		String in = new String(string);
		
		String result = StringUtils.stripNonValidXMLCharacters(in);
		
		String expected = "a?a";
		
		assertEquals(expected, result);
	}
	
	@Test
	public void shouldStripChar0xATest() {
		char[] string = {'a',(char) 0xA,'a'};
		String in = new String(string);
		
		String result = StringUtils.stripNonValidXMLCharacters(in);
		
		String expected = new String(string);
		
		assertEquals(expected, result);		
	}
	
	@Test
	public void shouldStripChar0xAPlusOneTest() {
		char[] string = {'a',(char) (0xA+1),'a'};
		String in = new String(string);
		
		String result = StringUtils.stripNonValidXMLCharacters(in);
		
		String expected = "a?a";
		
		assertEquals(expected, result);		
	}
	
	@Test
	public void shouldStripChar0xDTest() {
		char[] string = {'a',(char) 0xD,'a'};
		String in = new String(string);
		
		String result = StringUtils.stripNonValidXMLCharacters(in);
		
		String expected = new String(string);
		
		assertEquals(expected, result);		
	}
	
	@Test
	public void shouldStripChar0xDPlusOneTest() {
		char[] string = {'a',(char) (0xD+1),'a'};
		String in = new String(string);
		
		String result = StringUtils.stripNonValidXMLCharacters(in);
		
		String expected = "a?a";
		
		assertEquals(expected, result);		
	}
	
	@Test
	public void shouldStripChar0xDMinusOneTest() {
		char[] string = {'a',(char) (0xD-1),'a'};
		String in = new String(string);
		
		String result = StringUtils.stripNonValidXMLCharacters(in);
		
		String expected = "a?a";
		
		assertEquals(expected, result);
	}
	
    //////////////////////////////////[0x20, 0xD7FF] ////////////////////////////////// 
	
	@Test
	public void shouldStripChar0x20Test() {
		char[] string = {'a',(char) 0x20,'a'};
		String in = new String(string);
		
		String result = StringUtils.stripNonValidXMLCharacters(in);
		
		String expected = new String(string);
		
		assertEquals(expected, result);		
	}
	
	@Test
	public void shouldStripChar0x20MinusOneTest() {
		char[] string = {'a',(char) (0x20-1),'a'};
		String in = new String(string);
		
		String result = StringUtils.stripNonValidXMLCharacters(in);
		
		String expected = "a?a";
		
		assertEquals(expected, result);
	}
	
	@Test
	public void shouldStripChar0xD7FFTest() {
		char[] string = {'a',(char) 0xD7FF,'a'};
		String in = new String(string);
		
		String result = StringUtils.stripNonValidXMLCharacters(in);
		
		String expected = new String(string);
		
		assertEquals(expected, result);		
	}
	
	@Test
	public void shouldStripChar0xD7FFPlusOneTest() {
		char[] string = {'a',(char) (0xD7FF+1),'a'};
		String in = new String(string);
		
		String result = StringUtils.stripNonValidXMLCharacters(in);
		
		String expected = "a?a";
		
		assertEquals(expected, result);
	}
	
    //////////////////////////////////[0xE000, 0xFFFD] ////////////////////////////////// 
	
	@Test
	public void shouldStripChar0xE000Test() {
		char[] string = {'a',(char) 0xE000,'a'};
		String in = new String(string);
		
		String result = StringUtils.stripNonValidXMLCharacters(in);
		
		String expected = new String(string);
		
		assertEquals(expected, result);		
	}
	
	@Test
	public void shouldStripChar0xE000MinusOneTest() {
		char[] string = {'a',(char) (0xE000-1),'a'};
		String in = new String(string);
		
		String result = StringUtils.stripNonValidXMLCharacters(in);
		
		String expected = "a?a";
		
		assertEquals(expected, result);
	}
	
	@Test
	public void shouldStripChar0xFFFDTest() {
		char[] string = {'a',(char) 0xFFFD,'a'};
		String in = new String(string);
		
		String result = StringUtils.stripNonValidXMLCharacters(in);
		
		String expected = new String(string);
		
		assertEquals(expected, result);		
	}
	
	@Test
	public void shouldStripChar0xFFFDPlusOneTest() {
		char[] string = {'a',(char) (0xFFFD+1),'a'};
		String in = new String(string);
		
		String result = StringUtils.stripNonValidXMLCharacters(in);
		
		String expected = "a?a";
		
		assertEquals(expected, result);
	}
	
	////////////////////////////////// [0x10000, 0x10FFFF] ////////////////////////////////// 
	
//	@Test
//	public void shouldStripChar0x10000Test() {
//		char[] string = {'a',(char) 0x10000,'a'};
//		String in = new String(string);
//		
//		String result = StringUtils.stripNonValidXMLCharacters(in);
//		
//		String expected = new String(string);
//		
//		assertEquals(expected, result);		
//	}
	
	@Test
	public void shouldStripChar0x10000MinusOneTest() {
		char[] string = {'a',(char) (0x10000-1),'a'};
		String in = new String(string);
		
		String result = StringUtils.stripNonValidXMLCharacters(in);
		
		String expected = "a?a";
		
		assertEquals(expected, result);
	}
	
//	@Test
//	public void shouldStripChar0x10FFFFTest() {
//		char[] string = {'a',(char) 0x10FFFF,'a'};
//		String in = new String(string);
//		
//		String result = StringUtils.stripNonValidXMLCharacters(in);
//		
//		String expected = new String(string);
//		
//		assertEquals(expected, result);		
//	}
	
	@Test
	public void shouldStripChar0x10FFFFPlusOneTest() {
		char[] string = {'a',(char) (0x10FFFF+1),'a'};
		String in = new String(string);
		
		String result = StringUtils.stripNonValidXMLCharacters(in);
		
		String expected = "a?a";
		
		assertEquals(expected, result);
	}
	
///////////////////////////////////CATEGORY-PARTITION///////////////////////////////////
	/*@Test
	public void shouldStripNullTest() {
		String in = null;
		
		String result = StringUtils.stripNonValidXMLCharacters(in);
		String expected = "";
		
		assertEquals(expected, result);
		
	}*/

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
