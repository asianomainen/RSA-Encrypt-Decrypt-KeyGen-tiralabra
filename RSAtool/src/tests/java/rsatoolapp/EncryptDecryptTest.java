package rsatoolapp;

import org.junit.Before;
import org.junit.Test;
import rsatoolapp.domain.EncryptDecrypt;
import rsatoolapp.domain.KeyGenerator;
import rsatoolapp.domain.RSAKey;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class EncryptDecryptTest {
    KeyGenerator kg;
    EncryptDecrypt ed;

    @Before
    public void setUp() {
        kg = new KeyGenerator();
        ed = new EncryptDecrypt();
    }

    @Test
    public void messageIsEncrypted() {
        kg.generateKeys();

        String msg = "Secret";
        RSAKey pubKey = kg.getPublicKey();

        ed.encrypt(pubKey.getModulus(), pubKey.getExponent(), msg);

        BigInteger encryptedMessage = ed.getEncryptedMessage();

        assertNotEquals(msg, encryptedMessage.toString());
    }

    @Test
    public void messageIsDecrypted() {
        kg.generateKeys();

        String msg = "Secret";
        RSAKey pubKey = kg.getPublicKey();
        RSAKey pvtKey = kg.getPrivateKey();

        ed.encrypt(pubKey.getModulus(), pubKey.getExponent(), msg);
        ed.decrypt(pubKey.getModulus(), pvtKey.getExponent(), ed.getEncryptedMessage());

        String decryptedMessage = ed.getDecryptedMessage();

        assertEquals(msg, decryptedMessage);
    }

    @Test
    public void encryptedMessagesDoNotEqualIfEncryptedAgain() {
        kg.generateKeys();

        String msg = "Secret";
        RSAKey pubKey = kg.getPublicKey();

        ed.encrypt(pubKey.getModulus(), pubKey.getExponent(), msg);
        BigInteger encryptedMessage1 = ed.getEncryptedMessage();

        ed.encrypt(pubKey.getModulus(), pubKey.getExponent(), msg);
        BigInteger encryptedMessage2 = ed.getEncryptedMessage();

        assertEquals(encryptedMessage1, encryptedMessage2);
    }
}