package rsatoolapp.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import rsatoolapp.domain.EncryptDecrypt;
import rsatoolapp.domain.KeyGenerator;

import java.math.BigInteger;

/**
 * Class for creating the UI.
 */

public class RSAtoolUi extends Application {
    private final static int WIDTH = 1440;
    private final static int HEIGHT = 960;

    @Override
    public void start(Stage stage) {
        MainMenuUi mainMenuUi = new MainMenuUi(WIDTH, HEIGHT);
        Scene mainMenuScene = mainMenuUi.getScene();
        KeyGenerator keyGen = new KeyGenerator();
        EncryptDecrypt encDec = new EncryptDecrypt();

        stage.setScene(mainMenuScene);
        stage.setTitle("RSA Tool");
        stage.show();

        mainMenuUi.btnQuit.setOnAction(event -> stage.close());

        mainMenuUi.btnGenerate.setOnAction(event -> {
            keyGen.generateKeys();
            mainMenuUi.commonModulusArea.setText(keyGen.getPublicKey().getModulus().toString());
            mainMenuUi.publicExponentArea.setText(keyGen.getPublicKey().getExponent().toString());
            mainMenuUi.privateExponentArea.setText(keyGen.getPrivateKey().getExponent().toString());
        });

        mainMenuUi.btnEncrypt.setOnAction(event -> {
            encDec.encrypt(new BigInteger(mainMenuUi.commonModulusArea.getText()), new BigInteger(mainMenuUi.publicExponentArea.getText()), mainMenuUi.encryptTextArea.getText());
            mainMenuUi.encryptedTextArea.setText(encDec.getEncryptedMessage().toString());
        });

        mainMenuUi.btnDecrypt.setOnAction(event -> {
            encDec.decrypt(new BigInteger(mainMenuUi.commonModulusArea.getText()), new BigInteger(mainMenuUi.privateExponentArea.getText()), new BigInteger(mainMenuUi.decryptTextArea.getText()));
            mainMenuUi.decryptedTextArea.setText(encDec.getDecryptedMessage());
        });
    }

    public static void main(String[] args) {
        launch(RSAtoolUi.class);
    }
}
