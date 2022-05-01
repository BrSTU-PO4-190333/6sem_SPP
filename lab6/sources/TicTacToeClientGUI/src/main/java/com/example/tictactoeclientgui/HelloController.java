package com.example.tictactoeclientgui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HelloController {
    @FXML protected Label status;

    @FXML protected void onSingleplayerClick() {
        status.setText("Старт одиночной игры (с ботом)...");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("game-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Одиночная игра (с ботом) | Крестики-нолики");
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML protected void onMultiplayerClick() {
        status.setText("Старт онлайн игры...");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("game-socket-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Сетевая игра | Крестики-нолики");
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML protected void onExitClick() {
        status.setText("Выходим...");
        System.exit(0);
    }
}