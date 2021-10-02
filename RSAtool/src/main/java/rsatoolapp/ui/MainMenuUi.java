package rsatoolapp.ui;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainMenuUi {
    public VBox vbMain;
    public HBox hbEncryptDecrypt;
    public VBox vbGenerate;
    public VBox vbEncrypt;
    public VBox vbDecrypt;
    public HBox hbEncryptRadio;
    public HBox hbDecryptRadio;
    public Label generateLabel;
    public Label clickToGenerateLabel;
    public Label commonModulusLabel;
    public Label publicExponentLabel;
    public Label privateExponentLabel;
    public TextArea commonModulusArea;
    public TextArea publicExponentArea;
    public TextArea privateExponentArea;
    public Label encryptLabel;
    public Label decryptLabel;
    public Label encryptTextLabel;
    public Label decryptTextLabel;
    public TextArea encryptTextArea;
    public TextArea decryptTextArea;
    public Label clickToEncryptLabel;
    public Label clickToDecryptLabel;
    public Button btnGenerate;
    public Button btnEncrypt;
    public Button btnDecrypt;
    public Label encryptedTextLabel;
    public Label decryptedTextLabel;
    public TextArea encryptedTextArea;
    public TextArea decryptedTextArea;
    public Separator vSeparator1;
    public Separator vSeparator2;
    public Button btnQuit;

    public MainMenuUi(int width, int height) {
        vbMain = new VBox();
        vbMain.setPadding(new Insets(20, 20, 20, 20));
        vbMain.setSpacing(20);
        vbMain.setAlignment(Pos.CENTER);
        vbMain.setPrefSize(width, height);

        hbEncryptDecrypt = new HBox();
        hbEncryptDecrypt.setPadding(new Insets(20, 20, 20, 20));
        hbEncryptDecrypt.setSpacing(20);
        hbEncryptDecrypt.setAlignment(Pos.CENTER);
        hbEncryptDecrypt.setPrefSize(width, height);

        vbGenerate = new VBox();
        vbGenerate.setAlignment(Pos.CENTER);

        generateLabel = new Label("Generate keys");
        generateLabel.setStyle("-fx-font-size:40");
        generateLabel.setPadding(new Insets(10, 10, 20, 10));

        clickToGenerateLabel = new Label("Click to generate keys:");
        clickToGenerateLabel.setStyle("-fx-font-size:20");
        clickToGenerateLabel.setPadding(new Insets(0, 10, 5, 10));

        btnGenerate = new Button("Generate");
        btnGenerate.setStyle("-fx-font-size:20");

        commonModulusLabel = new Label("Common modulus");
        commonModulusLabel.setStyle("-fx-font-size:20");
        commonModulusLabel.setPadding(new Insets(30, 10, 5, 10));

        commonModulusArea = new TextArea("");
        commonModulusArea.setEditable(false);
        commonModulusArea.setWrapText(true);
        commonModulusArea.setPrefSize(width - 50, 2000);

        publicExponentLabel = new Label("Public key exponent");
        publicExponentLabel.setStyle("-fx-font-size:20");
        publicExponentLabel.setPadding(new Insets(30, 10, 5, 10));

        publicExponentArea = new TextArea("");
        publicExponentArea.setEditable(false);
        publicExponentArea.setWrapText(true);
        publicExponentArea.setPrefSize(width - 50, 2000);

        privateExponentLabel = new Label("Private key exponent");
        privateExponentLabel.setStyle("-fx-font-size:20");
        privateExponentLabel.setPadding(new Insets(30, 10, 5, 10));

        privateExponentArea = new TextArea("");
        privateExponentArea.setEditable(false);
        privateExponentArea.setWrapText(true);
        privateExponentArea.setPrefSize(width - 50, 2000);

        vbEncrypt = new VBox();
        vbEncrypt.setAlignment(Pos.CENTER);

        vbDecrypt = new VBox();
        vbDecrypt.setAlignment(Pos.CENTER);

        hbEncryptRadio = new HBox();
        hbEncryptRadio.setSpacing(20);
        hbEncryptRadio.setAlignment(Pos.CENTER);
        hbEncryptRadio.setPadding(new Insets(5));

        hbDecryptRadio = new HBox();
        hbDecryptRadio.setSpacing(20);
        hbDecryptRadio.setAlignment(Pos.CENTER);
        hbDecryptRadio.setPadding(new Insets(5));

        encryptLabel = new Label("Encrypt");
        encryptLabel.setStyle("-fx-font-size:40");
        encryptLabel.setPadding(new Insets(10, 10, 10, 10));

        decryptLabel = new Label("Decrypt");
        decryptLabel.setStyle("-fx-font-size:40");
        decryptLabel.setPadding(new Insets(10, 10, 10, 10));

        encryptTextLabel = new Label("Enter text to encrypt:");
        encryptTextLabel.setStyle("-fx-font-size:20");
        encryptTextLabel.setPadding(new Insets(10, 10, 5, 10));

        decryptTextLabel = new Label("Enter text to decrypt:");
        decryptTextLabel.setStyle("-fx-font-size:20");
        decryptTextLabel.setPadding(new Insets(10, 10, 5, 10));

        encryptTextArea = new TextArea("");
        encryptTextArea.setPromptText("Enter text to encrypt");
        encryptTextArea.setWrapText(true);
        encryptTextArea.setPrefSize(width - 50, 2000);

        decryptTextArea = new TextArea("");
        decryptTextArea.setPromptText("Enter text to decrypt");
        decryptTextArea.setWrapText(true);
        decryptTextArea.setPrefSize(width - 50, 2000);

        clickToEncryptLabel = new Label("Click to encrypt:");
        clickToEncryptLabel.setStyle("-fx-font-size:20");
        clickToEncryptLabel.setPadding(new Insets(30, 10, 5, 10));

        clickToDecryptLabel = new Label("Click to decrypt:");
        clickToDecryptLabel.setStyle("-fx-font-size:20");
        clickToDecryptLabel.setPadding(new Insets(30, 10, 5, 10));

        btnEncrypt = new Button("Encrypt");
        btnEncrypt.setStyle("-fx-font-size:20");

        btnDecrypt = new Button("Decrypt");
        btnDecrypt.setStyle("-fx-font-size:20");

        encryptedTextLabel = new Label("Encrypted text:");
        encryptedTextLabel.setStyle("-fx-font-size:20");
        encryptedTextLabel.setPadding(new Insets(30, 10, 5, 10));

        decryptedTextLabel = new Label("Decrypted text:");
        decryptedTextLabel.setStyle("-fx-font-size:20");
        decryptedTextLabel.setPadding(new Insets(30, 10, 5, 10));

        encryptedTextArea = new TextArea("");
        encryptedTextArea.setEditable(false);
        encryptedTextArea.setWrapText(true);
        encryptedTextArea.setPrefSize(width - 50, 2000);

        decryptedTextArea = new TextArea("");
        decryptedTextArea.setEditable(false);
        decryptedTextArea.setWrapText(true);
        decryptedTextArea.setPrefSize(width - 50, 2000);

        vSeparator1 = new Separator(Orientation.VERTICAL);
        vSeparator2 = new Separator(Orientation.VERTICAL);

        btnQuit = new Button("Quit");
        btnQuit.setStyle("-fx-font-size:30");

        vbGenerate.getChildren().addAll(generateLabel, clickToGenerateLabel, btnGenerate, commonModulusLabel, commonModulusArea, publicExponentLabel, publicExponentArea, privateExponentLabel, privateExponentArea);
        vbEncrypt.getChildren().addAll(encryptLabel, encryptTextLabel, encryptTextArea, clickToEncryptLabel, btnEncrypt, encryptedTextLabel, encryptedTextArea);
        vbDecrypt.getChildren().addAll(decryptLabel, decryptTextLabel, decryptTextArea, clickToDecryptLabel, btnDecrypt, decryptedTextLabel, decryptedTextArea);
        hbEncryptDecrypt.getChildren().addAll(vbGenerate, vSeparator1, vbEncrypt, vSeparator2, vbDecrypt);
        vbMain.getChildren().addAll(hbEncryptDecrypt, btnQuit);
    }

    public Scene getScene() {
        return new Scene(vbMain);
    }
}
