package Lesson1;

public class BoxezAndFruits {
    public static void main(String[] args) {
        Box<Fruit> box1 = new Box<>();
        Box<Fruit> box2 = new Box<>();

        for (int i = 0; i < 5; i++){
            box1.add(new Apple());
        }

        System.out.println("В коробку номер один насыпали яблок.");
        System.out.println("Вес коробки №1: " + box1.getWeight());
        System.out.println("Попробуем добавить апельсин в первую коробку.");
        box1.add(new Orange());
        System.out.println("Попробуем добавить апельсин во вторую коробку.");
        box2.add(new Orange());
        System.out.println("Вес коробки №2 с одним апельсином: " + box2.getWeight());
        System.out.println("Пробуем пересыпать с первой во вторую коробку.");
        box1.pourOverTo(box2);
        box2.getBox().clear();
        System.out.println("Вес коробки №2 без ничего: " + box2.getWeight());
        System.out.println("Пробуем пересыпать с первой во вторую коробку еще раз.");
        box1.pourOverTo(box2);
        System.out.println("Вес коробки №1 после того как пересыпали все в коробку №2: " + box1.getWeight());
        System.out.println("Вес коробки №2: " + box2.getWeight());
        System.out.println("Попробуем еще раз добавить апельсин в 1 коробку.");
        box1.add(new Orange());
        System.out.println("Сравним вес коробок.");
        System.out.println("Вес коробки №1: " + box1.getWeight());
        System.out.println("Вес коробки №2: " + box2.getWeight());
        System.out.println(box1.compare(box2));
    }
}
