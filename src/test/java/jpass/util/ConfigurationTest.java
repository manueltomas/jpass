package jpass.util;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ConfigurationTest {

    private Configuration cfg;
    private static final String key = "not_a_key";
    
	@Before
	public void setUp() {
		cfg = Configuration.getInstance();
	}
	
	@Test
	public void shouldTestDefaultString() {
        //Test String
        String defaultString = "s";
        assertEquals(defaultString, cfg.get(key, defaultString));
	}
	@Test
    public void shouldTestDefaultArray() {
        //Test Array
        String[] defaultArray = {"s"};
        assertEquals(defaultArray[0], cfg.getArray(key, defaultArray)[0]);
        assertEquals(1, defaultArray.length);
    }
	@Test
    public void shouldTestDefaultInteger() {
        //Test Integer
        Integer defaultInteger = 0;
        assertEquals(defaultInteger, cfg.getInteger(key, defaultInteger));
    }
	@Test
    public void shouldTestDefaultBoolean() {
        //Test Boolean
        Boolean defaultBoolean = false;
        assertEquals(defaultBoolean, cfg.is(key, defaultBoolean));
    }
}
