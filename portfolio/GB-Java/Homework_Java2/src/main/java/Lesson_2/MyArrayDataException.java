package Lesson_2;

public class MyArrayDataException extends NumberFormatException{
    String message;
    int x, y;
    public MyArrayDataException(String message, int i, int j) {
        super(message);
        this.message = message;
    }

    public void printMessage(){
        System.out.println("Неверное значение в ячейке: "+ "x = " + (x+1) + ", y = " + (y+1));
    }
}