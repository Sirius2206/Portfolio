package Lesson_2;

public class MyArraySizeException extends IndexOutOfBoundsException {
    String message;
    public MyArraySizeException(String message) {
        super(message);
        this.message = message;

    }
    public void printMessage(){
        System.out.println(message);
    }
}