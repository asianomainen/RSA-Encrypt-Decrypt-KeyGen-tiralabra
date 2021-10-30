package rsatoolapp;

import org.junit.Before;
import org.junit.Test;
import rsatoolapp.domain.KeyGenerator;
import rsatoolapp.domain.RSAKey;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class KeyGeneratorTest {
    KeyGenerator kg;

    @Before
    public void setUp() {
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
    public void publicKeysDoNotMatchIfGeneratedAgain() {
        kg.generateKeys();
        RSAKey publicKey1 = kg.getPublicKey();

        kg.generateKeys();
        RSAKey publicKey2 = kg.getPublicKey();

        assertNotEquals(publicKey1, publicKey2);
    }

    @Test
    public void privateKeysDoNotMatchIfGeneratedAgain() {
        kg.generateKeys();
        RSAKey privateKey1 = kg.getPrivateKey();

        kg.generateKeys();
        RSAKey privateKey2 = kg.getPrivateKey();

        assertNotEquals(privateKey1, privateKey2);
    }

    @Test
    public void privateAndPublicKeysDoNotMatch() {
        kg.generateKeys();
        RSAKey publicKey = kg.getPublicKey();
        RSAKey privateKey = kg.getPrivateKey();

        assertNotEquals(publicKey, privateKey);
    }

    @Test
    public void compositeNumberDoesNotPassMillerRabinTest() {
        assertFalse(kg.millerRabin(BigInteger.TEN));
    }

    @Test
    public void compositeNumberIsNotPrime() {
        assertFalse(kg.isPrime(BigInteger.TEN));
    }
}