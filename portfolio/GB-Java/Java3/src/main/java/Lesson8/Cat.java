package Lesson8;

public class Cat {

    @BeforeSuite
    public static void getUp() {
        System.out.println("Котик проснулся");
    }

    @Test(value = 2)
    public static void eat() {
        System.out.println("Котик ест в первую очередь!");
    }

    @Test(value = 1)
    public static void meow() {
        System.out.println("КОтик просит есть.");
    }

    @Test
    public static void anotherMeow() {
        System.out.println("Котик наелся и благодарит");
    }

    @AfterSuite
    public static void sleep() {
        System.out.println("Котик ушел спать");
    }

    @Test(value = 10)
    public static void finalJump() {
        System.out.println("25-метровый прыжок!");
    }
}
