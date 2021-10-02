package rsatoolapp;

import org.junit.Before;
import org.junit.Test;
import rsatoolapp.domain.KeyGenerator;
import rsatoolapp.domain.RSAKey;

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
    public void publicKeyIsGenerated() {
        kg.generateKeys();
        assertNotNull(kg.getPublicKey());
    }

    @Test
    public void privateKeyIsGenerated() {
        kg.generateKeys();
        assertNotNull(kg.getPrivateKey());
    }

    @Test
    public void publicKeysDoNotMatchIfGeneratedAgain() throws IOException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        kg.generateKeys();
        RSAKey publicKey1 = kg.getPublicKey();

        kg.generateKeys();
        RSAKey publicKey2 = kg.getPublicKey();

        assertNotEquals(publicKey1, publicKey2);
    }

    @Test
    public void privateKeysDoNotMatchIfGeneratedAgain() throws IOException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        kg.generateKeys();
        RSAKey privateKey1 = kg.getPrivateKey();

        kg.generateKeys();
        RSAKey privateKey2 = kg.getPrivateKey();

        assertNotEquals(privateKey1, privateKey2);
    }
}