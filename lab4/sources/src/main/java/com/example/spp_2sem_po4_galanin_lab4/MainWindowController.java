package com.example.spp_2sem_po4_galanin_lab4;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainWindowController {
    @FXML protected void button_reference_book_nomenclature_clicked() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainWindow.class.getResource("reference-book-nomenclature-window-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Справочник Номенклатура");
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
    }
}
