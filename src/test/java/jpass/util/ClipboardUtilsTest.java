package jpass.util;

import static org.junit.Assert.assertEquals;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;

import org.junit.Test;

public class ClipboardUtilsTest {
	
//	  These functions were selected for being one of the few that had documentation. Most functions simply do not have the necessary documentation to perform Black-Box testing. SpringUtils utilises SpringLayout which is unfamiliar to us, and so was not chosen.
//	  set, get and clear ClipboardContent are all relatively simple functions, but they all perform different tasks, with either different inputs or outputs. For this reason, they were chosen.
//	  Aside from simpler ones, we chose two more complex functions to test in Crypt and String utils. 
	 
	
//	  setClipboardContent
//	  
//	  This function takes the System Clipboard and sets its content to be the given str String. A particular case is that empty Strings cannot be set as according to the Clipboard API.
//	  
//	  1) Parameters:
//	  String str
//	  System Clipboard is empty or not.
//	  System Clipboard is accessible or not.
//	  
//	  2) Characteristics:
//	  String str - String with N number of char Y (N: number from 0 to +infinity; Y: any char from ASCII table)
//	  
//	  3) Restrictions:
//	  Null str values have no specified behaviour, but should not run. It does not matter what the other inputs are.
//	  If system clipboard is not accessible, other inputs do not matter.
//	  
//	  Categories:
//	  str - null, empty or !empty.
//	  isEmptyClipboard or !isEmptyClipboard
//	  isAccessible or !isAccessible
//	  
//	  4) Combinations:
//	  (str       , isEmptyClipboard, isAccessible)
//	  
//	  (null      , -               , -           ) -> undefined
//	  (-         , -               ,!isAccessible) -> exception
//	  
//	  (empty     , isEmptyClipboard) -> clipboard.isEmpty() //When empty string is set Clipboard has no content.
//	  (empty     ,!isEmptyClipboard) -> clipboard.isEmpty() //When empty string is set Clipboard has no content.
//	  
//	  (!empty    , isEmptyClipboard) -> clipboard.equals(str)
//	  (!empty    ,!isEmptyClipboard) -> clipboard.equals(str)
//	  
//	  A total of 6 test cases.
	 
	/**
	 * When attempting to clear the content from the System Clipboard, an Exception
	 * should be thrown because the Clipboard is busy.
	 * Tests if the correct exception is thrown in the expected exceptional case.
	 * @throws Exception
	 */
	@Test(expected = IllegalAccessException.class)
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
	
	/**
	 * Attempts to set the System Clipboard text content to a given string setClipboard,
	 * given the System Clipboard content is empty.
	 * Tests if the System Clipboard text content matches the set string setClipboard.
	 * @throws Exception
	 */
	@Test
	public void shouldSetClipboardTest() throws Exception {
		String setClipboard = "text";		

		ClipboardUtils.setClipboardContent(setClipboard);
		
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		String clipboardText = (String) clipboard.getData(DataFlavor.stringFlavor);
		
		assertEquals(setClipboard, clipboardText);
	}
	
	/**
	 * Attempts to set the System Clipboard text content to an empty string,
	 * given the System Clipboard content is empty.
	 * Tests if the System Clipboard remains empty upon receiving an empty string.
	 * @throws Exception
	 */
	@Test
	public void shouldSetClipboardEmptyStringTest() throws Exception {
		String setClipboard = "";		

		ClipboardUtils.setClipboardContent(setClipboard);
		
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		
		assertEquals(0, clipboard.getAvailableDataFlavors().length);
	}
	
	/**
	 * Attempts to set the System Clipboard text content to a given string setClipboard,
	 * overwriting the previous content.
	 * Tests if the System Clipboard text content matches the set string setClipboard.
	 * @throws Exception
	 */
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
	
	/**
	 * Attempts to set the System Clipboard text content to an empty string,
	 * overwriting the previous content.
	 * Tests if the System Clipboard is now empty upon receiving an empty string.
	 * @throws Exception
	 */
	@Test
	public void shouldSetClipboardEmptyStringOverwriteTest() throws Exception {
		String toOverwrite = "different";
		String setClipboard = "";		

		ClipboardUtils.setClipboardContent(toOverwrite);
		ClipboardUtils.setClipboardContent(setClipboard);
		
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		
		assertEquals(0, clipboard.getAvailableDataFlavors().length);
	}
	
	
//	  clearClipboardContent
//	  
//	  This function takes the System Clipboard and clears its contents. The System Clipboard should have no content afterward.
//	  
//	  1) Parameters:
//	  System Clipboard is empty or not.
//	  System Clipboard is accessible or not.
//	  
//	  2) Characteristics:
//	  
//	  3) Restrictions:
//	  If system clipboard is not accessible, other inputs do not matter.
//	  
//	  In theory, if Clipboard is empty, this function is not necessary 
//	  and whether or not it does anything the output will be the same.
//	  
//	  Categories:
//	  isEmptyClipboard or !isEmptyClipboard
//	  isAccessible or !isAccessible
//	  
//	  4) Combinations:
//	  ( isEmptyClipboard, isAccessible)
//	  
//	  ( -               ,!isAccessible) -> exception
//	  
//	  ( isEmptyClipboard, isAccessible)	#Probably not necessary.
//	  (!isEmptyClipboard, isAccessible) -> clipboard.isEmpty()
//	  
//	  Three or two test cases.
	 
	
	/**
	 * When attempting to clear the content from the System Clipboard, an Exception
	 * should be thrown because the Clipboard is busy.
	 * Tests if the correct exception is thrown in the expected exceptional case.
	 * @throws Exception
	 */
	@Test(expected = IllegalAccessException.class)
	public void shouldNotClearClipboardExceptionTest() throws Exception {
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		//TODO: Find some way to force the clipboard to be busy.
		ClipboardUtils.clearClipboardContent();
	}
	
	/**
	 * Attempts to clear the System Clipboard of all content.
	 * Tests if the System Clipboard is truly empty.
	 * @throws Exception
	 */
	@Test
	public void shouldClearClipboardTest() throws Exception {
		//TODO: Set clipboard text without utilising other functions, so the test remains unitary.
		String toClear = "different";	
		ClipboardUtils.setClipboardContent(toClear);
		
		ClipboardUtils.clearClipboardContent();
		
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		
		assertEquals(0, clipboard.getAvailableDataFlavors().length);
	}
	
	
//	  getClipboardContent
//	  
//	  This function returns the text from the System Clipboard's content. If there is no text content, it returns null.
//	  
//	  1) Parameters:
//	  System Clipboard is empty or not.
//	  System Clipboard is accessible or not.
//	  
//	  
//	  2) Characteristics:
//	  
//	  3) Restrictions:
//	  If system clipboard is not accessible, other inputs do not matter.
//	  
//	  
//	  Categories:
//	  isEmptyClipboard or !isEmptyClipboard
//	  isAccessible or !isAccessible
//	  
//	  4) Combinations:
//	  
//	  ( -               ,!isAccessible) -> exception
//	  
//	  ( isEmptyClipboard, isAccessible) -> output == null
//	  (!isEmptyClipboard, isAccessible) -> clipboard.equals(output)
	 
	
	/**
	 * When attempting to get the text content from the System Clipboard, an Exception
	 * should be thrown because the Clipboard is busy.
	 * Tests if the correct exception is thrown in the expected exceptional case.
	 * @throws Exception
	 */
	@Test(expected = IllegalAccessException.class)
	public void shouldNotGetClipboardExceptionTest() throws Exception {
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		//TODO: Find some way to force the clipboard to be busy.
		ClipboardUtils.getClipboardContent();
	}
	
	/**
	 * Attempts to get the text contents of the System Clipboard when it has no content.
	 * getClipboardContent should return null in this case.
	 * Tests if null is truly the returned value.
	 * 
	 * Uses setClipboardContent() for the test.
	 * @throws Exception
	 */
	@Test
	public void shouldGetClipboardEmptyStringTest() throws Exception {
		//TODO: Set clipboard text without utilising other functions, so the test remains unitary.
		String toGet = "";	
		ClipboardUtils.setClipboardContent(toGet);
		
		assertEquals(null, ClipboardUtils.getClipboardContent());
	}
	
	/**
	 * Attempts to get the text contents of the System Clipboard. 
	 * Tests if the returned value is the expected clipboard content.
	 * 
	 * Uses setClipboardContent() for the test.
	 * @throws Exception
	 */
	@Test
	public void shouldGetClipboardTest() throws Exception {
		//TODO: Set clipboard text without utilising other functions, so the test remains unitary.
		String toGet = "text";	
		ClipboardUtils.setClipboardContent(toGet);
		
		assertEquals(toGet, ClipboardUtils.getClipboardContent());
	}
	
//	 All tests were successful except for the Exception tests. 
//	 The Exception tests all fail because we do not know how to enforce the necessary state on the clipboard so that the exception would be triggered.
//	 The clipboard should be "busy" when the functions are called, thus throwing the exception, but we can't set this state.

//	 Empty string tests originally tested if the Clipboard contained an empty string, but we later ascertained that setting an empty string to the Clipboard simply cleared its text content.
//	 For this reason we modified the tests to simply check if the Clipboard had been cleared.

}
