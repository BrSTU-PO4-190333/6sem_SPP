package com.example.tictactoeclientgui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class GameSocketController {
    TicTacToeGame game = new TicTacToeGame(); // Класс с игровой логикой

    // Кнопки
    @FXML
    protected Button button_0;
    @FXML protected Button button_1;
    @FXML protected Button button_2;
    @FXML protected Button button_3;
    @FXML protected Button button_4;
    @FXML protected Button button_5;
    @FXML protected Button button_6;
    @FXML protected Button button_7;
    @FXML protected Button button_8;

    // Сообщения игры
    @FXML protected Label gameStatus;
    @FXML protected TextField PlayerName;
    @FXML protected TextField ServerIP;
    @FXML protected TextField ServerPort;

    @FXML protected void onConnectClick() {}
    @FXML protected void onButton0Click() {}
    @FXML protected void onButton1Click() {}
    @FXML protected void onButton2Click() {}
    @FXML protected void onButton3Click() {}
    @FXML protected void onButton4Click() {}
    @FXML protected void onButton5Click() {}
    @FXML protected void onButton6Click() {}
    @FXML protected void onButton7Click() {}
    @FXML protected void onButton8Click() {}
}
