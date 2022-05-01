package com.example.tictactoeclientgui;

public class TicTacToeGame {
    // Перечисления состояний ячейки
    protected enum GameField {
        empty,  // Пустая яцейка
        o,      // Нолик
        x,      // Крестик
    };

    // Массив игрового поля
    protected GameField[] gameMap = {
        GameField.empty, GameField.empty, GameField.empty,
        GameField.empty, GameField.empty, GameField.empty,
        GameField.empty, GameField.empty, GameField.empty,
    };

    // Конструктор
    public TicTacToeGame() {
        reset(); // Обнуляем игровое поле
    }

    // Функция, которая заполняет яцейки пустатой
    protected void reset() {
        for (int i = 0; i < 9; ++i) {
            gameMap[i] = GameField.empty;
        }
    }

    // Функция, которая устанавливает крестик по id
    public void setX(int id) {
        if (id >= 9 || id < 0) {
            return;
        }
        if (gameMap[id] == GameField.empty) {
            gameMap[id] = GameField.x;
        }
    }

    // Функция, которая устанавливает нолик по id
    public void setO(int id) {
        if (id >= 9 || id < 0) {
            return;
        }
        if (gameMap[id] == GameField.empty) {
            gameMap[id] = GameField.o;
        }
    }

    // Функция, которая проверяет есть ли выигрыш (true) или нет (false)
    public boolean isWin() {
        // Если выиграли по горизонтали
        if (gameMap[0] != GameField.empty && gameMap[0] == gameMap[1] && gameMap[1] == gameMap[2]) {
            return true;
        }
        if (gameMap[3] != GameField.empty && gameMap[3] == gameMap[4] && gameMap[4] == gameMap[5]) {
            return true;
        }
        if (gameMap[6] != GameField.empty && gameMap[6] == gameMap[7] && gameMap[7] == gameMap[8]) {
            return true;
        }

        // Если выиграли по вертикали
        if (gameMap[0] != GameField.empty && gameMap[0] == gameMap[3] && gameMap[3] == gameMap[6]) {
            return true;
        }
        if (gameMap[1] != GameField.empty && gameMap[1] == gameMap[4] && gameMap[4] == gameMap[7]) {
            return true;
        }
        if (gameMap[2] != GameField.empty && gameMap[2] == gameMap[5] && gameMap[5] == gameMap[8]) {
            return true;
        }

        // Если выиграли по горизонтали
        if (gameMap[0] != GameField.empty && gameMap[0] == gameMap[4] && gameMap[4] == gameMap[8]) {
            return true;
        }
        if (gameMap[2] != GameField.empty && gameMap[2] == gameMap[4] && gameMap[4] == gameMap[6]) {
            return true;
        }

        // Если заполнены все ячейки
        if (gameMap[0] != GameField.empty && gameMap[1] != GameField.empty && gameMap[2] != GameField.empty
        && gameMap[3] != GameField.empty && gameMap[4] != GameField.empty && gameMap[5] != GameField.empty
        && gameMap[6] != GameField.empty && gameMap[7] != GameField.empty && gameMap[8] != GameField.empty) {
            return true;
        }

        // Если нет выигрыша
        return false;
    }

    // Функция, которая ходит крестиком рандомно
    public void randomX() {
        int count = 0;
        for (int i = 0; i < 9; ++i) {
            if (gameMap[i] != GameField.empty) {
                count += 1;
            }
        }

        if (count >= 8) {
            return;
        }

        int max = 8;
        int min = 0;
        int id;
        while(true) {
            id = (int) (Math.random() * ((max - min) + 1)) + min;
            if (gameMap[id] == GameField.empty) {
                setX(id);
                break;
            }
        }
    }

    // Функция, которая возвращает тип ячейки
    // -1 - ошибка
    // 0  - пустая ячейка
    // 1  - нолик
    // 2  - крестик
    public int getField(int id) {
        if (id >= 9 || id < 0) {
            return -1;
        }
        if (gameMap[id] == GameField.empty) {
            return 0;
        }
        if (gameMap[id] == GameField.o) {
            return 1;
        }
        if (gameMap[id] == GameField.x) {
            return 2;
        }
        return -1;
    }
}
