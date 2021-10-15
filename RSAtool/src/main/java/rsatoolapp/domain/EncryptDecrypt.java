package rsatoolapp.domain;

import java.math.BigInteger;

/**
 * Luokka viestin salaamiseen/purkamiseen.
 */

public class EncryptDecrypt {
    BigInteger encryptedMessage;
    String decryptedMessage;

    /**
     * Salaa viestin.
     *
     * @param n   modulo
     * @param e   julkinen eksponentti
     * @param msg salattava viesti
     */

    public void encrypt(BigInteger n, BigInteger e, String msg) {
        BigInteger msgInBigInt = new BigInteger(msg.getBytes());
        encryptedMessage = msgInBigInt.modPow(e, n);
    }

    /**
     * Purkaa viestin.
     *
     * @param n   modulo
     * @param d   yksityinen eksponentti
     * @param msg purettava viesti
     */

    public void decrypt(BigInteger n, BigInteger d, BigInteger msg) {
        BigInteger decrypted = msg.modPow(d, n);
        decryptedMessage = new String(decrypted.toByteArray());
    }

    /**
     * Palauttaa salatun viestin BigInteger-muodossa.
     *
     * @return salattu viesti
     */

    public BigInteger getEncryptedMessage() {
        return encryptedMessage;
    }

    /**
     * Palauttaa puretun viestin String-muodossa.
     *
     * @return purettu viesti
     */

    public String getDecryptedMessage() {
        return decryptedMessage;
    }
}