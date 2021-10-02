package rsatoolapp.domain;

import java.math.BigInteger;
import java.util.Base64;

/**
 * Class for encrypting/decrypting a message.
 */

public class EncryptDecrypt {
    BigInteger encryptedMessage;
    String decryptedMessage;

    /**
     * Encrypts a message.
     */

    public void encrypt(BigInteger n, BigInteger e, String msg) {
        BigInteger msgInBigInt = new BigInteger(msg.getBytes());
        encryptedMessage = msgInBigInt.modPow(e, n);
    }

    /**
     * Decrypts a message.
     */

    public void decrypt(BigInteger n, BigInteger d, BigInteger msg) {
        BigInteger decrypted = msg.modPow(d, n);
        decryptedMessage =  new String(decrypted.toByteArray());
    }

    /**
     * Returns the message in an encrypted Base64 form
     * @return the encrypted message
     */

    public BigInteger getEncryptedMessage() {
        return encryptedMessage;
    }

    /**
     * Returns the message in a decrypted Base64 form
     * @return the decrypted message
     */

    public String getDecryptedMessage() {
        return decryptedMessage;
    }
}