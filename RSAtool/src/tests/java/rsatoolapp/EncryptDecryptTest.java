package rsatoolapp;

import org.junit.Before;
import org.junit.Test;
import rsatoolapp.domain.EncryptDecrypt;
import rsatoolapp.domain.KeyGenerator;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;

import static org.junit.Assert.*;

public class EncryptDecryptTest {
    KeyGenerator kg;
    EncryptDecrypt ed;

    @Before
    public void setUp() throws NoSuchAlgorithmException {
        kg = new KeyGenerator();
        ed = new EncryptDecrypt();
    }

    @Test
    public void messageIsEncrypted() throws IOException, InvalidKeySpecException, NoSuchPaddingException,
            IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        kg.generateKeys();
        String msg = "Secret";
        ed.encrypt(msg, kg.getPublicKey());
        String encryptedMessage = ed.getEncryptedMessage();
        assertNotEquals(msg, encryptedMessage);
    }

    @Test
    public void messageIsDecrypted() throws IOException, InvalidKeySpecException, NoSuchPaddingException,
            IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        kg.generateKeys();
        String msg = "Secret";
        ed.encrypt(msg, kg.getPublicKey());
        ed.decrypt(ed.getEncryptedMessage(), kg.getPrivateKey());
        String decryptedMessage = ed.getDecryptedMessage();
        assertEquals(msg, decryptedMessage);
    }

    @Test
    public void encryptedMessagesDoNotEqualIfEncryptedAgain() throws IOException, InvalidKeySpecException, NoSuchPaddingException,
            IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        kg.generateKeys();
        String msg = "Secret";
        ed.encrypt(msg, kg.getPublicKey());

        String encryptedMessage1 = ed.getEncryptedMessage();
        String encryptedMessage2 = ed.getEncryptedMessage();

        assertEquals(encryptedMessage1, encryptedMessage2);
    }
}