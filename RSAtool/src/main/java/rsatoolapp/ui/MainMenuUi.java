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
        this.vbButtons = new VBox();
        this.vbButtons.setSpacing(20);
        this.vbButtons.setAlignment(Pos.CENTER);
        this.vbButtons.setPrefSize(width, height);

        this.btnGenerator = new Button("RSA key generator");
        this.btnGenerator.setStyle("-fx-font-size:40");
        this.btnEncryptDecrypt = new Button("Encrypt/Decrypt message");
        this.btnEncryptDecrypt.setStyle("-fx-font-size:40");
        this.btnExit = new Button("Exit");
        this.btnExit.setStyle("-fx-font-size:40");

        this.vbButtons.getChildren().addAll(this.btnGenerator, this.btnEncryptDecrypt, this.btnExit);
    }

    public Scene getScene() {
        return new Scene(this.vbButtons);
    }
}
