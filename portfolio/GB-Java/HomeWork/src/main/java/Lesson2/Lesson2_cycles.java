package Lesson2;

public class Lesson2_cycles {
//1. Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах от 10 до 20
// (включительно), если да – вернуть true, в противном случае – false.
//            2. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в
//            консоль, положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
//            3. Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true,
//            если число отрицательное, и вернуть false если положительное.
//            4. Написать метод, которому в качестве аргументов передается строка и число, метод должен отпечатать
//            в консоль указанную строку, указанное количество раз;
//5. * Написать метод, который определяет, является ли год високосным, и возвращает boolean (високосный - true,
// не високосный - false). Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.

    public static boolean checkSum(int a, int b){
        return (((a + b) >= 10) && ((a + b) <= 20));
    }

    public static void printPosOrNeg (int a){
        if (a >= 0) {
            System.out.println("Число " + a + " положительное");
        }else{
            System.out.println("Число " + a + " отрицательное");
        }
    }

    public static boolean isPosOrNeg(int a){
        printPosOrNeg(a);//попробовал вызвать метод в методе
        return (a>=0);
    }

    public static void printString(String s, int i){
        for(;i>0;i--) System.out.println(s);//хотел сначала сделать через while, но с for получилось одной строкой.
                                            // Не существует же негласного правила что цикл всегда должен скобками обрамляться?
    }

    public static boolean isLeapYear(int year){

        return (((year % 400) == 0) || ((year % 4 == 0) && (year % 100 != 0))); //можно было через if, но захотел попробовать сложное выражение написать
    }
    public static void main(String[] args) {
        System.out.println(checkSum(5, 10));
        System.out.println(checkSum(15, 20));
        printPosOrNeg(0);
        printPosOrNeg(-5);
        System.out.println(isPosOrNeg(0));
        System.out.println(isPosOrNeg(-5));
        printString("Отпечатается 5 раз", 5);
        printString("Отпечатается 0 раз", 0);
        System.out.println(isLeapYear(1996));
        System.out.println(isLeapYear(1700));
        System.out.println(isLeapYear(2000));
    }
}
