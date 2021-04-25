package jpass.crypt;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CbcVVSTest {
    /**
     * Size of the first random message in <code>byte</code>s. Successive random messages will
     * double their size until {@link CbcTest#RANDOM_MESSAGE_LIMIT_SIZE} is reached.
     */
    private static final int FIRST_RANDOM_MESSAGE_SIZE = 1;

    /**
     * Size above which no random messages will be generated.
     */
    private static final int RANDOM_MESSAGE_LIMIT_SIZE = 2048;

    // contains the encrypted data
    private ByteArrayOutputStream _encrypted;

    /**
     * Used for encryption.
     */
    private Cbc _encrypt;

    // contains the decrypted data
    private ByteArrayOutputStream _decrypted;

    /**
     * Used for decryption.
     */
    private Cbc _decrypt;

    /**
     * Sets the encryption and decryption instances up.
     */
    @Before
    public void setUp() {
        byte[] iv = {(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00,
            (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00,
            (byte) 0x00};

        byte[] key = {(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00,
            (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00,
            (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00,
            (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00,
            (byte) 0x00};

        _encrypted = new ByteArrayOutputStream();
        _encrypt = new Cbc(iv, key, _encrypted);
        _decrypted = new ByteArrayOutputStream();
        _decrypt = new Cbc(iv, key, _decrypted);
    }

    @Test
    public void shouldNotDoubleDecryptSmallMessage() throws DecryptException, IOException {
        assertThrows(DecryptException.class, () -> {
            byte[] source = "abcdefg".getBytes();
            _encrypt.encrypt(source);
            _encrypt.finishEncryption();
    
            _decrypt.decrypt(_encrypted.toByteArray());
            _decrypt.decrypt(_encrypted.toByteArray());
            _decrypt.finishDecryption();
        });
    }
    
    @Test
    public void shouldNotDecryptUnencryptedMessage() throws DecryptException, IOException {
        assertThrows(DecryptException.class, () -> {
            char[] chars = {'a','b','c','d','e','f','g','h','i','j','k','l',
                    'm','n','o', 'p'};
            byte[] source = new String(chars).getBytes();
    
            _decrypt.decrypt(source);
            _decrypt.finishDecryption();
        });
    }
    
    @Test
    public void shouldNotDecryptUnencryptedMessageLimitChar() throws DecryptException, IOException {
        assertThrows(DecryptException.class, () -> {
            char[] chars = {'a','b','c','d','e','f','g','h','i','j','k','l',
                    'm','n','o', 'p'};
            byte[] source = new String(chars).getBytes();
    
            _decrypt.decrypt(source);
            _decrypt.finishDecryption();
        });
    }
    
    @Test
    public void shouldNotEncryptNull() throws DecryptException, IOException {
        _encrypt.encrypt(null);
        assertArrayEquals("".getBytes(), _encrypted.toByteArray());
    }
    @Test
    public void shouldNotEncryptSizeNull() throws DecryptException, IOException {
        _encrypt.encrypt(null,0);
        assertArrayEquals("".getBytes(), _encrypted.toByteArray());
    }
    @Test
    public void shouldNotDecryptNull() throws DecryptException, IOException {
        _decrypt.decrypt(null);
        assertArrayEquals("".getBytes(), _decrypted.toByteArray());
    }
    @Test
    public void shouldNotDecryptSizeNull() throws DecryptException, IOException {
        _decrypt.decrypt(null,0);
        assertArrayEquals("".getBytes(), _decrypted.toByteArray());
    }
    @Test
    public void shouldNotEncryptZeroSize() throws DecryptException, IOException {
        byte[] source = "abcdefghijklmnop".getBytes();
        _encrypt.encrypt(source,0);
        assertArrayEquals("".getBytes(), _encrypted.toByteArray());
    }
    @Test
    public void shouldNotDecryptZeroSize() throws DecryptException, IOException {
        byte[] source = "abcdefghijklmnop".getBytes();
        _decrypt.decrypt(source,0);
        assertArrayEquals("".getBytes(), _decrypted.toByteArray());
    }
    @Test
    public void shouldNotEncryptNegativeSize() throws DecryptException, IOException {
        byte[] source = "abcdefghijklmnop".getBytes();
        _encrypt.encrypt(source,-1);
        assertArrayEquals("".getBytes(), _encrypted.toByteArray());
    }
    @Test
    public void shouldNotDecryptNegativeSize() throws DecryptException, IOException {
        byte[] source = "abcdefghijklmnop".getBytes();
        _decrypt.decrypt(source,-1);
        assertArrayEquals("".getBytes(), _decrypted.toByteArray());
    }
    @Test
    public void shouldEncryptSizeOne() throws DecryptException, IOException {
        byte[] source = "abcdefghijklmnop".getBytes();
        _encrypt.encrypt(source,1);
        _encrypt.finishEncryption();
        
        _decrypt.decrypt(_encrypted.toByteArray());
        _decrypt.finishDecryption();
        assertArrayEquals("a".getBytes(), _decrypted.toByteArray());
    }
    
    @Test
    public void shouldEncryptBiggerThan16() throws DecryptException, IOException {
        byte[] source = "abcdefghijklmnopq".getBytes();
        _encrypt.encrypt(source);
        _encrypt.finishEncryption();
        
        _decrypt.decrypt(_encrypted.toByteArray());
        _decrypt.finishDecryption();
        assertArrayEquals(source, _decrypted.toByteArray());
    }

}
