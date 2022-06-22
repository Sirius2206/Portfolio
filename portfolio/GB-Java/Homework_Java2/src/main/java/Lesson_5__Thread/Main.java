package Lesson_5__Thread;

import java.util.Arrays;

public class Main{
//    Отличие первого метода от второго:
//    Первый просто бежит по массиву и вычисляет значения (это видно из кода выше).
//    Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает эти массивы обратно в один.


    static final int SIZE = 30_000_000;
    public static void main(String[] args) throws InterruptedException {
        firstMethod();
        secondMethod();
        thirdMethod();

    }

    public static void firstMethod() {
        float[] arr = new float[SIZE];

        Arrays.fill(arr, 1.0f);
        long startTime = System.currentTimeMillis();
        System.out.println("Начинаем заполнение однопоточного массива.");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Однопоточная работа с массивом: " + (System.currentTimeMillis() - startTime) + " мс.");
    }

    public static void secondMethod() throws InterruptedException {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1.0f);
        long startTime = System.currentTimeMillis();
        System.out.println("Начинаем отсчет двухпоточного метода.");
        float[] arrFirstHalf = new float[SIZE/2];
        float[] arrSecondHalf = new float[SIZE/2];
        System.arraycopy(arr, 0, arrFirstHalf, 0, SIZE/2);
        System.arraycopy(arr, SIZE/2, arrSecondHalf, 0, SIZE/2);

        Thread thread1 = new Thread(() ->{
            System.out.println("Начало первого потока: " + (System.currentTimeMillis() - startTime));
            for (int i = 0; i < arrFirstHalf.length; i++) {
                arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.println("Начинаем слияние массивов в один(первый поток): " + (System.currentTimeMillis() - startTime));
            System.arraycopy(arrFirstHalf, 0, arr, 0, SIZE/2);
        });

        Thread thread2 = new Thread(() ->{
            System.out.println("Начало второго потока: " + (System.currentTimeMillis() - startTime));
            for (int i = 0; i < arrSecondHalf.length; i++) {
                arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.println("Начинаем слияние массивов в один(второй поток): " + (System.currentTimeMillis() - startTime));
            System.arraycopy(arrSecondHalf, 0, arr, SIZE/2, SIZE/2);
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("Двухпоточная работа с массивом: " + (System.currentTimeMillis() - startTime) + " мс.");

    }

    public static void thirdMethod() throws InterruptedException {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1.0f);
        long startTime = System.currentTimeMillis();
        System.out.println("Начинаем отсчет четырехпоточного метода.");
        float[] arrFirstQuarter = new float[SIZE/4];
        float[] arrSecondQuarter = new float[SIZE/4];
        float[] arrThirdQuarter = new float[SIZE/4];
        float[] arrForthQuarter = new float[SIZE/4];
        System.arraycopy(arr, 0, arrFirstQuarter, 0, SIZE/4);
        System.arraycopy(arr, SIZE/4, arrSecondQuarter, 0, SIZE/4);
        System.arraycopy(arr, SIZE/2, arrThirdQuarter, 0, SIZE/4);
        System.arraycopy(arr, SIZE - SIZE/4, arrForthQuarter, 0, SIZE/4);

        Thread thread1 = new Thread(() ->{
            System.out.println("Начало первого потока: " + (System.currentTimeMillis() - startTime));
            for (int i = 0; i < arrFirstQuarter.length; i++) {
                arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.println("Начинаем слияние массивов в один(первый поток): " + (System.currentTimeMillis() - startTime));
            System.arraycopy(arrFirstQuarter, 0, arr, 0, SIZE/4);
        });

        Thread thread2 = new Thread(() ->{
            System.out.println("Начало второго потока: " + (System.currentTimeMillis() - startTime));
            for (int i = 0; i < arrSecondQuarter.length; i++) {
                arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.println("Начинаем слияние массивов в один(второй поток): " + (System.currentTimeMillis() - startTime));
            System.arraycopy(arrSecondQuarter, 0, arr, SIZE/4, SIZE/4);
        });
        Thread thread3 = new Thread(() ->{
            System.out.println("Начало третьего потока: " + (System.currentTimeMillis() - startTime));
            for (int i = 0; i < arrThirdQuarter.length; i++) {
                arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.println("Начинаем слияние массивов в один(третий поток): " + (System.currentTimeMillis() - startTime));
            System.arraycopy(arrThirdQuarter, 0, arr, SIZE/2, SIZE/4);
        });
        Thread thread4 = new Thread(() ->{
            System.out.println("Начало четвертого потока: " + (System.currentTimeMillis() - startTime));
            for (int i = 0; i < arrForthQuarter.length; i++) {
                arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.println("Начинаем слияние массивов в один(четвертый поток): " + (System.currentTimeMillis() - startTime));
            System.arraycopy(arrForthQuarter, 0, arr, SIZE - SIZE/4, SIZE/4);
        });
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();

        System.out.println("Четырехпоточная работа с массивом: " + (System.currentTimeMillis() - startTime) + " мс.");

    }


}
