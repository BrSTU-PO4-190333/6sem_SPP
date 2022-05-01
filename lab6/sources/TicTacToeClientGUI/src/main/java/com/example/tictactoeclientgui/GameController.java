package com.example.tictactoeclientgui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class GameController {
    @FXML protected Button button_1;
    @FXML protected Button button_2;
    @FXML protected Button button_3;
    @FXML protected Button button_4;
    @FXML protected Button button_5;
    @FXML protected Button button_6;
    @FXML protected Button button_7;
    @FXML protected Button button_8;
    @FXML protected Button button_9;

    @FXML protected void onButton1Click() {
        System.out.println("1");
        button_1.setDisable(true);
    }

    @FXML protected void onButton2Click() {
        System.out.println("2");
        button_2.setDisable(true);
    }

    @FXML protected void onButton3Click() {
        System.out.println("3");
        button_3.setDisable(true);
    }

    @FXML protected void onButton4Click() {
        System.out.println("4");
        button_4.setDisable(true);
    }

    @FXML protected void onButton5Click() {
        System.out.println("5");
        button_5.setDisable(true);
    }

    @FXML protected void onButton6Click() {
        System.out.println("6");
        button_6.setDisable(true);
    }

    @FXML protected void onButton7Click() {
        System.out.println("7");
        button_7.setDisable(true);
    }

    @FXML protected void onButton8Click() {
        System.out.println("8");
        button_8.setDisable(true);
    }

    @FXML protected void onButton9Click() {
        System.out.println("9");
        button_9.setDisable(true);
    }
}
