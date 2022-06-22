package Lesson4;

import java.util.Random;
import java.util.Scanner;

public class Lesson4_minigame {
    public static final int SIZE = 3;
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static final char DOT_EMPTY = '*';
    public static final char[][] GAME_FIELD= new char[SIZE][SIZE];
    public static Scanner scan = new Scanner(System.in);

    public static void clearField(){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++){
                GAME_FIELD[i][j] = '*';
            }

        }
    }
    public static void playerTurn(){
        int x, y;
        do{
            System.out.println("Введите координаты одним числом в формате XY");
            int plTurn = scan.nextInt();
            x = (plTurn / 10) - 1;
            y = (plTurn % 10) - 1;
        }while (!isAvailable(x, y));
        GAME_FIELD[x][y] = DOT_X;
    }
    public static void aiTurn(){
        int x, y;
        Random random = new Random();
        do{
            x = random.nextInt(3);
            y = random.nextInt(3);
        }while (!isAvailable(x, y));
        GAME_FIELD[y][x] = DOT_O;
    }

    public static boolean isAvailable(int x, int y) {
        if ((x<0) || (y < 0) || (x > SIZE) || (y > SIZE)) return false;
        return GAME_FIELD[y][x] == DOT_EMPTY;
    }

    public static void printMap() {
        //печатаем шапку
        for (int i = 0; i <= SIZE; i++){
            if (i == 0) {
                System.out.print("   ");
                continue;
            }
            System.out.printf("%3d", i);
        }
        System.out.println();

        //печатаем поле
        for(int i = 0; i < SIZE; i++){
            System.out.printf("%3d", i+1);
            for (int j = 0; j < SIZE; j++){
                System.out.printf("%3c", GAME_FIELD[i][j]);
            }
            System.out.println();
        }

    }
    public static boolean isWin (char c){
        int checkWin = 0;
        for (int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                if (GAME_FIELD[i][j] == c) checkWin++;
            }
            if (checkWin == 3) return true;
            checkWin = 0;
        }
        for (int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                if (GAME_FIELD[j][i] == c) checkWin++;
            }
            if (checkWin == 3) return true;
            checkWin = 0;
        }
        for (int i = 0; i < SIZE; i++){
            if (GAME_FIELD[i][i] == c) checkWin++;
        }
        if (checkWin == 3) return true;
        checkWin = 0;

        for (int i = 0; i < SIZE; i++){
            if(GAME_FIELD[i][SIZE - 1 - i] == c) checkWin++;
        }
        return checkWin == 3;
    }
    public static boolean isPlayerWin(){
        if (isWin(DOT_X)){
            System.out.println("Игрок победил!");
            return true;
        }
        return false;
    }

    public static boolean isAiWin(){
        if (isWin(DOT_O)){
            System.out.println("Компьютер победил!");
            return true;
        }
        return false;
    }
    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (GAME_FIELD[i][j] == DOT_EMPTY) return false;
            }
        }
        System.out.println("Ничья.");
        return true;
    }

    public static void main(String[] args) {

        String anotherGame;
        clearField();
        printMap();

        do{
            while(true){
            playerTurn();
            printMap();
            if (isPlayerWin() || isMapFull()) break;
            aiTurn();
            printMap();
            if(isAiWin() || isMapFull()) break;
            }
            System.out.println("Еще раз? y/n");
            scan.nextLine();
            anotherGame = scan.nextLine();
            clearField();
            printMap();
        }while(anotherGame.equals("y"));
    }


}
