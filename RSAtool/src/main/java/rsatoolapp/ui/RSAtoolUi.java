package rsatoolapp.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import rsatoolapp.domain.KeyGenerator;

import java.io.IOException;
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
        EncryptDecryptMenuUi encryptDecryptMenuUi = new EncryptDecryptMenuUi(width, height);
        Scene encryptDecryptScene = encryptDecryptMenuUi.getScene();

        stage.setScene(mainMenuScene);
        stage.setTitle("RSA Tool");
        stage.show();

        mainMenuUi.btnGenerator.setOnAction(event -> stage.setScene(keyGenScene));
        mainMenuUi.btnEncryptDecrypt.setOnAction(event -> stage.setScene(encryptDecryptScene));
        keyGenUi.btnBackToMainMenu.setOnAction(event -> stage.setScene(mainMenuScene));
        encryptDecryptMenuUi.btnBackToMainMenu.setOnAction(event -> stage.setScene(mainMenuScene));
        mainMenuUi.btnExit.setOnAction(event -> stage.close());

        keyGenUi.btnGenerate.setOnAction(event -> {
            try {
                kg.generateKeys();
            } catch (IOException | InvalidKeySpecException e) {
                e.printStackTrace();
            }
            keyGenUi.publicKeyArea.setText(kg.getPublicKey());
            keyGenUi.privateKeyArea.setText(kg.getPrivateKey());
        });
    }

    public static void main(String[] args) {
        launch(RSAtoolUi.class);
    }
}
