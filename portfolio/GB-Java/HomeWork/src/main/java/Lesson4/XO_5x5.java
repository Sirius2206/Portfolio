package Lesson4;

import java.util.Random;
import java.util.Scanner;

public class XO_5x5 {
    public static final int SIZE = 5;
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


    //УЛУЧШИТЬ
    public static void aiTurn(){
        if (GAME_FIELD[2][2] == DOT_EMPTY) {
            System.out.println("Компьютер походил на " + 3 + 3);
            GAME_FIELD[2][2] = DOT_O; //если центр не занят, занимаем его в первый же ход
            return;
        }
          int[] perspMove = {0, 0}; // массив для перспективного хода, к концу метода в нем будет информация о ходе,
                                    // который совершит компьютер
          int[] tempMove;  // массив для информации о возможном ходе, если ход в нем лучше того что
                                    // хранится в perspMove, то в perspMove записывается новая информация.
          char[] checkArray = new char[SIZE]; //массив для передачи строки в метод поиска возможного хода
          char[] checkArrayDiag = new char[SIZE-1];// массив для передачи диагонали из 4х элементов

        //построчная проверка возможного хода
        for (int i = 0; i < SIZE; i++) {
            tempMove = checkMove(GAME_FIELD[i]);
            if (tempMove[0] > perspMove[0]) {
                perspMove[0] = tempMove[0];
                perspMove[1] = (i * 10) + tempMove[1]; //внимательно, возможна ошибка
            }
        }

        //постолбцовая проверка возможного хода
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++){
                checkArray[j] = GAME_FIELD[j][i];
            }
            tempMove = checkMove(checkArray);
            if (tempMove[0] > perspMove[0]) {
                perspMove[0] = tempMove[0];
                perspMove[1] = (tempMove[1] * 10) + i; //внимательно, возможна ошибка
            }
        }

        //проверка возможного хода по одной диагонали
        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < SIZE - k; i++) {
                if (k == 1) {
                    checkArrayDiag[i] = GAME_FIELD[i][i + k];
                } else {
                    checkArray[i] = GAME_FIELD[i][i + k];
                }

                if (k == 1) {
                    tempMove = checkMove(checkArrayDiag);
                    if (tempMove[0] > perspMove[0]) {
                        perspMove[0] = tempMove[0];
                        perspMove[1] = (tempMove[1] * 10) + (tempMove[1] + 1); //внимательно, возможна ошибка
                    }
                } else {
                    tempMove = checkMove(checkArray);
                    if (tempMove[0] > perspMove[0]) {
                        perspMove[0] = tempMove[0];
                        perspMove[1] = (tempMove[1] * 10) + tempMove[1]; //внимательно, возможна ошибка
                    }
                }
            }
              if (k == 1) {
                  for (int i = 0; i < SIZE - k; i++) {
                      checkArrayDiag[i] = GAME_FIELD[i + k][i];
                  }
                  tempMove = checkMove(checkArrayDiag);
                  if (tempMove[0] > perspMove[0]) {
                      perspMove[0] = tempMove[0];
                      perspMove[1] = ((tempMove[1] + 1) * 10) + tempMove[1]; //внимательно, возможна ошибка
              }
            }
        }

        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < SIZE - k; i++) {
                if (k == 1) {
                    checkArrayDiag[i] = GAME_FIELD[i][SIZE - 1 - i - k];
                } else {
                    checkArray[i] = GAME_FIELD[i][SIZE - 1 - i - k];
                }

                if (k == 1) {
                    tempMove = checkMove(checkArrayDiag);
                    if (tempMove[0] > perspMove[0]) {
                        perspMove[0] = tempMove[0];
                        perspMove[1] = (tempMove[1] * 10) + (SIZE - 2 - tempMove[1]); //внимательно, возможна ошибка
                    }
                } else {
                    tempMove = checkMove(checkArray);
                    if (tempMove[0] > perspMove[0]) {
                        perspMove[0] = tempMove[0];
                        perspMove[1] = (tempMove[1] * 10) + (SIZE - 1 - tempMove[1]); //внимательно, возможна ошибка
                    }
                }
            }

            //проверка возможного хода по второй диагонали
            if (k == 1) {
                for (int i = 0; i < SIZE - k; i++) {
                    checkArrayDiag[i] = GAME_FIELD[i + k][SIZE - 1 - i];
                    //проверка возможного хода по второй диагонали
                }
                tempMove = checkMove(checkArrayDiag);
                if (tempMove[0] > perspMove[0]) {
                    perspMove[0] = tempMove[0];
                    perspMove[1] = ((tempMove[1] + 1) * 10) + (SIZE - 1 - tempMove[1]); //внимательно, возможна ошибка
                }
            }
        }
        int x, y;
        if (perspMove[0] < 1) {
        Random random = new Random();
        do{
            x = random.nextInt(3);
            y = random.nextInt(3);
        }while (!isAvailable(x, y));
            System.out.println("Компьютер походил на " + (x + 1) + (y + 1));
        GAME_FIELD[x][y] = DOT_O;
        return;
        }
        x = perspMove[1] / 10;
        y = perspMove[1] % 10;
        System.out.println("Компьютер походил на " + (x + 1) + (y + 1));
        GAME_FIELD[x][y] = DOT_O;
    }

    public static int[] checkMove (char[] checkArray){
        int worth = 0;
        int countX = 0;
        int countO = 0;
        int countEmpty = 0;
        int size = checkArray.length;
        int[] resultArray = {0, 0}; //массив для возвращения информации о возможном ходе
        for (char c : checkArray) {
            if (c == DOT_X) {
                countX++;
                worth += 10;
            }
            if (c == DOT_O) countO++;
            if (c == DOT_EMPTY) countEmpty++;
        }

        if (countEmpty == 0 || countEmpty == SIZE) return resultArray; //Если нет пустых точек, то и ходить некуда. Если все пустые точки то нет возможности помешать игроку.

        for (int i = 0; i < size; i++) {
            if ((size != 4) && (i != 0) && (i != 4) && (countX > 0)) {
                if (checkArray[i] == DOT_O) {
                    resultArray[0] = -100; // если с 1 по 3 элемент присутствует 'O' то игрок на этой строке игру не закончит,
                                  // как и компьютер. Ищем более перспективный ход
                    return resultArray;
                }
            }
        }
        if (countX >= 2 && countO < 2) worth += 10;
        for (int i = 1; i < size - 1; i++) {
            if (checkArray[i] == DOT_EMPTY) {
                resultArray[0] = worth;
                resultArray [1] = i;
                return resultArray;
            }
            if (checkArray[0] == DOT_EMPTY){
                resultArray[0] = worth;
                resultArray [1] = 0;
                return resultArray;
            }
            if (checkArray[size - 1] == DOT_EMPTY){
                resultArray[0] = worth;
                resultArray [1] = size - 1;
                return resultArray;
            }
        }
        if (countX == 3) worth = 100;
        for (int i = 1; i < size - 1; i++) {
            if (checkArray[i] == DOT_EMPTY) {
                resultArray[0] = worth;
                resultArray [1] = i;
                return resultArray;
            }
            if (checkArray[0] == DOT_EMPTY){
                resultArray[0] = worth;
                resultArray [1] = 0;
                return resultArray;
            }
            if (checkArray[size - 1] == DOT_EMPTY){
                resultArray[0] = worth;
                resultArray [1] = size - 1;
                return resultArray;
            }
        }

            return resultArray;
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

    public static boolean isWin(char c) {
        int checkWin = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (GAME_FIELD[i][j] == c) checkWin++;
                if (GAME_FIELD[i][j] != c) checkWin = 0;
                if (checkWin == 4) return true;
            }

            checkWin = 0;
        }
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (GAME_FIELD[j][i] == c) checkWin++;
                if (GAME_FIELD[j][i] != c) checkWin = 0;
                if (checkWin == 4) return true;
            }
            checkWin = 0;
        }
        for (int k = 0; k < 2; k++) {

            for (int i = 0; i < SIZE - k; i++) {
                if (GAME_FIELD[i][i + k] == c) checkWin++;
                if (GAME_FIELD[i][i + k] != c) checkWin = 0;
                if (checkWin == 4) return true;
            }
            checkWin = 0;
            if (k == 1) {
                for (int i = 0; i < SIZE - k; i++) {
                    if (GAME_FIELD[i + k][i] == c) checkWin++;
                    if (GAME_FIELD[i + k][i] != c) checkWin = 0;
                    if (checkWin == 4) return true;
                }
            }
            checkWin = 0;
        }
        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < SIZE - k; i++) {
                    if (GAME_FIELD[i][SIZE - 1 - i - k] == c) checkWin++;
                if (GAME_FIELD[i][SIZE - 1 - i - k] != c) checkWin = 0;
                if (checkWin == 4) return true;
            }
            checkWin = 0;

            if (k == 1) {
                for (int i = 0; i < SIZE - k; i++) {
                    if(i == 4) continue;
                    if (GAME_FIELD[i + k][SIZE - 1 - i] == c) checkWin++;
                    if (GAME_FIELD[i + k][SIZE - 1 - i] != c) checkWin = 0;
                    if (checkWin == 4) return true;
                }
            }
        }
        return false;
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
