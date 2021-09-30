package rsatoolapp.domain;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class EncryptDecrypt {
    String encryptedMessage;
    String decryptedMessage;
    Base64.Decoder decoder;

    public EncryptDecrypt() {
        decoder = Base64.getDecoder();
    }

    public void encrypt(String message, String key, Boolean isPublicKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException {
        // Converts String to PublicKey
        Key encryptKey = getKey(key, isPublicKey);

        Cipher encryptCipher = Cipher.getInstance("RSA");
        encryptCipher.init(Cipher.ENCRYPT_MODE, encryptKey);

        byte[] secretMessageBytes = message.getBytes(StandardCharsets.UTF_8);
        byte[] encryptedMessageBytes = encryptCipher.doFinal(secretMessageBytes);

        encryptedMessage = Base64.getEncoder().encodeToString(encryptedMessageBytes);
    }

    public void decrypt(String message, String key, Boolean isPublicKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, InvalidKeySpecException {
        // Converts String to PrivateKey
        Key decryptKey = getKey(key, isPublicKey);

        Cipher decryptCipher = Cipher.getInstance("RSA");
        decryptCipher.init(Cipher.DECRYPT_MODE, decryptKey);
        byte[] decryptedMessageBytes = decryptCipher.doFinal(decoder.decode(message.getBytes(StandardCharsets.UTF_8)));

        decryptedMessage =  new String(decryptedMessageBytes, StandardCharsets.UTF_8);
    }


    private Key getKey(String key, Boolean isPublicKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] bytes = decoder.decode(key.getBytes(StandardCharsets.UTF_8));
        KeyFactory kf = KeyFactory.getInstance("RSA");

        if (isPublicKey) {
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(bytes);
            return kf.generatePublic(keySpec);
        } else {
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(bytes);
            return kf.generatePrivate(keySpec);
        }
    }

    public String getEncryptedMessage() {
        return encryptedMessage;
    }

    public String getDecryptedMessage() {
        return decryptedMessage;
    }
}