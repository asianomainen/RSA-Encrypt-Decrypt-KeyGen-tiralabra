package rsatoolapp;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import rsatoolapp.domain.EncryptDecrypt;
import rsatoolapp.domain.KeyGenerator;
import rsatoolapp.domain.RSAKey;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class EncryptDecryptTest {
    private static KeyGenerator kg;
    private static EncryptDecrypt ed;

    @BeforeAll
    public static void setUp() {
        kg = new KeyGenerator();
        ed = new EncryptDecrypt();
        kg.generateKeys();
    }

    @Test
    public void messageIsEncrypted() {
        String msg = "Secret";
        RSAKey pubKey = kg.getPublicKey();

        ed.encrypt(pubKey.getModulus(), pubKey.getExponent(), msg);

        BigInteger encryptedMessage = ed.getEncryptedMessage();

        assertNotEquals(msg, encryptedMessage.toString());
    }

    @Test
    public void messageIsDecrypted() {
        String msg = "Secret";
        RSAKey pubKey = kg.getPublicKey();
        RSAKey pvtKey = kg.getPrivateKey();

        ed.encrypt(pubKey.getModulus(), pubKey.getExponent(), msg);
        ed.decrypt(pubKey.getModulus(), pvtKey.getExponent(), ed.getEncryptedMessage());

        String decryptedMessage = ed.getDecryptedMessage();

        assertEquals(msg, decryptedMessage);
    }

    @Test
    public void differentMessageDoesNotHaveTheSameEncryptedMessage() {
        String msg = "Secret";
        RSAKey pubKey = kg.getPublicKey();

        ed.encrypt(pubKey.getModulus(), pubKey.getExponent(), msg);
        BigInteger encryptedMessage1 = ed.getEncryptedMessage();

        msg = "Top Secret";

        ed.encrypt(pubKey.getModulus(), pubKey.getExponent(), msg);
        BigInteger encryptedMessage2 = ed.getEncryptedMessage();

        assertNotEquals(encryptedMessage1, encryptedMessage2);
    }

    @Test
    public void decryptedMessagesDoNotEqualIfDecryptedWithWrongKey() {
        String msg = "Secret";
        RSAKey pubKey = kg.getPublicKey();
        RSAKey pvtKey = kg.getPrivateKey();

        ed.encrypt(pubKey.getModulus(), pubKey.getExponent(), msg);
        ed.decrypt(pubKey.getModulus(), pvtKey.getExponent(), ed.getEncryptedMessage());

        String decryptedMessage1 = ed.getDecryptedMessage();

        kg.generateKeys();

        pvtKey = kg.getPrivateKey();

        ed.decrypt(pubKey.getModulus(), pvtKey.getExponent(), ed.getEncryptedMessage());

        String decryptedMessage2 = ed.getDecryptedMessage();

        assertNotEquals(decryptedMessage1, decryptedMessage2);
    }
}