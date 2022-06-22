package Lesson7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety = false;
    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public void eat(Plate p) {
        if (p.decreaseFood(appetite)) {
            System.out.println(name + " наелся и доволен жизнью.");
            satiety = true;
        }else{
            System.out.println("В тарелке недостаточно еды, чтобы утолить аппетиты " + this.name + ". Сейчас в тарелке " + p.info() + " еды.");
            satiety = false;
        }
    }

}
