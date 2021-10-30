package rsatoolapp;

import org.junit.BeforeClass;
import org.junit.Test;
import rsatoolapp.domain.KeyGenerator;
import rsatoolapp.domain.RSAKey;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class KeyGeneratorTest {
    private static KeyGenerator kg;

    @BeforeClass
    public static void setUp() {
        kg = new KeyGenerator();
        kg.generateKeys();
    }

    @Test
    public void publicKeyIsGenerated() {
        assertNotNull(kg.getPublicKey());
    }

    @Test
    public void privateKeyIsGenerated() {
        assertNotNull(kg.getPrivateKey());
    }

    @Test
    public void publicKeysDoNotMatchIfGeneratedAgain() {
        RSAKey publicKey1 = kg.getPublicKey();

        kg.generateKeys();
        RSAKey publicKey2 = kg.getPublicKey();

        assertNotEquals(publicKey1, publicKey2);
    }

    @Test
    public void privateKeysDoNotMatchIfGeneratedAgain() {
        RSAKey privateKey1 = kg.getPrivateKey();

        kg.generateKeys();
        RSAKey privateKey2 = kg.getPrivateKey();

        assertNotEquals(privateKey1, privateKey2);
    }

    @Test
    public void privateAndPublicKeysDoNotMatch() {
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