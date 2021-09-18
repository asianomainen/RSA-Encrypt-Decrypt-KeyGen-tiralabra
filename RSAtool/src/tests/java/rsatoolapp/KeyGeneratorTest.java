package rsatoolapp;

import org.junit.Before;
import org.junit.Test;
import rsatoolapp.domain.KeyGenerator;

import java.io.IOException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;

import static org.junit.Assert.*;

public class KeyGeneratorTest {
    KeyGenerator kg;

    @Before
    public void setUp() throws NoSuchAlgorithmException, IOException, InvalidKeySpecException {
        kg = new KeyGenerator();
    }

    @Test
    public void publicKeyIsGenerated() throws IOException, InvalidKeySpecException {
        kg.generateKeys();
        assertTrue(kg.getPublicKey().startsWith("-----BEGIN RSA PUBLIC KEY-----"));
    }

    @Test
    public void privateKeyIsGenerated() throws IOException, InvalidKeySpecException {
        kg.generateKeys();
        assertTrue(kg.getPrivateKey().startsWith("-----BEGIN RSA PRIVATE KEY-----"));
    }

    @Test
    public void publicKeysDoNotMatchIfGeneratedAgain() throws IOException, InvalidKeySpecException {
        kg.generateKeys();
        String publicKey1 = kg.getPublicKey();

        kg.generateKeys();
        String publicKey2 = kg.getPublicKey();

        assertNotEquals(publicKey1, publicKey2);
    }

    @Test
    public void privateKeysDoNotMatchIfGeneratedAgain() throws IOException, InvalidKeySpecException {
        kg.generateKeys();
        String privateKey1 = kg.getPrivateKey();

        kg.generateKeys();
        String privateKey2 = kg.getPrivateKey();

        assertNotEquals(privateKey1, privateKey2);
    }
}