package rsatoolapp.ui;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class KeyGeneratorUi {
    public VBox vbButtons;
    public VBox vbPublic;
    public VBox vbPrivate;
    public GridPane grid;
    public Button btnGenerate;
    public Label publicKeyLabel;
    public TextArea publicKeyArea;
    public Label privateKeyLabel;
    public TextArea privateKeyArea;
    public Button btnBackToMainMenu;

    public KeyGeneratorUi(int width, int height) {
        vbButtons = new VBox();
        vbButtons.setPadding(new Insets(20, 20, 20, 20));
        vbButtons.setAlignment(Pos.CENTER);
        vbButtons.setPrefSize(width, height);

        vbPublic = new VBox();
        vbPublic.setSpacing(20);
        vbPublic.setAlignment(Pos.CENTER);

        vbPrivate = new VBox();
        vbPrivate.setAlignment(Pos.CENTER);

        grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(50);
        grid.setVgap(5);
        grid.setPrefHeight(height);
        grid.setAlignment(Pos.CENTER);

        btnGenerate = new Button("Generate keys");
        btnGenerate.setStyle("-fx-font-size:30");

        publicKeyLabel = new Label("Public key");
        publicKeyLabel.setStyle("-fx-font-size:20");

        publicKeyArea = new TextArea("");
        publicKeyArea.setEditable(false);
        publicKeyArea.setWrapText(true);
        publicKeyArea.setPrefSize(width - 50, 2000);

        privateKeyLabel = new Label("Private key");
        privateKeyLabel.setStyle("-fx-font-size:20");

        privateKeyArea = new TextArea("");
        privateKeyArea.setEditable(false);
        privateKeyArea.setWrapText(true);
        privateKeyArea.setPrefSize(width - 50, 2000);

        btnBackToMainMenu = new Button("Back to main menu");
        btnBackToMainMenu.setStyle("-fx-font-size:30");

        grid.add(publicKeyLabel, 0, 0);
        grid.add(publicKeyArea, 0, 1);
        grid.add(privateKeyLabel, 1, 0);
        grid.add(privateKeyArea, 1, 1);
        GridPane.setHalignment(publicKeyLabel, HPos.CENTER);
        GridPane.setHalignment(privateKeyLabel, HPos.CENTER);
        vbButtons.getChildren().addAll(btnGenerate, grid, btnBackToMainMenu);
    }

    public Scene getScene() {
        return new Scene(vbButtons);
    }
}
