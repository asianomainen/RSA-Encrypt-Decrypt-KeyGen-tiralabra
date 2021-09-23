package rsatoolapp.ui;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class EncryptDecryptUi {
    public VBox vbMain;
    public HBox hbEncryptDecrypt;
    public HBox hbEncryptRadio;
    public HBox hbDecryptRadio;
    public VBox vbEncrypt;
    public VBox vbDecrypt;
    public Label encryptLabel;
    public Label decryptLabel;
    public Label encryptTextLabel;
    public Label decryptTextLabel;
    public TextArea encryptTextArea;
    public TextArea decryptTextArea;
    public ToggleGroup encryptRadioButtonGroup;
    public RadioButton encryptPublicKeyButton;
    public RadioButton encryptPrivateKeyButton;
    public ToggleGroup decryptRadioButtonGroup;
    public RadioButton decryptPublicKeyButton;
    public RadioButton decryptPrivateKeyButton;
    public Label encryptKeyLabel;
    public Label decryptKeyLabel;
    public TextArea encryptKeyArea;
    public TextArea decryptKeyArea;
    public Label clickToEncryptLabel;
    public Label clickToDecryptLabel;
    public Button encryptBtn;
    public Button decryptBtn;
    public Label encryptedTextLabel;
    public Label decryptedTextLabel;
    public TextArea encryptedTextArea;
    public TextArea decryptedTextArea;
    public Separator separator;
    public Button btnBackToMainMenu;

    public EncryptDecryptUi(int width, int height) {
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

        encryptRadioButtonGroup = new ToggleGroup();
        encryptPublicKeyButton = new RadioButton("Public key");
        encryptPublicKeyButton.setToggleGroup(encryptRadioButtonGroup);
        encryptPublicKeyButton.setSelected(true);
        encryptPrivateKeyButton = new RadioButton("Private key");
        encryptPrivateKeyButton.setToggleGroup(encryptRadioButtonGroup);

        decryptRadioButtonGroup = new ToggleGroup();
        decryptPublicKeyButton = new RadioButton("Public key");
        decryptPublicKeyButton.setToggleGroup(decryptRadioButtonGroup);
        decryptPrivateKeyButton = new RadioButton("Private key");
        decryptPrivateKeyButton.setSelected(true);
        decryptPrivateKeyButton.setToggleGroup(decryptRadioButtonGroup);

        encryptKeyLabel = new Label("Enter RSA key:");
        encryptKeyLabel.setStyle("-fx-font-size:20");
        encryptKeyLabel.setPadding(new Insets(30, 10, 0, 10));

        decryptKeyLabel = new Label("Enter RSA key:");
        decryptKeyLabel.setStyle("-fx-font-size:20");
        decryptKeyLabel.setPadding(new Insets(30, 10, 0, 10));

        encryptKeyArea = new TextArea("");
        encryptKeyArea.setPromptText("Enter RSA key");
        encryptKeyArea.setWrapText(true);
        encryptKeyArea.setPrefSize(width - 50, 2000);

        decryptKeyArea = new TextArea("");
        decryptKeyArea.setPromptText("Insert private key");
        decryptKeyArea.setWrapText(true);
        decryptKeyArea.setPrefSize(width - 50, 2000);

        clickToEncryptLabel = new Label("Click to encrypt:");
        clickToEncryptLabel.setStyle("-fx-font-size:20");
        clickToEncryptLabel.setPadding(new Insets(30, 10, 5, 10));

        clickToDecryptLabel = new Label("Click to decrypt:");
        clickToDecryptLabel.setStyle("-fx-font-size:20");
        clickToDecryptLabel.setPadding(new Insets(30, 10, 5, 10));

        encryptBtn = new Button("Encrypt");
        encryptBtn.setStyle("-fx-font-size:20");

        decryptBtn = new Button("Decrypt");
        decryptBtn.setStyle("-fx-font-size:20");

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

        separator = new Separator(Orientation.VERTICAL);

        btnBackToMainMenu = new Button("Back to main menu");
        btnBackToMainMenu.setStyle("-fx-font-size:30");

        hbEncryptRadio.getChildren().addAll(encryptPublicKeyButton, encryptPrivateKeyButton);
        hbDecryptRadio.getChildren().addAll(decryptPublicKeyButton, decryptPrivateKeyButton);
        vbEncrypt.getChildren().addAll(encryptLabel, encryptTextLabel, encryptTextArea, encryptKeyLabel, hbEncryptRadio,
                                       encryptKeyArea, clickToEncryptLabel, encryptBtn, encryptedTextLabel, encryptedTextArea);
        vbDecrypt.getChildren().addAll(decryptLabel, decryptTextLabel, decryptTextArea, decryptKeyLabel,hbDecryptRadio,
                                       decryptKeyArea, clickToDecryptLabel, decryptBtn, decryptedTextLabel, decryptedTextArea);
        hbEncryptDecrypt.getChildren().addAll(vbEncrypt, separator, vbDecrypt);
        vbMain.getChildren().addAll(hbEncryptDecrypt, btnBackToMainMenu);
    }

    public Scene getScene() {
        return new Scene(vbMain);
    }
}
