package rsatoolapp.domain;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.*;
import java.util.Base64;

/**
 * Class for encrypting/decrypting a message.
 */

public class EncryptDecrypt {
    String encryptedMessage;
    String decryptedMessage;
    Base64.Decoder decoder;

    /**
     * Initializes the encrypt/decrypt.
     */

    public EncryptDecrypt() {
        decoder = Base64.getDecoder();
    }

    /**
     * Encrypts a message.
     * @param message to be encrypted
     * @param key the RSA key used to encrypt the message. Can be public or private key
     * @param isPublicKey true if a public key is used, false if private key is used
     */

    public void encrypt(String message, String key, Boolean isPublicKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException {
        // Converts String to PublicKey
        Key encryptKey = getKey(key, isPublicKey);

        Cipher encryptCipher = Cipher.getInstance("RSA");
        encryptCipher.init(Cipher.ENCRYPT_MODE, encryptKey);

        byte[] secretMessageBytes = message.getBytes(StandardCharsets.UTF_8);
        byte[] encryptedMessageBytes = encryptCipher.doFinal(secretMessageBytes);

        encryptedMessage = Base64.getEncoder().encodeToString(encryptedMessageBytes);
    }

    /**
     * Decrypts a message.
     * @param message to be encrypted
     * @param key the RSA key used to encrypt the message. Can be public or private key
     * @param isPublicKey true if a public key is used, false if private key is used
     */

    public void decrypt(String message, String key, Boolean isPublicKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, InvalidKeySpecException {
        // Converts String to PrivateKey
        Key decryptKey = getKey(key, isPublicKey);

        Cipher decryptCipher = Cipher.getInstance("RSA");
        decryptCipher.init(Cipher.DECRYPT_MODE, decryptKey);
        byte[] decryptedMessageBytes = decryptCipher.doFinal(decoder.decode(message.getBytes(StandardCharsets.UTF_8)));

        decryptedMessage =  new String(decryptedMessageBytes, StandardCharsets.UTF_8);
    }

    /**
     * Transforms the key from string to the required key spec for encryption/decryption
     * @param key the RSA key used to encrypt the message. Can be public or private key
     * @param isPublicKey true if a public key is used, false if private key is used
     * @return the key in specified form
     */

    private Key getKey(String key, Boolean isPublicKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] bytes = decoder.decode(key.getBytes(StandardCharsets.UTF_8));
        KeyFactory kf = KeyFactory.getInstance("RSA");
        //RSAPrivateKeySpec privateSpec = new RSAPrivateKeySpec();

        if (isPublicKey) {
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(bytes);
            return kf.generatePublic(keySpec);
        } else {
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(bytes);
            return kf.generatePrivate(keySpec);
        }
    }

    /**
     * Returns the message in an encrypted Base64 form
     * @return the encrypted message
     */

    public String getEncryptedMessage() {
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