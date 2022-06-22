package Lesson1;
//Написать метод, который меняет два элемента массива местами
//(массив может быть любог оссылочного типа)

//Написать метод, который преобразует массив в ArrayList.

//Задача: Даны классы Fruit, Apple extends Fruit, Orange extends Fruit; V
//        Класс Box, в который можно складывать фрукты. Коробки условно
//        сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки и апельсины.
//        Для хранения фруктов внутри коробки можно использовать ArrayList.  V
//        Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и
//        их количество.
//        Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той,
//        которую подадут в compare() в качестве параметра. Можно сравнивать коробки с разными фруктами.
//        Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую (перекидываются все фрукты)

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayClass<Integer> intArr = new ArrayClass<>(1, 2, 3, 5, 4);
        ArrayClass<String> strArr = new ArrayClass<>("a", "b", "e", "d", "c");
        intArr.print();
        strArr.print();
        intArr.swap(3, 4);
        strArr.swap(2, 4);
        intArr.print();
        strArr.print();
        intArr.swap(10, 0);
        strArr.swap(-1, 2);

        ArrayList<Integer> intList = intArr.arrToList();
        ArrayList<String> strList = strArr.arrToList();
        System.out.println(strList.toString());
        System.out.println(intList.toString());
    }

}
