package rsatoolapp;

import org.junit.Before;
import org.junit.Test;
import rsatoolapp.domain.KeyGenerator;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;

import static org.junit.Assert.*;

public class KeyGeneratorTest {
    KeyGenerator kg;

    @Before
    public void setUp() throws NoSuchAlgorithmException {
        kg = new KeyGenerator();
    }

    @Test
    public void publicKeyIsGenerated() throws IOException, InvalidKeySpecException, NoSuchPaddingException,
            IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        kg.generateKeys();
        assertTrue(kg.getPublicKey().length() > 0);
    }

    @Test
    public void privateKeyIsGenerated() throws IOException, InvalidKeySpecException, NoSuchPaddingException,
            IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        kg.generateKeys();
        assertTrue(kg.getPrivateKey().length() > 0);
    }

    @Test
    public void publicKeysDoNotMatchIfGeneratedAgain() throws IOException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        kg.generateKeys();
        String publicKey1 = kg.getPublicKey();

        kg.generateKeys();
        String publicKey2 = kg.getPublicKey();

        assertNotEquals(publicKey1, publicKey2);
    }

    @Test
    public void privateKeysDoNotMatchIfGeneratedAgain() throws IOException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        kg.generateKeys();
        String privateKey1 = kg.getPrivateKey();

        kg.generateKeys();
        String privateKey2 = kg.getPrivateKey();

        assertNotEquals(privateKey1, privateKey2);
    }
}