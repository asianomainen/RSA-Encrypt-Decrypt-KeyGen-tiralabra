package rsatoolapp.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import rsatoolapp.domain.EncryptDecrypt;
import rsatoolapp.domain.KeyGenerator;

import java.math.BigInteger;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Luokka, joka aloittaa ohjelman ja hallinnoi käyttöliittymän painikkeita.
 */

public class RSAToolUi extends Application {
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
            if (Objects.equals(mainMenuUi.commonModulusArea.getText(), "")) {
                Alert noKeysGenerated = new Alert(Alert.AlertType.ERROR);
                noKeysGenerated.setContentText("RSA-avainparia ei ole luotu.");
                noKeysGenerated.show();
            } else if (Objects.equals(mainMenuUi.encryptTextArea.getText(), "")) {
                Alert noTextInserted = new Alert(Alert.AlertType.ERROR);
                noTextInserted.setContentText("Syötä salattava viesti.");
                noTextInserted.show();
            } else {
                encDec.encrypt(new BigInteger(mainMenuUi.commonModulusArea.getText()), new BigInteger(mainMenuUi.publicExponentArea.getText()), mainMenuUi.encryptTextArea.getText());
                mainMenuUi.encryptedTextArea.setText(encDec.getEncryptedMessage().toString());
            }
        });

        mainMenuUi.btnCopyText.setOnAction(event -> {
            if (Objects.equals(mainMenuUi.encryptedTextArea.getText(), "")) {
                Alert noEncryptedText = new Alert(Alert.AlertType.ERROR);
                noEncryptedText.setContentText("Ei kopioitavaa salattua viestiä.");
                noEncryptedText.show();
            } else {
                mainMenuUi.decryptTextArea.setText(encDec.getEncryptedMessage().toString());
            }
        });

        mainMenuUi.btnDecrypt.setOnAction(event -> {
            if (Objects.equals(mainMenuUi.commonModulusArea.getText(), "")) {
                Alert noKeysGenerated = new Alert(Alert.AlertType.ERROR);
                noKeysGenerated.setContentText("RSA-avainparia ei ole luotu.");
                noKeysGenerated.show();
            } else if (Objects.equals(mainMenuUi.decryptTextArea.getText(), "")) {
                Alert noEncryptedTextEntered = new Alert(Alert.AlertType.ERROR);
                noEncryptedTextEntered.setContentText("Syötä purettava viesti.");
                noEncryptedTextEntered.show();
            } else if (!Pattern.matches("[0-9]+", mainMenuUi.decryptTextArea.getText())) {
                Alert invalidEncryptedText = new Alert(Alert.AlertType.ERROR);
                invalidEncryptedText.setContentText("Salattu viesti saa sisältää vain numeroita.");
                invalidEncryptedText.show();
            } else {
                encDec.decrypt(new BigInteger(mainMenuUi.commonModulusArea.getText()), new BigInteger(mainMenuUi.privateExponentArea.getText()), new BigInteger(mainMenuUi.decryptTextArea.getText()));
                mainMenuUi.decryptedTextArea.setText(encDec.getDecryptedMessage());
            }
        });
    }

    public static void main(String[] args) {
        launch(RSAToolUi.class);
    }
}
