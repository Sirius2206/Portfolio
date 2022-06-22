package Lesson6;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Lesson6_AdvancedClasses {
//    Создать классы Собака и Кот с наследованием от класса Животное.
//    Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
//    Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
//    У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать,
//    собака 10 м.).
//            * Добавить подсчет созданных котов, собак и животных.
    public static void activities(Dog[] dogs, Cat[] cats){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int catsCount = cats.length;
        int dogsCount = dogs.length;
        int count = dogs.length + cats.length;
        for (int i = 0; i < count; i ++){
            if (catsCount > 0) {
                catActivity(cats[random.nextInt(cats.length)]);
                catsCount--;
                System.out.println("Хорошо. Как там остальные?");
                scanner.nextLine();

            }
            if (dogsCount > 0) {
                dogActivity(dogs[random.nextInt(dogs.length)]);
                dogsCount--;
                System.out.println("Хорошо. Как там остальные?");
                scanner.nextLine();
            }
        }
        System.out.println("Ну что ж. Прогулку пора заканчивать.");
    }
    public static void catActivity (Animal cat){
        Random random = new Random();
        if (random.nextInt(2) == 0){
            System.out.println("Кажется " + cat.getName() + " хочет побегать.");
            cat.run(random.nextInt(400));
            return;
        }
        System.out.println(cat.getName() + " не смотрит куда бежит.");
        cat.swim(random.nextInt(500));
    }
    public static void dogActivity (Animal dog){
        Random random = new Random();
        if (random.nextInt(2) == 0){
            System.out.println("Кажется " + dog.getName() + " хочет побегать.");
            dog.run(random.nextInt(1000));
            return;
        }
        System.out.println("Кажется " + dog.getName() + " хочет поплавать.");
        dog.swim(random.nextInt(20));
    }
    public static void main(String[] args) {
        int catCount;
        int dogCount;
        Cat[] cats = new Cat[0];
        Dog[] dogs = new Dog[0];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Мы и наш зверинец выходим на прогулку. Сколько возьмем кошек?");
        catCount = scanner.nextInt();
        System.out.println("А собак?");
        dogCount = scanner.nextInt();

        if (catCount > 0){
            cats = new Cat[catCount];
            for (int i = 0; i < catCount;i++) {
            System.out.println("Как назовем " + (i + 1) + "-го котика?(Введите \"нет\", чтобы компьютер дал животному кличку)");
            String catName = scanner.next();
                if (catName.toLowerCase(Locale.ROOT).equals("нет")) {
                    cats[i] = new Cat();
                } else {
                cats[i] = new Cat(catName);
                }
            }
        }
        if (dogCount > 0) {
            dogs = new Dog[dogCount];
            for (int i = 0; i < dogCount;i++) {
                System.out.println("Как назовем " + (i + 1) + "-го песика?(Введите \"нет\", чтобы компьютер дал животному кличку)");
                String catName = scanner.next();
                if (catName.toLowerCase(Locale.ROOT).equals("нет")) {
                    dogs[i] = new Dog();
                } else {
                    dogs[i] = new Dog(catName);
                }
            }
        }
        activities(dogs, cats);


        System.out.println("Прогулка закончена");
        System.out.println("Всего имеем " + Animal.getAnimalCount() + " животных.");
        System.out.println("Из них " + Cat.getCatCount() + " это кошки.");
        System.out.println("А также " + Dog.getDogCount() + " это собаки");
    }
}
