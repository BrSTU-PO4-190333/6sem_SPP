package com.company;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    protected static int server_port = 1234;
    protected static ServerSocket server_socket;
    protected static Socket socket_1;
    protected static Socket socket_2;
    protected static DataInputStream data_input_stream_1;
    protected static DataInputStream data_input_stream_2;
    protected static String str_1;
    protected static String str_2;

    public static void main(String[] args) {

        try {
            server_socket = new ServerSocket(server_port); // Сокет для сервера. Указываем порт, ip не указываем.
            System.out.println("Socket server opened on port " + server_port); // Сообщение, что сервер открылся

            socket_1 = server_socket.accept(); // Ожидаем, что с сервером кто-то хочет соединиться
            System.out.println("Connected client #1");
            data_input_stream_1 = new DataInputStream(socket_1.getInputStream()); // Поток ввода примитивных типов

            socket_2 = server_socket.accept(); // Ожидаем, что с сервером кто-то хочет соединиться
            System.out.println("Connected client #2");
            data_input_stream_2 = new DataInputStream(socket_2.getInputStream()); // Поток ввода примитивных типов

            while(true) {
                try {
                    str_1 = data_input_stream_1.readUTF(); // Читаем как String в UTF8
                }
                catch (Exception e) {
                    System.out.println(e);
                    data_input_stream_1.close();
                    socket_1.close();
                    System.out.println("Disconnected client #1");
                    socket_1 = server_socket.accept(); // Ожидаем, что с сервером кто-то хочет соединиться
                    System.out.println("Connected client #1");
                    data_input_stream_1 = new DataInputStream(socket_1.getInputStream()); // Поток ввода примитивных типов
                    continue;
                }
                System.out.println("message = \"" + str_1 + "\""); // Выводим сообщение от клиента

                try {
                    str_2 = data_input_stream_2.readUTF(); // Читаем как String в UTF8
                }
                catch (Exception e) {
                    System.out.println(e);
                    data_input_stream_2.close();
                    socket_2.close();
                    System.out.println("Disconnected client #2");
                    socket_2 = server_socket.accept(); // Ожидаем, что с сервером кто-то хочет соединиться
                    System.out.println("Connected client #2");
                    data_input_stream_2 = new DataInputStream(socket_2.getInputStream()); // Поток ввода примитивных типов
                    continue;
                }
                System.out.println("message = \"" + str_2 + "\""); // Выводим сообщение от клиента
            }
            //server_socket.close(); // Закрываем сервер
        }
        catch (Exception e) {
            System.out.println(e);
            System.out.println("Server crached");
        }
    }
}
