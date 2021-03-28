package jpass.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import jpass.xml.bind.Entries;
import jpass.xml.bind.Entry;

public class DataModelTest {

    private DataModel dm;
	@Before
	public void setUp() {
		dm = DataModel.getInstance();
	}
	
	@Test
	public void shouldTestEntries() {
	    //Test entries
        dm.setEntries(new Entries());       
        assertEquals(new ArrayList<Entry>(), dm.getEntries().getEntry());
	}
	
	@Test
    public void shouldTestFilename() {
	    //Test filename
        String filename = "empty";
        dm.setFileName(filename);
        assertEquals(filename, dm.getFileName());
    }
	
	@Test
    public void shouldTestModifiedFlag() {
        //Test modified flag
        dm.setModified(true);
        assertTrue(dm.isModified());
    }
	
	@Test
    public void shouldTestPassword() {
        //Test password
        byte[] passArray = new byte[1];
        dm.setPassword(passArray);
        assertEquals(passArray[0], dm.getPassword()[0]);
    }
	
	@Test
    public void shouldTestClear() {
        //Test clear
        dm.clear();
        assertNull(dm.getFileName());
        assertFalse(dm.isModified());
        assertNull(dm.getPassword());
    }
	
	@Test
    public void shouldTestEntryByTitle() {
        //Test clear
        dm.clear();
        String title = "xpto";
        Entry entry = new Entry();
        entry.setTitle(title);
        Entries entries = new Entries();
        entries.getEntry().add(entry);
        dm.setEntries(entries);  
        assertEquals(dm.getEntryByTitle(title), entry);
    }
	@Test
    public void shouldNotTestEntryByTitle() {
        //Test clear
        dm.clear();
        String title = "xpto";
        Entry entry = new Entry();
        entry.setTitle(title);
        Entries entries = new Entries();
        entries.getEntry().add(entry);
        dm.setEntries(entries);  
        assertEquals(dm.getEntryByTitle("a"), null);
    }

	/*@Test
	public void shouldExerciseEncryptedEmptyEntriesRepositoryTest() throws IOException, DocumentProcessException {
		byte[] key = {(byte) 0x00, (byte) 0x01, (byte) 0x02, (byte) 0x03, (byte) 0x04, (byte) 0x05, (byte) 0x06,
	            (byte) 0x07, (byte) 0x08, (byte) 0x09, (byte) 0x0a, (byte) 0x0b, (byte) 0x0c, (byte) 0x0d, (byte) 0x0e,
	            (byte) 0x0f, (byte) 0x10, (byte) 0x11, (byte) 0x12, (byte) 0x13, (byte) 0x14, (byte) 0x15, (byte) 0x16,
	            (byte) 0x17, (byte) 0x18, (byte) 0x19, (byte) 0x1a, (byte) 0x1b, (byte) 0x1c, (byte) 0x1d, (byte) 0x1e,
	            (byte) 0x1f};
		
		EntriesRepository er = EntriesRepository.newInstance("test", key);		
		er.writeDocument(new Entries());
		Entries es = er.readDocument();
		
		
		
		assertEquals(new ArrayList<Entry>(), es.getEntry());
	}*/
}
