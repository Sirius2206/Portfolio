package Lesson1;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayClass<T> {
    private T[] someArray;

    public ArrayClass(T... someArray) {
        this.someArray = someArray;
    }

    public void print() {
        for (int i = 0; i < someArray.length; i++) {
            System.out.print(someArray[i] + " ");
        }
        System.out.println();
    }

    public void swap(int i, int j) {
        if ((i > someArray.length) || (j > someArray.length) || (i < 0) || (j < 0)){
            System.out.println("Ошибка в индексе массива");
            return;
        }
        T c = someArray[i];
        someArray[i] = someArray[j];
        someArray[j] = c;
    }

    public ArrayList<T> arrToList(){
        ArrayList<T> list = new ArrayList<>();
        Collections.addAll(list, someArray);
        return list;
    }
}
