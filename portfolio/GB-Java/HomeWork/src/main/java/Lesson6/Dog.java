package Lesson6;

import java.util.Random;

public class Dog extends Animal{
    private static int dogCount = 0;
    private String name;
    private String[] dogNames = {"Бобик", "Лайка", "Мухтар", "Пабло"};

    public Dog(String name){
        dogCount++;
        this.name = name;
        System.out.println("собачка. А собачку зовут " + this.name);
    }

    public Dog(){
        dogCount++;
        Random randomName = new Random();
        this.name = dogNames[randomName.nextInt(4)];
        System.out.println("собачка. А собачку зовут " + this.name);

    }
    public String getName() {
        return name;
    }

    public static int getDogCount() {
        return dogCount;
    }

    @Override
    public void swim(int distance){
        System.out.println(name + " плывет...");
        if (distance <= 10) {
            System.out.println(name + " проплыл(а)" + distance + " метров. " + name + " приплыл(а).");
        }else {
            System.out.println(name + " проплыл(а) 10 метров. " + name + " устал(а).");
        }
    }

    @Override
    public void run(int distance){
        System.out.println(name + " бежит...");
        if (distance <= 500) {
            System.out.println(name + " пробежал(а)" + distance + " метров. " + name + " прибежал(а).");
        }else {
            System.out.println(name + " пробежал(а) 500 метров. Пес мог бы пробежать еще столько же, но не хочет сильно " +
                    "отдаляться от хозяина.");
        }

    }
}
