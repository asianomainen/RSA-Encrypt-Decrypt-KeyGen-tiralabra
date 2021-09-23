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
    public ToolBar toolBar;
    public Button btnGenerate;
    public Label publicKeyLabel;
    public TextArea publicKeyArea;
    public Label privateKeyLabel;
    public TextArea privateKeyArea;
    public Button btnBackToMainMenu;

    public KeyGeneratorUi(int width, int height) {
        this.vbButtons = new VBox();
        this.vbButtons.setPadding(new Insets(20, 20, 20, 20));
        this.vbButtons.setAlignment(Pos.CENTER);
        this.vbButtons.setPrefSize(width, height);

        this.vbPublic = new VBox();
        this.vbPublic.setSpacing(20);
        this.vbPublic.setAlignment(Pos.CENTER);

        this.vbPrivate = new VBox();
        this.vbPrivate.setAlignment(Pos.CENTER);

        this.grid = new GridPane();
        this.grid.setPadding(new Insets(20));
        this.grid.setHgap(50);
        this.grid.setVgap(5);
        this.grid.setPrefHeight(height);
        this.grid.setAlignment(Pos.CENTER);

        this.btnGenerate = new Button("Generate keys");
        this.btnGenerate.setStyle("-fx-font-size:30");

        this.toolBar = new ToolBar();
        this.toolBar.getItems().add(btnGenerate);

        this.publicKeyLabel = new Label("Public key");
        this.publicKeyLabel.setStyle("-fx-font-size:20");

        this.publicKeyArea = new TextArea("");
        this.publicKeyArea.setEditable(false);
        this.publicKeyArea.setWrapText(true);
        this.publicKeyArea.setPrefSize(width - 50, 1080);

        this.privateKeyLabel = new Label("Private key");
        this.privateKeyLabel.setStyle("-fx-font-size:20");

        this.privateKeyArea = new TextArea("");
        this.privateKeyArea.setEditable(false);
        this.privateKeyArea.setWrapText(true);
        this.privateKeyArea.setPrefSize(width - 50, 1080);

        this.btnBackToMainMenu = new Button("Back to main menu");
        this.btnBackToMainMenu.setStyle("-fx-font-size:30");

        this.grid.add(publicKeyLabel, 0, 0);
        this.grid.add(publicKeyArea, 0, 1);
        this.grid.add(privateKeyLabel, 1, 0);
        this.grid.add(privateKeyArea, 1, 1);
        GridPane.setHalignment(publicKeyLabel, HPos.CENTER);
        GridPane.setHalignment(privateKeyLabel, HPos.CENTER);
        this.vbButtons.getChildren().addAll(this.btnGenerate, this.grid, this.btnBackToMainMenu);
    }

    public Scene getScene() {
        return new Scene(this.vbButtons);
    }
}
