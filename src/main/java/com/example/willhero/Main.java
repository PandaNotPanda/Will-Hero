package com.example.willhero;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Main extends Application implements Serializable {
    @Override
    public void start(Stage stage) throws Exception {
        Game newgame = new Game();

        try{
            FileOutputStream fos = new FileOutputStream("WasteWalaSaveGame.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(newgame);
            oos.close();
            fos.close();
            System.out.println("Serialized");
        }
        catch (IOException e){
            System.out.println("IOException ho gaya");
        }

        newgame.start(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}
