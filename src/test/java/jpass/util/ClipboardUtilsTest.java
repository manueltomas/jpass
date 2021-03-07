package jpass.util;

import static org.junit.Assert.assertEquals;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;

import org.junit.Test;

public class ClipboardUtilsTest {

	@Test(expected = Exception.class)
	public void shouldNotSetClipboardExceptionTest() throws Exception {
		String setClipboard = "test";		
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		//TODO: Find some way to force the clipboard to be busy.
		ClipboardUtils.setClipboardContent(setClipboard);
	}
	
	//Undefined behaviour, so test only helps in finding out what happens.
	//Note: Does not throw an exception during setClipboardContent.
//	@Test//(expected = Exception.class)
//	public void shouldNotSetClipboardNullTest() throws Exception {
//		String setClipboard = null;		
//
//		ClipboardUtils.setClipboardContent(setClipboard);
//		
//		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//		String clipboardText = (String) clipboard.getData(DataFlavor.stringFlavor);
//		
//		assertEquals(setClipboard, clipboardText);
//	}

	@Test
	public void shouldSetClipboardTest() throws Exception {
		String setClipboard = "text";		

		ClipboardUtils.setClipboardContent(setClipboard);
		
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		String clipboardText = (String) clipboard.getData(DataFlavor.stringFlavor);
		
		assertEquals(setClipboard, clipboardText);
	}

	@Test
	public void shouldSetClipboardEmptyStringTest() throws Exception {
		String setClipboard = "";		

		ClipboardUtils.setClipboardContent(setClipboard);
		
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		
		assertEquals(0, clipboard.getAvailableDataFlavors().length);
	}

	@Test
	public void shouldSetClipboardOverwriteTest() throws Exception {
		String toOverwrite = "different";
		String setClipboard = "text";		

		ClipboardUtils.setClipboardContent(toOverwrite);
		ClipboardUtils.setClipboardContent(setClipboard);
		
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		String clipboardText = (String) clipboard.getData(DataFlavor.stringFlavor);
		
		assertEquals(setClipboard, clipboardText);
	}

	@Test
	public void shouldSetClipboardEmptyStringOverwriteTest() throws Exception {
		String toOverwrite = "different";
		String setClipboard = "";		

		ClipboardUtils.setClipboardContent(toOverwrite);
		ClipboardUtils.setClipboardContent(setClipboard);
		
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		
		assertEquals(0, clipboard.getAvailableDataFlavors().length);
	}

	@Test(expected = Exception.class)
	public void shouldNotClearClipboardExceptionTest() throws Exception {
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		//TODO: Find some way to force the clipboard to be busy.
		ClipboardUtils.clearClipboardContent();
	}

	@Test
	public void shouldClearClipboardTest() throws Exception {
		//TODO: Set clipboard text without utilising other functions, so the test remains unitary.
		String toClear = "different";	
		ClipboardUtils.setClipboardContent(toClear);
		
		ClipboardUtils.clearClipboardContent();
		
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		
		assertEquals(0, clipboard.getAvailableDataFlavors().length);
	}

	@Test(expected = Exception.class)
	public void shouldNotGetClipboardExceptionTest() throws Exception {
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		//TODO: Find some way to force the clipboard to be busy.
		ClipboardUtils.getClipboardContent();
	}

	@Test
	public void shouldGetClipboardEmptyStringTest() throws Exception {
		//TODO: Set clipboard text without utilising other functions, so the test remains unitary.
		String toGet = "";	
		ClipboardUtils.setClipboardContent(toGet);
		
		assertEquals(null, ClipboardUtils.getClipboardContent());
	}
	
	@Test
	public void shouldGetClipboardTest() throws Exception {
		//TODO: Set clipboard text without utilising other functions, so the test remains unitary.
		String toGet = "text";	
		ClipboardUtils.setClipboardContent(toGet);
		
		assertEquals(toGet, ClipboardUtils.getClipboardContent());
	}
}
