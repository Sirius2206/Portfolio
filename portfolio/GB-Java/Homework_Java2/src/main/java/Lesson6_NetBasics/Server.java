package Lesson6_NetBasics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Сервер подключен.");
        Socket socket = server.accept();
        System.out.println("Клиент подключился.");
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        System.out.println("Введите \"/quit\", чтобы выйти из чата.");

        Thread serverMsg = new Thread(() ->{
            String message = new Scanner(System.in).nextLine();
            while (!message.equals("/quit")) {
                System.out.println("Вы написали: \n" + message);
                out.println(message);
                out.flush();
                message = new Scanner(System.in).nextLine();
            }
        });

        Thread clientMsg = new Thread(() -> {
            String clientMessage = "";
            while (!clientMessage.equals("Клиент отключился")) {
                try {
                    clientMessage = in.readLine();
                    System.out.println("Сообщение от клиента: \n" + clientMessage);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        serverMsg.start();
        clientMsg.setDaemon(true);
        clientMsg.start();
        serverMsg.join();
        out.println("Сервер отключился");
        out.flush();
        System.out.println("Завершение программы");
    }
}
