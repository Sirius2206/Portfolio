package Lesson6;

import java.util.Random;

public class Cat extends Animal{
    private static int catCount = 0;
    private String name;
    private String[] catNames = {"Кошка", "Маруся", "Барсик", "Вездепух"};

    public Cat(String name){
        catCount++;
        this.name = name;
        System.out.println("кошка по имени " + this.name);
    }
    public Cat(){
        catCount++;
        Random randomName = new Random();
        this.name = catNames[randomName.nextInt(4)];
        System.out.println("кошка по имени " + this.name);
    }

    public String getName() {
        return name;
    }

    public static int getCatCount() {
        return catCount;
    }

    @Override
    public void swim(int distance) {
        System.out.println("О нет! " + name + " упал в воду. К счастью кота успели вытащить на берег.");
    }

    @Override
    public void run(int distance){
        System.out.println(name + " бежит...");
        if (distance <= 200) {
            System.out.println(name + " пробежал(а)" + distance + " метров. " + name + " прибежал(а).");
        }else {
            System.out.println("Коту надоело бегать. " + name + " пробежал(а) 200 метров, упал(а) и уснул(а).");
        }
    }
}
