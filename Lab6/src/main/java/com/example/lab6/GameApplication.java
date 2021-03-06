package com.example.lab6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;


public class GameApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        Image icon = new Image("E:\\Codes\\AdvancedProgrammingLabs\\Lab6\\src\\main\\resources\\game-controller.png");
        FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 620);
        stage.setTitle("Positional Game!");
        stage.getIcons().add(icon);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}