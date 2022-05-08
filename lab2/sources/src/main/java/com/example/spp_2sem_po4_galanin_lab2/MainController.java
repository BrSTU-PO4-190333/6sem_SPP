package com.example.spp_2sem_po4_galanin_lab2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainController {
    @FXML protected TextField text_field_n; // До какой итерации считать сумму
    @FXML protected TextField text_field_sum; // Результат (сумма)
    @FXML protected TextField text_field_status; // Статус таски
    @FXML protected Button button_start;
    @FXML protected Button button_pause;
    @FXML protected Button button_resume;
    @FXML protected Button button_stop;
    protected Thread thread; // Поток
    protected CalcTask task; // Таска

    // Функция, которая начитает вычислять сумму
    @FXML protected void onButtonStartClick() {
        button_start.setDisable(true);
        button_pause.setDisable(false);
        button_resume.setDisable(true);
        button_stop.setDisable(false);

        // Получаем число итераций суммы из текстового поля
        int n = 0;
        try {
            n = Integer.parseInt(text_field_n.getText());
        }
        catch(Exception e) {
            System.out.println(e);
        }

        // Создаем таску
        task = new CalcTask(n);

        // Соединяем текстовое поле с таской
        // В текстовое поле будут выводиться сообщения
        text_field_status.textProperty().bind(task.messageProperty());

        // Функция, при старте таски
        task.setOnRunning((succeesesEvent) -> {
            button_start.setDisable(true);
            text_field_sum.setText("");
        });

        // Функция, при завершении таски
        task.setOnSucceeded((succeesesEvent) -> {
            text_field_sum.setText(task.getValue().toString());
            button_start.setDisable(false);
        });

        // Создаём поток из таски
        thread = new Thread(task);

        // Стартуем поток
        thread.start();
    }

    // Функция, которая ставит вычисление на паузу
    @FXML protected void onButtonPauseClick() {
        button_start.setDisable(true);
        button_pause.setDisable(true);
        button_resume.setDisable(false);
        button_stop.setDisable(false);
        task.isPause = true;
    }

    // Функция, которая продолжает вычисление после паузы
    @FXML protected void onButtonResumeClick() {
        button_start.setDisable(true);
        button_pause.setDisable(false);
        button_resume.setDisable(true);
        button_stop.setDisable(false);
        task.isPause = false;
    }

    // Функция, которая завершает поток вычисления суммы
    @FXML protected void onButtonStopClick() {
        button_start.setDisable(false);
        button_pause.setDisable(true);
        button_resume.setDisable(true);
        button_stop.setDisable(true);
        thread.stop();
    }
}