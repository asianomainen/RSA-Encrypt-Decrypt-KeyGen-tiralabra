package rsatoolapp.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RSAtoolUi extends Application {
    private final static int WIDTH = 960;
    private final static int HEIGHT = 720;

    @Override
    public void start(Stage stage) {
        MainMenuUi mainMenuUi = new MainMenuUi(WIDTH, HEIGHT);
        Scene mainMenuScene = mainMenuUi.getScene();

        mainMenuUi.btnExit.setOnAction(event -> stage.close());
        mainMenuUi.btnGenerate.setOnAction(event -> {
            mainMenuUi.publicKeyArea.setText("*public key goes here*");
            mainMenuUi.privateKeyArea.setText("*private key goes here*");
        });

        stage.setResizable(false);
        stage.setScene(mainMenuScene);
        stage.setTitle("RSA Tool");
        stage.show();
    }

    public static void main(String[] args) {
        launch(RSAtoolUi.class);
    }
}
