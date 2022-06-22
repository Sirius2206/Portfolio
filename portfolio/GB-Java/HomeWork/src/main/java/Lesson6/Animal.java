package Lesson6;

public  class Animal {
    private String name;
    private static int animalCount = 0;

    public Animal (){
        animalCount++;
        this.name = "животное";
        System.out.print("И вот выходит ");
    }

    public static int getAnimalCount() {
        return animalCount;
    }

    public String getName() {
        return name;
    }

    public void swim(int distance){

    }
    public void run(int distance){

    }
}
