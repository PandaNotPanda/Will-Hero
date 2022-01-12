package com.example.willhero;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Game extends Application implements Serializable {

    Helmet hero;
    transient boolean revived;
    public ArrayList<GameObjects> gameObjects;
    public ArrayList<Coins> coins;
    public ArrayList<Chests> chests;
    public ArrayList<Orcs> orcs;


    transient Scene scene;
    transient Stage stage;

    public Game() throws IOException {
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Welcome.fxml"));
        AnchorPane root = loader.load();
        GameController controller = loader.getController();
        scene = new Scene(root);
        stage.setResizable(false);
        stage.setOnCloseRequest(event -> {
            event.consume();
            exit(stage);
        });

        stage.setTitle("Will Hero");
        stage.setScene(scene);
        stage.show();
        stage.getIcons().add(new Image(this.getClass().getResource("helmet.png").toString()));
    }

    public void exit(Stage stage){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit Game");
        alert.setHeaderText("Do you wish to exit the game?");
        alert.setContentText("Unsaved Data will be lost. Remember to save before exiting.");
        alert.setGraphic(new ImageView(this.getClass().getResource("helmet_smol.png").toString()));
        Stage stg = (Stage) alert.getDialogPane().getScene().getWindow();
        stg.getIcons().add(new Image(this.getClass().getResource("helmet.png").toString()));

        if (alert.showAndWait().get() == ButtonType.OK){
            System.out.println("Closed");
            stage.close();
        }

    }
}