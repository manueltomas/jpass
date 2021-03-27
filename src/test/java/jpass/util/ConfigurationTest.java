package jpass.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ConfigurationTest {

	@Test
	public void shouldStripLengthZeroTest() {
		String in = "";
		
		String result = StringUtils.stripNonValidXMLCharacters(in);
		String expected = "";
		
		assertEquals(expected, result);
		
	}
}
