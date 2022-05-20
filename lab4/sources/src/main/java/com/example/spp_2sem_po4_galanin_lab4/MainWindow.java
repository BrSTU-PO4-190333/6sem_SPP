package com.example.spp_2sem_po4_galanin_lab4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainWindow extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainWindow.class.getResource("main-window-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Меню");
            stage.setScene(scene);
            stage.show();

            ReferenceBookNomenclatureWindowController.create_database();
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
