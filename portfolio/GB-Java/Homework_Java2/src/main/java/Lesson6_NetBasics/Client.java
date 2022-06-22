package Lesson6_NetBasics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client{
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket client = new Socket("localhost", 8080);



        PrintWriter out = new PrintWriter(client.getOutputStream());

        System.out.println("Введите \"/quit\", чтобы выйти из чата.");

        Thread clientMsg = new Thread(() ->{
            String message = new Scanner(System.in).nextLine();
            while (!message.equals("/quit")) {
                System.out.println("Вы написали: \n" + message);
                out.println(message);
                out.flush();
                message = new Scanner(System.in).nextLine();
            }
        });

        Thread serverMsg = new Thread(() -> {
            String serverMessage = "";
            while (!serverMessage.equals("Сервер отключился")) {
                try {
                    BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    serverMessage = in.readLine();
                    System.out.println("Сообщение от сервера: \n" + serverMessage);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        clientMsg.start();
        serverMsg.setDaemon(true);
        serverMsg.start();
        clientMsg.join();
        out.println("Клиент отключился");
        out.flush();
        System.out.println("Завершение программы");

    }
}
