package rsatoolapp.ui;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RSAtoolUi extends Application {
    private final static int WIDTH = 960;
    private final static int HEIGHT = 720;
    public Button btnStart;
    public Label publicKeyLabel;
    public TextArea publicKeyArea;
    public Label privateKeyLabel;
    public TextArea privateKeyArea;
    public Button btnExit;
    public VBox vbButtons;
    public VBox VBoxPublic;
    public VBox VBoxPrivate;
    public GridPane grid;

    @Override
    public void start(Stage stage) {
        this.vbButtons = new VBox();
        this.vbButtons.setSpacing(20);
        this.vbButtons.setAlignment(Pos.CENTER);
        this.vbButtons.setPrefSize(WIDTH, HEIGHT);

        this.VBoxPublic = new VBox();
        this.VBoxPublic.setSpacing(20);
        this.VBoxPublic.setAlignment(Pos.CENTER);

        this.VBoxPrivate = new VBox();
        this.VBoxPrivate.setSpacing(20);
        this.VBoxPrivate.setAlignment(Pos.CENTER);

        this.grid = new GridPane();
        this.grid.setPadding(new Insets(20));
        this.grid.setHgap(50);
        this.grid.setVgap(5);
        this.grid.setPrefHeight(HEIGHT / 2);

        this.btnStart = new Button("Generate keys");
        this.btnStart.setStyle("-fx-font-size:40");

        this.publicKeyLabel = new Label("Public key");
        this.publicKeyLabel.setStyle("-fx-font-size:20");

        this.publicKeyArea = new TextArea("*public key goes here*");
        this.publicKeyArea.setEditable(false);
        this.publicKeyArea.setWrapText(true);
        this.publicKeyArea.setPrefSize(WIDTH - 100, HEIGHT - 200);

        this.privateKeyLabel = new Label("Private key");
        this.privateKeyLabel.setStyle("-fx-font-size:20");

        this.privateKeyArea = new TextArea("*private key goes here*");
        this.privateKeyArea.setEditable(false);
        this.privateKeyArea.setWrapText(true);
        this.privateKeyArea.setPrefSize(WIDTH - 100, HEIGHT - 200);

        this.btnExit = new Button("Exit");
        this.btnExit.setStyle("-fx-font-size:40");

        this.grid.add(publicKeyLabel, 0, 0);
        this.grid.add(publicKeyArea, 0, 1);
        this.grid.add(privateKeyLabel, 1, 0);
        this.grid.add(privateKeyArea, 1, 1);
        GridPane.setHalignment(publicKeyLabel, HPos.CENTER);
        GridPane.setHalignment(privateKeyLabel, HPos.CENTER);
        this.vbButtons.getChildren().addAll(this.btnStart, this.grid, this.btnExit);

        Scene mainMenuScene = new Scene(vbButtons);

        btnExit.setOnAction(event -> stage.close());

        stage.setResizable(false);
        stage.setScene(mainMenuScene);
        stage.setTitle("RSA Tool");
        stage.show();
    }

    public static void main(String[] args) {
        launch(RSAtoolUi.class);
    }
}
