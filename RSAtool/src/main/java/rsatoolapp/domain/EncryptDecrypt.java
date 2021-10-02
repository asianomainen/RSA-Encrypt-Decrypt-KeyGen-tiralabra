package rsatoolapp.domain;

import java.math.BigInteger;

/**
 * Class for encrypting/decrypting a message.
 */

public class EncryptDecrypt {
    BigInteger encryptedMessage;
    String decryptedMessage;

    /**
     * Encrypts a message.
     * @param   n   the modulus
     * @param   e   the public exponent
     * @param   msg the message
     */

    public void encrypt(BigInteger n, BigInteger e, String msg) {
        BigInteger msgInBigInt = new BigInteger(msg.getBytes());
        encryptedMessage = msgInBigInt.modPow(e, n);
    }

    /**
     * Decrypts a message.
     * @param   n   the modulus
     * @param   d   the private exponent
     * @param   msg the message
     */

    public void decrypt(BigInteger n, BigInteger d, BigInteger msg) {
        BigInteger decrypted = msg.modPow(d, n);
        decryptedMessage =  new String(decrypted.toByteArray());
    }

    /**
     * Returns the encrypted message as a BigInteger.
     * @return      the encrypted message
     */

    public BigInteger getEncryptedMessage() {
        return encryptedMessage;
    }

    /**
     * Returns the decrypted message as a String.
     * @return      the decrypted message
     */

    public String getDecryptedMessage() {
        return decryptedMessage;
    }
}