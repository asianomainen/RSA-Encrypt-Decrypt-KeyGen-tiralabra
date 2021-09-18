package rsatoolapp.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import rsatoolapp.domain.KeyGenerator;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class RSAtoolUi extends Application {
    private final static int WIDTH = 960;
    private final static int HEIGHT = 960;

    @Override
    public void start(Stage stage) throws NoSuchAlgorithmException, IOException, InvalidKeySpecException {
        MainMenuUi mainMenuUi = new MainMenuUi(WIDTH, HEIGHT);
        Scene mainMenuScene = mainMenuUi.getScene();
        KeyGenerator kg = new KeyGenerator();

        stage.setResizable(false);
        stage.setScene(mainMenuScene);
        stage.setTitle("RSA Tool");
        stage.show();

        mainMenuUi.btnExit.setOnAction(event -> stage.close());
        mainMenuUi.btnGenerate.setOnAction(event -> {
            try {
                kg.generateKeys();
            } catch (IOException | InvalidKeySpecException e) {
                e.printStackTrace();
            }
            mainMenuUi.publicKeyArea.setText(kg.getPublicKey());
            mainMenuUi.privateKeyArea.setText(kg.getPrivateKey());
        });
    }

    public static void main(String[] args) {
        launch(RSAtoolUi.class);
    }
}
