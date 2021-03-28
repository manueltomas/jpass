package jpass.util;

import static org.junit.Assert.assertTrue;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import org.junit.Test;

public class CryptUtilsTest {

	@Test(expected = Exception.class)
	public void shouldNotGetSha256HashNullTest() throws Exception {
		char[] text = null;
		
		CryptUtils.getSha256Hash(text);
	}

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
	
	@Test
    public void shouldGetPKCS5Sha256HashNotEmptyTest() throws Exception {
        char[] text = "Hello World!".toCharArray();
        
        byte[] result = CryptUtils.getPKCS5Sha256Hash(text);
        byte[] expected = hash(new String(text), 1000);
        //byte[] expected = toByteArray("7f83b1657ff1fc53b92dc18148a1d65dfc2d4b1fa3d677284addd200126d9069");
        assertTrue(Arrays.equals(result, expected));
    }

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
	
	private byte[] hash(String text, int iteration) throws NoSuchAlgorithmException {
	    MessageDigest digest = MessageDigest.getInstance("SHA-256");
	    byte[] resultAux = digest.digest(
	            text.getBytes(StandardCharsets.UTF_8));
	    for(int i = 0; i < iteration; i++) {
	        resultAux = digest.digest(resultAux);
	    }
        return resultAux;

	}
}
