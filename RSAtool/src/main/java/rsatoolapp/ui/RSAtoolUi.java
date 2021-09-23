package rsatoolapp.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import rsatoolapp.domain.EncryptDecrypt;
import rsatoolapp.domain.KeyGenerator;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class RSAtoolUi extends Application {
    private final static int width = 960;
    private final static int height = 960;

    @Override
    public void start(Stage stage) throws NoSuchAlgorithmException, IOException {
        MainMenuUi mainMenuUi = new MainMenuUi(width, height);
        Scene mainMenuScene = mainMenuUi.getScene();
        KeyGeneratorUi keyGenUi = new KeyGeneratorUi(width, height);
        Scene keyGenScene = keyGenUi.getScene();
        KeyGenerator kg = new KeyGenerator();
        EncryptDecryptUi encryptDecryptUi = new EncryptDecryptUi(width, height);
        Scene encryptDecryptScene = encryptDecryptUi.getScene();
        EncryptDecrypt encDec = new EncryptDecrypt();

        stage.setScene(mainMenuScene);
        stage.setTitle("RSA Tool");
        stage.show();

        mainMenuUi.btnGenerator.setOnAction(event -> stage.setScene(keyGenScene));
        mainMenuUi.btnEncryptDecrypt.setOnAction(event -> stage.setScene(encryptDecryptScene));
        keyGenUi.btnBackToMainMenu.setOnAction(event -> stage.setScene(mainMenuScene));
        encryptDecryptUi.btnBackToMainMenu.setOnAction(event -> stage.setScene(mainMenuScene));
        mainMenuUi.btnExit.setOnAction(event -> stage.close());

        keyGenUi.btnGenerate.setOnAction(event -> {
            try {
                kg.generateKeys();
            } catch (IOException | InvalidKeySpecException | NoSuchPaddingException | NoSuchAlgorithmException |
                    InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
                e.printStackTrace();
            }
            keyGenUi.publicKeyArea.setText(kg.getPublicKey());
            keyGenUi.privateKeyArea.setText(kg.getPrivateKey());
        });

        encryptDecryptUi.encryptBtn.setOnAction(event -> {
            try {
                encDec.encrypt(kg, encryptDecryptUi.encryptTextArea.getText(), encryptDecryptUi.encryptKeyArea.getText());
                encryptDecryptUi.encryptedTextArea.setText(encDec.getEncryptedMessage());
            } catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException |
                    IllegalBlockSizeException | BadPaddingException | InvalidKeySpecException e) {
                e.printStackTrace();
            }
        });

        encryptDecryptUi.decryptBtn.setOnAction(event -> {
            try {
                encDec.decrypt(kg, encryptDecryptUi.decryptTextArea.getText(), encryptDecryptUi.decryptKeyArea.getText());
                encryptDecryptUi.decryptedTextArea.setText(encDec.getDecryptedMessage());
            } catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException |
                    IllegalBlockSizeException | BadPaddingException | UnsupportedEncodingException |
                    InvalidKeySpecException e) {

                e.printStackTrace();
            }
        });
    }

    public static void main(String[] args) {
        launch(RSAtoolUi.class);
    }
}
