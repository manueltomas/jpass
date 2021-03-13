package jpass.crypt;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test values for the &quot;Advanced Encryption Standard&quot; (AES). These values are part of
 * &quot;Federal Information Processing Standards Publication 197&quot;.
 *
 * @author Timm Knape
 * @version $Revision: 1.3 $
 */
// Copyright 2007 by Timm Knape <timm@knp.de>
// All rights reserved.
public class Aes256VVSTest {
	
    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldEncryptLength16MinusOneInBlockTest() {
        byte[] key = {(byte) 0x00, (byte) 0x01, (byte) 0x02, (byte) 0x03, (byte) 0x04, (byte) 0x05, (byte) 0x06,
            (byte) 0x07, (byte) 0x08, (byte) 0x09, (byte) 0x0a, (byte) 0x0b, (byte) 0x0c, (byte) 0x0d, (byte) 0x0e,
            (byte) 0x0f, (byte) 0x10, (byte) 0x11, (byte) 0x12, (byte) 0x13, (byte) 0x14, (byte) 0x15, (byte) 0x16,
            (byte) 0x17, (byte) 0x18, (byte) 0x19, (byte) 0x1a, (byte) 0x1b, (byte) 0x1c, (byte) 0x1d, (byte) 0x1e,
            (byte) 0x1f};

        Aes256 cipher = new Aes256(key);

        byte[] block = {(byte) 0x00, (byte) 0x11, (byte) 0x22, (byte) 0x33, (byte) 0x44, (byte) 0x55, (byte) 0x66,
                (byte) 0x77, (byte) 0x88, (byte) 0x99, (byte) 0xaa, (byte) 0xbb, (byte) 0xcc, (byte) 0xdd, (byte) 0xee};
        byte[] encrypted = new byte[16];
        cipher.encrypt(block, 0, encrypted, 0);
    }
	
    @Test//(expected = IndexOutOfBoundsException.class)
    public void shouldEncryptLength16PlusOneInBlockTest() {
        byte[] key = {(byte) 0x00, (byte) 0x01, (byte) 0x02, (byte) 0x03, (byte) 0x04, (byte) 0x05, (byte) 0x06,
            (byte) 0x07, (byte) 0x08, (byte) 0x09, (byte) 0x0a, (byte) 0x0b, (byte) 0x0c, (byte) 0x0d, (byte) 0x0e,
            (byte) 0x0f, (byte) 0x10, (byte) 0x11, (byte) 0x12, (byte) 0x13, (byte) 0x14, (byte) 0x15, (byte) 0x16,
            (byte) 0x17, (byte) 0x18, (byte) 0x19, (byte) 0x1a, (byte) 0x1b, (byte) 0x1c, (byte) 0x1d, (byte) 0x1e,
            (byte) 0x1f};

        Aes256 cipher = new Aes256(key);

        byte[] block = {(byte) 0x00, (byte) 0x11, (byte) 0x22, (byte) 0x33, (byte) 0x44, (byte) 0x55, (byte) 0x66,
                (byte) 0x77, (byte) 0x88, (byte) 0x99, (byte) 0xaa, (byte) 0xbb, (byte) 0xcc, (byte) 0xdd, (byte) 0xee,
                (byte) 0xff, (byte) 0x00};
        byte[] encrypted = new byte[16];
        cipher.encrypt(block, 0, encrypted, 0);
        byte[] expectedEncrypted = {(byte) 0x8e, (byte) 0xa2, (byte) 0xb7, (byte) 0xca, (byte) 0x51, (byte) 0x67,
                (byte) 0x45, (byte) 0xbf, (byte) 0xea, (byte) 0xfc, (byte) 0x49, (byte) 0x90, (byte) 0x4b, (byte) 0x49,
                (byte) 0x60, (byte) 0x89};

        Assert.assertTrue(Arrays.equals(expectedEncrypted, encrypted));
    }
	
    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldEncryptLengthZeroOutBlockTest() {
        byte[] key = {(byte) 0x00, (byte) 0x01, (byte) 0x02, (byte) 0x03, (byte) 0x04, (byte) 0x05, (byte) 0x06,
            (byte) 0x07, (byte) 0x08, (byte) 0x09, (byte) 0x0a, (byte) 0x0b, (byte) 0x0c, (byte) 0x0d, (byte) 0x0e,
            (byte) 0x0f, (byte) 0x10, (byte) 0x11, (byte) 0x12, (byte) 0x13, (byte) 0x14, (byte) 0x15, (byte) 0x16,
            (byte) 0x17, (byte) 0x18, (byte) 0x19, (byte) 0x1a, (byte) 0x1b, (byte) 0x1c, (byte) 0x1d, (byte) 0x1e,
            (byte) 0x1f};

        Aes256 cipher = new Aes256(key);

        byte[] block = {(byte) 0x00};
        byte[] encrypted = new byte[0];
        cipher.encrypt(block, 0, encrypted, 0);
    }
	
    @Test
    public void shouldEncryptLengthOneInBlockTest() {
        byte[] key = {(byte) 0x00, (byte) 0x01, (byte) 0x02, (byte) 0x03, (byte) 0x04, (byte) 0x05, (byte) 0x06,
            (byte) 0x07, (byte) 0x08, (byte) 0x09, (byte) 0x0a, (byte) 0x0b, (byte) 0x0c, (byte) 0x0d, (byte) 0x0e,
            (byte) 0x0f, (byte) 0x10, (byte) 0x11, (byte) 0x12, (byte) 0x13, (byte) 0x14, (byte) 0x15, (byte) 0x16,
            (byte) 0x17, (byte) 0x18, (byte) 0x19, (byte) 0x1a, (byte) 0x1b, (byte) 0x1c, (byte) 0x1d, (byte) 0x1e,
            (byte) 0x1f};

        Aes256 cipher = new Aes256(key);

        byte[] block = {(byte) 0x00};
        byte[] encrypted = new byte[16];
        cipher.encrypt(block, 0, encrypted, 0);
        
        byte[] expectedEncrypted = new byte[16];
        expectedEncrypted[0] = (byte) 0x8e;

        //Assert.assertTrue(Arrays.equals(expectedEncrypted, encrypted));
        assertEquals(expectedEncrypted, encrypted);
    }
	
    @Test
    public void shouldEncryptLengthOneOutBlockTest() {
        byte[] key = {(byte) 0x00, (byte) 0x01, (byte) 0x02, (byte) 0x03, (byte) 0x04, (byte) 0x05, (byte) 0x06,
            (byte) 0x07, (byte) 0x08, (byte) 0x09, (byte) 0x0a, (byte) 0x0b, (byte) 0x0c, (byte) 0x0d, (byte) 0x0e,
            (byte) 0x0f, (byte) 0x10, (byte) 0x11, (byte) 0x12, (byte) 0x13, (byte) 0x14, (byte) 0x15, (byte) 0x16,
            (byte) 0x17, (byte) 0x18, (byte) 0x19, (byte) 0x1a, (byte) 0x1b, (byte) 0x1c, (byte) 0x1d, (byte) 0x1e,
            (byte) 0x1f};

        Aes256 cipher = new Aes256(key);

        byte[] block = {(byte) 0x00, (byte) 0x11, (byte) 0x22, (byte) 0x33, (byte) 0x44, (byte) 0x55, (byte) 0x66,
                (byte) 0x77, (byte) 0x88, (byte) 0x99, (byte) 0xaa, (byte) 0xbb, (byte) 0xcc, (byte) 0xdd, (byte) 0xee,
                (byte) 0xff};
        byte[] encrypted = new byte[1];
        cipher.encrypt(block, 0, encrypted, 0);
        
        byte[] expectedEncrypted = new byte[1];
        expectedEncrypted[0] = (byte) 0x8e;

        //Assert.assertTrue(Arrays.equals(expectedEncrypted, encrypted));
        assertEquals(expectedEncrypted, encrypted);
    }
    
    @Test
    public void shouldEncryptLengthZerdfdsfsdTest() {
        byte[] key = {(byte) 0x00, (byte) 0x01, (byte) 0x02, (byte) 0x03, (byte) 0x04, (byte) 0x05, (byte) 0x06,
            (byte) 0x07, (byte) 0x08, (byte) 0x09, (byte) 0x0a, (byte) 0x0b, (byte) 0x0c, (byte) 0x0d, (byte) 0x0e,
            (byte) 0x0f, (byte) 0x10, (byte) 0x11, (byte) 0x12, (byte) 0x13, (byte) 0x14, (byte) 0x15, (byte) 0x16,
            (byte) 0x17, (byte) 0x18, (byte) 0x19, (byte) 0x1a, (byte) 0x1b, (byte) 0x1c, (byte) 0x1d, (byte) 0x1e,
            (byte) 0x1f};

        Aes256 cipher = new Aes256(key);

        byte[] block = {(byte) 0x00, (byte) 0x11, (byte) 0x22, (byte) 0x33, (byte) 0x44, (byte) 0x55, (byte) 0x66,
            (byte) 0x77, (byte) 0x88, (byte) 0x99, (byte) 0xaa, (byte) 0xbb, (byte) 0xcc, (byte) 0xdd, (byte) 0xee,
            (byte) 0xff};

        byte[] encrypted = new byte[16];
        cipher.encrypt(block, 0, encrypted, 0);
        byte[] expectedEncrypted = {(byte) 0x8e, (byte) 0xa2, (byte) 0xb7, (byte) 0xca, (byte) 0x51, (byte) 0x67,
            (byte) 0x45, (byte) 0xbf, (byte) 0xea, (byte) 0xfc, (byte) 0x49, (byte) 0x90, (byte) 0x4b, (byte) 0x49,
            (byte) 0x60, (byte) 0x89};

        Assert.assertTrue(Arrays.equals(expectedEncrypted, encrypted));
        assertEquals(expectedEncrypted, encrypted);
    }
}
