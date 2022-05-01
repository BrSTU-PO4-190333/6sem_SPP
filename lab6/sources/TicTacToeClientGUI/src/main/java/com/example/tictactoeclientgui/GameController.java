package com.example.tictactoeclientgui;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class GameController {
    TicTacToeGame game = new TicTacToeGame(); // Класс с игровой логикой

    // Кнопки
    @FXML protected Button button_0;
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

    // Функция, которая отрабатываем кнопку
    protected void onButtonClick(int id) {
        System.out.println("" + id);
        game.setO(id); // Ставим нолик
        game.randomX(); // Бот ставит крестик
        render(); // Перерисовываем игру
    }
    @FXML protected void onButton0Click() {onButtonClick(0);}
    @FXML protected void onButton1Click() {onButtonClick(1);}
    @FXML protected void onButton2Click() {onButtonClick(2);}
    @FXML protected void onButton3Click() {onButtonClick(3);}
    @FXML protected void onButton4Click() {onButtonClick(4);}
    @FXML protected void onButton5Click() {onButtonClick(5);}
    @FXML protected void onButton6Click() {onButtonClick(6);}
    @FXML protected void onButton7Click() {onButtonClick(7);}
    @FXML protected void onButton8Click() {onButtonClick(8);}

    // Функция, которая отрисовывает игру
    protected void render() {
        renderButton(button_0, 0);
        renderButton(button_1, 1);
        renderButton(button_2, 2);
        renderButton(button_3, 3);
        renderButton(button_4, 4);
        renderButton(button_5, 5);
        renderButton(button_6, 6);
        renderButton(button_7, 7);
        renderButton(button_8, 8);

        if (game.isWin() == true) {
            gameStatus.setText("Конец игры!");
        }
    }

    // Функция, которая отрисовывает кнопку
    protected void renderButton(Button button, int id) {
        // Если это пустая яцейка
        if (game.getField(id) == 0) {
            button.setText(".");
            button.setDisable(false);
            return;
        }

        // Если это нолик
        if (game.getField(id) == 1) {
            button.setText("o");
            button.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
            button.setTextFill(Color.WHITE);
            button.setDisable(true);
            return;
        }

        // Если это крестик
        if (game.getField(id) == 2) {
            button.setText("x");
            button.setBackground(new Background(new BackgroundFill(Color.PURPLE, CornerRadii.EMPTY, Insets.EMPTY)));
            button.setTextFill(Color.WHITE);
            button.setDisable(true);
            return;
        }

        return;
    }
}
