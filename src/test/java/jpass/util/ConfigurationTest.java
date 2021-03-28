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
	    assertEquals(false, cfg.is("ui.theme.dark.mode.enabled", true));
	}
	@Test
	public void shouldTestClearOnExitEnabled() {
	    assertEquals(false, cfg.is("clear.clipboard.on.exit.enabled", true));
	}
	@Test
    public void shouldTestDateFormat() {
        assertEquals("yyyy-MM-dd", 
                cfg.get("date.format", "dd-MM-yyyy"));
    }
	@Test
    public void shouldTestDefPassLen() {
        assertEquals(new Integer(14), 
                cfg.getInteger("default.password.generation.length", 10));
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
