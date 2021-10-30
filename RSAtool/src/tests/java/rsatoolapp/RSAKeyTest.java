package rsatoolapp;

import org.junit.BeforeClass;
import org.junit.Test;
import rsatoolapp.domain.KeyGenerator;

import static org.junit.Assert.*;

public class RSAKeyTest {
    private static KeyGenerator kg;

    @BeforeClass
    public static void setUp() {
        kg = new KeyGenerator();
        kg.generateKeys();
    }

    @Test
    public void publicModulusIsReturned() {
        assertNotNull(kg.getPublicKey().getModulus());
    }

    @Test
    public void privateModulusIsReturned() {
        assertNotNull(kg.getPrivateKey().getModulus());
    }

    @Test
    public void privateAndPublicModulusAreEqual() {
        assertEquals(kg.getPublicKey().getModulus(), kg.getPrivateKey().getModulus());
    }

    @Test
    public void publicExponentIsReturned() {
        assertNotNull(kg.getPublicKey().getExponent());
    }

    @Test
    public void privateExponentIsReturned() {
        assertNotNull(kg.getPrivateKey().getExponent());
    }

    @Test
    public void privateAndPublicExponentAreNotEqual() {
        assertNotEquals(kg.getPublicKey().getExponent(), kg.getPrivateKey().getExponent());
    }
}
