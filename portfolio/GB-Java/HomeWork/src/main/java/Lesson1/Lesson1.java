package Lesson1;

public class Lesson1 {


    public static void printThreeWords(){
        System.out.println("Orange\nBanana\nApple\n");
    }

    public static void checkSumSign (){
        int a = -55, b = 30;
        if ((a+b) >= 0){
            System.out.println("Сумма положительная");
        }else{
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor(){
        int value = 99;
        if (value <= 0){
            System.out.println("Красный");
        } else if (value <= 100){
            System.out.println("Желтый");
        } else{
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers(){
        int a = 30, b = 29;
        if (a >= b){
            System.out.println("a >= b");
        }else{
            System.out.println("a < b");
        }
    }

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

}
