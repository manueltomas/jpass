package jpass.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ConfigurationTest {

	@Test
	public void ConfigurationGetDefaultValuesTest() {
		Configuration cfg = Configuration.getInstance();
		String key = "not_a_key";
		
		//Test String
		String defaultString = "s";
		assertEquals(defaultString, cfg.get(key, defaultString));
		
		//Test Array
		String[] defaultArray = {"s"};
		assertEquals(defaultArray[0], cfg.getArray(key, defaultArray)[0]);
		assertEquals(1, defaultArray.length);
		
		//Test Integer
		Integer defaultInteger = 0;
		assertEquals(defaultInteger, cfg.getInteger(key, defaultInteger));
		
		//Test Boolean
		Boolean defaultBoolean = false;
		assertEquals(defaultBoolean, cfg.is(key, defaultBoolean));
	}
}
