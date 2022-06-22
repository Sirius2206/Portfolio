package Lesson1;

import java.util.ArrayList;

public class Box <T extends Fruit> {
    private ArrayList<T> fruitBox;

    public Box () {
        this.fruitBox = new ArrayList<>();
    }

    public ArrayList<T> getBox() {
        return fruitBox;
    }

    public String getFruitName() {
        if (getBox().size() == 0) return "Пусто";
        return getBox().get(0).getClass().getName();
    }

    public double getWeight() {
        if (fruitBox.size() == 0) return 0;
        double sumWeight = fruitBox.get(0).getWeight() * fruitBox.size();
        sumWeight = (Math.round(sumWeight*100));
        sumWeight /=100;
        return sumWeight;
    }

    public void add (T fruit) {
        if (getBox().size() != 0){
            if (!getFruitName().equals(fruit.getClass().getName())){
                System.out.println("Этот фрукт нельзя сюда добавить");
                return;
            }
        }
        getBox().add(fruit);
    }

    public boolean compare (Box<T> anotherFruitBox) {
        return getWeight() == anotherFruitBox.getWeight();
    }

    public void pourOverTo (Box<T> anotherFruitBox) {
        if (anotherFruitBox.getBox().size() != 0) {
            if (!anotherFruitBox.getFruitName().equals(getFruitName())) {
                System.out.println("Не стоит смешивать фрукты.");
                return;
            }
        }
            anotherFruitBox.getBox().addAll(getBox());
            getBox().clear();
    }
}
