package Lesson3;
//Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].                    V
// С помощью цикла и условия заменить 0 на 1, 1 на 0;                                                                       V
//        Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;
//        Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
//        Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью
//        цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно).
//        Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны, то есть
//        [0][0], [1][1], [2][2], …, [n][n];
//        Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив типа
//        int длиной len, каждая ячейка которого равна initialValue;
//        * Задать одномерный массив и найти в нем минимальный и максимальный элементы ;
//        ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
//        если в массиве есть место, в котором сумма левой и правой части массива равны.
//        Примеры:
//        checkBalance([2, 2, 2, 1, 2, 2, ||| 10, 1]) → true, т.е. 2 + 2 + 2 + 1 + 2 + 2 = 10 + 1
//        checkBalance([1, 1, 1, ||| 2, 1]) → true, т.е. 1 + 1 + 1 = 2 + 1
//
//        граница показана символами |||, эти символы в массив не входят и не имеют никакого отношения к ИЛИ.
//
//
//        *** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или
//        отрицательным), при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично.
//        Для усложнения задачи нельзя пользоваться вспомогательными массивами. Примеры: [ 1, 2, 3 ] при n = 1 (на один
//        вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону
//        сдвиг можете выбирать сами.

import java.util.Arrays;
import java.util.Random;

public class Lesson3_arrays {
    public static void swapArray (){
        Random rand = new Random();
        int[] array = new int[rand.nextInt(10) + 10];

        //Заполняем массив числами 0 и 1
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(2);
        }
        System.out.println("Первоначальный массив: " + Arrays.toString(array));

        //Замена значений массива на противоположные
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                array[i] =0;
            }else{
                array[i] = 1;
            }
        }
        System.out.println("Модифицированный массив: " + Arrays.toString(array));
    }

    public static void arrayOfHundred(){
        int[] array = new int[100];

        //Заполняем массив значениями
        for(int i = 0; i < array.length; i++){
            if ((i % 25 == 0) && (i != 0)) System.out.println();
            array[i] = i + 1;
            System.out.print(array[i] + " ");
        }
        System.out.println();

    }
    public static void multiplyByTwo(){
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Первоначальный массив: " + Arrays.toString(array));

        for(int i = 0; i < array.length; i++){
            if(array[i] < 6) array[i] *= 2;
        }
        System.out.println("Модифицированный массив: " + Arrays.toString(array));
    }

    public static void equalDiagonals(){
        Random rand = new Random();
        int length = rand.nextInt(5)  + 5;
        int[][] array = new int[length][length];

        //Присваиваем единицы диагоналям
        for(int i = 0; i < array.length; i++){
            array[i][i] = 1;
            array[i][array.length -i - 1] = 1;
        }
        //Выводим полученный массив на экран
        for (int i = 0; i <= array.length; i++){
            System.out.printf("%2d", i);
        }
        System.out.println();

        for (int i = 0; i < array.length; i++){
            System.out.printf("%2d", i + 1);
            for (int j = 0; j < array[i].length; j++){
                System.out.printf("%2d", array[i][j]);
            }
            System.out.println();
        }

    }

    public static int[] createArray(int len, int initialValue){
        int[] array = new int[len];
        Arrays.fill(array, initialValue); //Idea подсказал метод для заполнения.
        return array;
    }
    public static void arrayMinMax(){
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Имеем массив: " + Arrays.toString(array));
        int min = array[0];
        int max = array[0];
        for (int j : array) {
            if (j < min) min = j;
            if (j > max) max = j;
        }
        System.out.println("Минимальный элемент в массиве равен " + min);
        System.out.println("Максимальный элемент в массиве равен " + max);
    }


    public static boolean checkBalance(int[] array){
        System.out.println("Получен массив: " + Arrays.toString(array));
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < array.length; i++){
            for (int k = i; k >= 0;k--){
                sum1 += array[k];
            }

            for(int j = array.length - 1; j > i; j--) {
                sum2 += array[j];
            }
            //Если нашлось место, в котором сумма левой и правой части массива равны, выводим его на экран.
            if (sum1 == sum2) {
                int pivot = i;
                if (i == 0) {
                    System.out.print(array[i] + " = ");
                }else {
                    for (i = 0; i <= pivot; i++) {
                        System.out.print(array[i]);
                        if (i != pivot) {
                            System.out.print(" + ");
                        }else System.out.print(" = ");
                    }
                }
                for(;pivot < array.length - 1; pivot++){
                    System.out.print(array[pivot + 1]);
                    if (pivot != array.length - 2) System.out.print(" + ");
                }
                System.out.println();
                return true;
            }
            sum1 = 0;
            sum2 = 0;
        }
        System.out.println("В полученном массиве отсутствует место, в котором сумма левой и правой части массива равны.");
        return false;

    }

    public static int[] moveArray(int[] array, int n){
        if (n == 0) return array;
        System.out.println("Получен массив: " + Arrays.toString(array));
        if (n > 0) {
            System.out.println("Необходимо подвинуть на " + n + " элемент(ов) вправо.");
            int i = 0;
            int swap = array[0];
                while (i+1 != array.length){
                    array[0] = array[i+1];
                    array[i+1] = swap;
                    swap = array[0];
                    i++;
                }
            System.out.println(Arrays.toString(array));
                moveArray(array,n - 1);
            }
        if (n < 0) {
            System.out.println("Необходимо подвинуть на " + -n + " элемент(ов) влево.");
            int i = array.length - 1;
            int swap = array[array.length - 1];
            while (i != 0){
                array[array.length - 1] = array[i-1];
                array[i-1] = swap;
                swap = array[array.length - 1];
                i--;
            }
            System.out.println(Arrays.toString(array));
            moveArray(array,n + 1);
        }
        return array;
    }
    public static void main(String[] args) {
        System.out.println("Задание №1");
        swapArray();
        System.out.println();
        System.out.println("Задание №2");
        arrayOfHundred();
        System.out.println();
        System.out.println("Задание №3");
        multiplyByTwo();
        System.out.println();
        System.out.println("Задание №4");
        equalDiagonals();
        System.out.println();
        System.out.println("Задание №5");
        System.out.println("Создаем одномерный массив длиной 5 с каждым элементом равным 7");
        System.out.println(Arrays.toString(createArray(5, 7)));
        System.out.println();
        System.out.println("Задание №*");
        arrayMinMax();
        System.out.println();
        System.out.println("Задание №**");
        int[] array1 = {1, 2, 3, 4, 5, 15};
        int[] array2 = {0, 0, 1, 2, 4, 25};
        int[] array3 = {1, 2, 3, 4, 5, 5, 4, 3, 2, 1};

        System.out.println(checkBalance(array1) + "\n");
        System.out.println(checkBalance(array2) + "\n");
        System.out.println(checkBalance(array3) + "\n");
        System.out.println("Задание №***");
        System.out.println("Модифицированный массив: " + Arrays.toString(moveArray(array1, 2)));
        System.out.println("Модифицированный массив: " + Arrays.toString(moveArray(array1, -3)));

    }
}
