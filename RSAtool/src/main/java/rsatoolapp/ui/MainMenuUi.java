package rsatoolapp.ui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class MainMenuUi {
    public VBox vbButtons;
    public Button btnGenerator;
    public Button btnEncryptDecrypt;
    public Button btnExit;

    public MainMenuUi(int width, int height) {
        vbButtons = new VBox();
        vbButtons.setSpacing(20);
        vbButtons.setAlignment(Pos.CENTER);
        vbButtons.setPrefSize(width, height);

        btnGenerator = new Button("RSA key generator");
        btnGenerator.setStyle("-fx-font-size:40");
        btnEncryptDecrypt = new Button("Encrypt/Decrypt message");
        btnEncryptDecrypt.setStyle("-fx-font-size:40");
        btnExit = new Button("Exit");
        btnExit.setStyle("-fx-font-size:40");

        vbButtons.getChildren().addAll(btnGenerator, btnEncryptDecrypt, btnExit);
    }

    public Scene getScene() {
        return new Scene(vbButtons);
    }
}
