package com.example.spp_2sem_po4_galanin_lab2;

import javafx.concurrent.Task;

public class CalcTask extends Task<Double> {
    protected int n; // Сумма от 1 до n
    public boolean isPause = false; // Вычисление на паузе или нет?

    // Конструктор, который указывает число n
    public CalcTask(int n) {
        this.n = n;
    }

    // Функция, которая считает один элемент a_i
    protected double calculate_a(int i) {
        return (double) 1 / ((2 * i - 1) * (2 * i + 1));
    }

    // Функция, которая считает сумму
    protected double calculate_sum(int n) {
        double sum = 0;
        int i = 1;
        while (true) {
            if (isPause == true) { // Задача на паузе?
                continue;
            }

            sum += calculate_a(i);

            // Выводим результат в сообщение таски.
            // Сообщение таски будет выводить в TextEdit как статус бару
            String str = String.format("On i = %-8d ==> sum = %12.4f", i, sum);
            updateMessage(str);

            // Спис 10 милисекунд, чтобы поток не выполнялся очень быстро
            sleep(10);

            if (i < n == false) { // Дошли до последнего элемента суммы?
                break;
            }

            i += 1;
        }
        return sum;
    }

    // Функция, которая спит время time
    protected void sleep(int time) {
        try {
            Thread.sleep(time);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    // Функция, которая возвращает результат суммы после выполнения таски
    @Override
    protected Double call() throws Exception {
        double result = calculate_sum(n);
        return result;
    }
}
