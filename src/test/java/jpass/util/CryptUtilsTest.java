package jpass.util;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class CryptUtilsTest {

	/*
	 * getSha356Hash
	 * 
	 * This method calculates the SHA-256 hash of a given char[]
	 * 
	 * 1. Parameters:
	 * text
	 * 
	 * 2. Characteristics:
	 * text -> null, empty, N number of Y chars (N: number from 1 to +infinity; Y: any char from ASCII table)
	 * 
	 * 3. Restrictions:
	 * There are no special restrictions defined by the method
	 * Categories:
	 * text - null, empty, !empty
	 *  
	 * 4. Combinations:
	 * text == null -> exception
	 * text == empty
	 * text == N number of Y chars (N: number from 1 to +infinity; Y: any char from ASCII table)
	 * 
	 * The output of the combinations were calculated through https://xorbin.com/tools/sha256-hash-calculator
	 */	
	
	/**
	 * Attempts to get the SHA-356 Hash of a null object which should be an exception as it is
	 * an invalid operation
	 * 
	 * @throws Exception
	 */
	@Test(expected = Exception.class)
	public void shouldNotGetSha256HashNullTest() throws Exception {
		char[] text = null;
		
		CryptUtils.getSha256Hash(text);
	}
	
	/**
	 * Attempts to get the SHA-356 of an empty string which should return the expected value<br>
	 * The value expected was calculated using the tool available in this 
	 * <a href="https://xorbin.com/tools/sha256-hash-calculator">website</a>
	 * 
	 * @throws Exception
	 */
	@Test
	public void shouldGetSha256HashEmptyTest() throws Exception {
		char[] text = {};
		
		byte[] result = CryptUtils.getSha256Hash(text);
		byte[] expected = {(byte) 0xe3, (byte) 0xb0, (byte) 0xc4, (byte) 0x42, (byte) 0x98, (byte) 0xfc, 
				(byte) 0x1c, (byte) 0x14, (byte) 0x9a, (byte) 0xfb, (byte) 0xf4, (byte) 0xc8, (byte) 0x99,
				(byte) 0x6f, (byte) 0xb9, (byte) 0x24, (byte) 0x27, (byte) 0xae, (byte) 0x41, (byte) 0xe4,
				(byte) 0x64, (byte) 0x9b, (byte) 0x93, (byte) 0x4c, (byte) 0xa4, (byte) 0x95, (byte) 0x99,
				(byte) 0x1b, (byte) 0x78, (byte) 0x52, (byte) 0xb8, (byte) 0x55};
		//byte[] expected = toByteArray("e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855");
		assertTrue(Arrays.equals(result, expected));
	}
	
	/**
	 * Attempts to get the SHA-356 of a string which should return the expected value<br>
	 * The value expected was calculated using the tool available in this 
	 * <a href="https://xorbin.com/tools/sha256-hash-calculator">website</a>
	 * 
	 * @throws Exception
	 */
	@Test
	public void shouldGetSha256HashNotEmptyTest() throws Exception {
		char[] text = "Hello World!".toCharArray();
		
		byte[] result = CryptUtils.getSha256Hash(text);
		byte[] expected = {(byte) 0x7f, (byte) 0x83, (byte) 0xb1, (byte) 0x65, (byte) 0x7f, (byte) 0xf1, 
				(byte) 0xfc, (byte) 0x53, (byte) 0xb9, (byte) 0x2d, (byte) 0xc1, (byte) 0x81, (byte) 0x48, 
				(byte) 0xa1, (byte) 0xd6, (byte) 0x5d, (byte) 0xfc, (byte) 0x2d, (byte) 0x4b, (byte) 0x1f, 
				(byte) 0xa3, (byte) 0xd6, (byte) 0x77, (byte) 0x28, (byte) 0x4a, (byte) 0xdd, (byte) 0xd2, 
				(byte) 0x00, (byte) 0x12, (byte) 0x6d, (byte) 0x90, (byte) 0x69};
		//byte[] expected = toByteArray("7f83b1657ff1fc53b92dc18148a1d65dfc2d4b1fa3d677284addd200126d9069");
		assertTrue(Arrays.equals(result, expected));
	}
	
	/**
	 * This private method converts s into a byte array with the hexadecimal values paired up<br>
	 * E.g.<p> if s = "e3b0c442"</p>
	 * <p>then the function returns {(byte) 0xe3, (byte) 0xb0, (byte) 0xc4, (byte) 0x42}</p>
	 * The main purpose of this method is to convert the format given by the website we used to calculate
	 * the hash value of a String to the format accepted by Java.<br>
	 * The website used can be found <a href="https://xorbin.com/tools/sha256-hash-calculator">here</a>
	 * 
	 * @param s String to be converted
	 * @return The String converted into byte array as described
	 */
	private static byte[] toByteArray(String s) {
		
		byte[] result = new byte[s.length()/2];
		for(int i = 0; i < s.length(); i = i + 2) {
			StringBuilder aux = new StringBuilder();
			aux.append(s.charAt(i));
			aux.append(s.charAt(i+1));
			byte b = (byte) (Integer.parseInt(aux.toString(),16) & 0xff);
			result[i/2] = b;
		}
		return result;
	}
}
