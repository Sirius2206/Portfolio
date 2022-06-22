package Lesson7;

public class Plate {
    private int food;
    public Plate(int food) {
        this.food = food;
    }
    public boolean decreaseFood(int n) {
        if (food - n >= 0) {
            food -= n;
            return true;
        }
        return false;
    }
    public int info() {
        return this.food;
    }
    public void addFood(int n){
        this.food += n;
        System.out.println("В тарелку добавлено " + n + " единиц корма. Теперь в тарелке " + this.food + " еды");

    }

}
