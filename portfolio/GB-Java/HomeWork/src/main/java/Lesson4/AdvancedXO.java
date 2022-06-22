package Lesson4;

import java.util.Random;
import java.util.Scanner;

public class AdvancedXO {
    public static final int SIZE = 3;
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static final char DOT_EMPTY = '*';
    public static final char[][] GAME_FIELD= new char[SIZE][SIZE];
    public static Scanner scan = new Scanner(System.in);
    public static final int[] goodMove ={00, 02, 11, 20, 22}; //массив с самыми предпочтительными точками ходов.

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

    public static int[] checkGoodMove(char c) {
        int[] ret = new int[2];
        int multiplier = 10;
        int worth = 0; // переменная для определения "ценности" хода
        if (c == 'X') multiplier = 1;
        int x = 0, y = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (GAME_FIELD[i][j] == c) worth += multiplier;
                if (GAME_FIELD[i][j] != c && GAME_FIELD[i][j] != DOT_EMPTY) worth -= 50;
                if (GAME_FIELD[i][j] == DOT_EMPTY) {
                    worth += 3;
                    x = i;
                    y = j;
                }
                //worth принимает значение 5, когда в строке 2 'X' и 1 '*'; и 23 когда в строке 2 'O' и 1 '*'
                if ((worth == 5) || (worth == 23)) {
                    ret[0] = ((x * 10) + y);
                    ret[1] = worth;
                    return ret;
                }

            }
            worth = 0;
            x = 0;
            y = 0;
        }
        worth = 0;
        x = 0;
        y = 0;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (GAME_FIELD[j][i] == c) worth += multiplier;
                if (GAME_FIELD[j][i] != c && GAME_FIELD[j][i] != DOT_EMPTY) worth -= 50;
                if (GAME_FIELD[j][i] == DOT_EMPTY) {
                    worth += 3;
                    x = j;
                    y = i;
                }
                if ((worth == 5) || (worth == 23)) {
                    ret[0] = ((x * 10) + y);
                    ret[1] = worth;
                    return ret;
                }
            }
            worth = 0;
            x = 0;
            y = 0;
        }
        worth = 0;
        x = 0;
        y = 0;

        for (int i = 0; i < SIZE; i++) {
            if (GAME_FIELD[i][i] == c) worth += multiplier;
            if (GAME_FIELD[i][i] != c && GAME_FIELD[i][i] != DOT_EMPTY) worth -= 50;
            if (GAME_FIELD[i][i] == DOT_EMPTY) {
                worth += 3;
                x = i;
                y = i;
            }
            if ((worth == 5) || (worth == 23)) {
                ret[0] = ((x * 10) + y);
                ret[1] = worth;
                return ret;
            }
        }
        worth = 0;
        x = 0;
        y = 0;

        for (int i = 0; i < SIZE; i++) {
            if (GAME_FIELD[i][SIZE - 1 - i] == c) worth += multiplier;
            if (GAME_FIELD[i][SIZE - 1 - i] != c && GAME_FIELD[i][SIZE - 1 - i] != DOT_EMPTY) worth -= 50;
            if (GAME_FIELD[i][SIZE - 1 - i] == DOT_EMPTY) {
                worth += 3;
                x = i;
                y = SIZE - 1 - i;
            }
            if ((worth == 5) || (worth == 23)) {
                ret[0] = ((x * 10) + y);
                ret[1] = worth;
                return ret;
            }
        }
        return ret;
    }

    public static void aiTurn() {
        int[] moveX = checkGoodMove(DOT_X);
        int[] moveO = checkGoodMove(DOT_O);
        if (moveO[1] > moveX[1]){
            GAME_FIELD[moveO[0]/10][moveO[0]%10] = DOT_O;
            System.out.println("Компьютер походил на " + (moveO[0]/10 + 1) + (moveO[0]%10  + 1));
            return;
        }
        if (moveO[1] < moveX[1]){
            GAME_FIELD[moveX[0]/10][moveX[0]%10] = DOT_O;
            System.out.println("Компьютер походил на " + (moveO[0]/10 + 1) + (moveO[0]%10  + 1));
            return;
        }
            //Если нет предвыигрышного хода или возможности помешать игроку, ходим на одну из перспективных точек
            for (int i : goodMove) {
                if (GAME_FIELD[i / 10][i % 10] == DOT_EMPTY) {
                    GAME_FIELD[i / 10][i % 10] = DOT_O;
                    System.out.println("Компьютер походил на " + (i / 10 + 1) + (i % 10 + 1));
                    return;
                }
            }

            // Если ценного хода на данный момент нет, то ставим случайную точку,
            // до сюда скорее всего программа не дойдет, но на всякий случай оставим.
        int x;
        int y;
        Random random = new Random();
        do {
            x = random.nextInt(3);
            y = random.nextInt(3);
        } while (!isAvailable(x, y));
        GAME_FIELD[x][y] = DOT_O;
        }

    public static boolean isAvailable(int x, int y) {
        if ((x<0) || (y < 0) || (x > SIZE) || (y > SIZE)) return false;
        return GAME_FIELD[x][y] == DOT_EMPTY;
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
                System.out.printf("%3c", GAME_FIELD[j][i]);
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
