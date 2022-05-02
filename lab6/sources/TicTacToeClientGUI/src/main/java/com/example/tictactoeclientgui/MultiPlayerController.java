package com.example.tictactoeclientgui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.DataOutputStream;
import java.net.Socket;

public class MultiPlayerController {
    protected TicTacToeGameClass game = new TicTacToeGameClass(); // Класс с игровой логикой
    protected Socket socket; // Сокет
    protected DataOutputStream data_output_stream; // Поток ввода примитивных типов
    protected String player_name; // Имя пользователя
    protected String server_ip; // IP адрес
    protected int server_port; // Порт сервера

    // Игровые кнопки
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

    // Настройки соединения к серверу
    @FXML protected TextField PlayerName;
    @FXML protected TextField ServerIP;
    @FXML protected TextField ServerPort;
    @FXML protected Button connect_button;

    // Функция, которая включает кнопки игры
    protected void enable_game_buttons() {
        button_0.setDisable(false);
        button_1.setDisable(false);
        button_2.setDisable(false);
        button_3.setDisable(false);
        button_4.setDisable(false);
        button_5.setDisable(false);
        button_6.setDisable(false);
        button_7.setDisable(false);
        button_8.setDisable(false);
    }

    // Функция, которая отключает текстовые поля и кнопку подключения
    protected void disable_connect_fields() {
        PlayerName.setDisable(true);
        ServerIP.setDisable(true);
        ServerPort.setDisable(true);
        connect_button.setDisable(true);
    }

    // Функция, которая отрабатывает, при нажатии кнопки присоединения
    @FXML protected void onConnectClick() {
        try {
            player_name = PlayerName.getText(); // Берём имя пользователя с текстового поля
            server_ip = ServerIP.getText(); // Берём ip адрес с текстового поля
            String server_port_string = ServerPort.getText(); // Берём порт с текстового поля
            try {
                server_port = Integer.parseInt(server_port_string); // Строка в число
            }
            catch(Exception e) {
                System.out.println(e);
                server_port = 1234;
            }
            socket = new Socket(server_ip, server_port); // Соединяемся с сервером по ip и порту
            enable_game_buttons(); // Разблокируем кнопки игры
            disable_connect_fields(); // Блокируем текстовые поля и кнопки присоединения к серверу
            data_output_stream = new DataOutputStream(socket.getOutputStream()); // Поток вывода примитивных типов
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    protected void shutdown() {
        try {
            System.out.println("Close multi player controller");
            data_output_stream.close(); // Закрываем поток вывода
            socket.close(); // Закрываем сокет соединение
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    // Функция, которая отправляет сообщение на сервер
    protected void send_message(String message) {
        try {
            data_output_stream.writeUTF(message); // Отправляем сообщение серверу
            data_output_stream.flush();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    // Кнопки, которые отправляют сообщение на сервер
    @FXML protected void onButton0Click() { send_message("0"); }
    @FXML protected void onButton1Click() { send_message("1"); }
    @FXML protected void onButton2Click() { send_message("2"); }
    @FXML protected void onButton3Click() { send_message("3"); }
    @FXML protected void onButton4Click() { send_message("4"); }
    @FXML protected void onButton5Click() { send_message("5"); }
    @FXML protected void onButton6Click() { send_message("6"); }
    @FXML protected void onButton7Click() { send_message("7"); }
    @FXML protected void onButton8Click() { send_message("8"); }
}
