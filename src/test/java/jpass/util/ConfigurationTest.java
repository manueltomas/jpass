package jpass.util;

import static org.junit.Assert.assertArrayEquals;
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
	@Test
	public void shouldTestDarkModeEnabled() {
	    assertEquals(true, cfg.is("ui.theme.dark.mode.enabled", false));
	}
	@Test
	public void shouldTestClearOnExitEnabled() {
	    assertEquals(true, cfg.is("clear.clipboard.on.exit.enabled", false));
	}
	@Test
    public void shouldTestDateFormat() {
        assertEquals("E dd-MM-yyyy", 
                cfg.get("date.format", "yyyy-MM-dd"));
    }
	@Test
    public void shouldTestDefPassLen() {
        assertEquals(new Integer(10), 
                cfg.getInteger("default.password.generation.length", 14));
    }
	private static final String[] DEFAULT_DETAILS = {
	        "Title",
	        "Created",
	        "Modified"
	    };
	@Test
    public void shouldTestEntryDetails() {
        assertArrayEquals(new String[] {"TITLE", "MODIFIED"}, 
                cfg.getArray("entry.details", DEFAULT_DETAILS));
    }
}
