package Lesson_1;

//Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса. Эти классы должны уметь бегать и
// прыгать (методы просто выводят информацию о действии в консоль).
//        Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники должны выполнять
//        соответствующие действия (бежать или прыгать), результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
//        Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.
//        * У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки.
//        Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.

public class MainClass {

    public static void main(String[] args) {

        Participant[] participants = {
                new Cat("Борис", 600, 2),
                new Human("Аркадий", 500, 4),
                new Robot("BD-m2", 1000, 1)};

        Obstacle[] obstacles = {
                new RunningTrack(200),
                new JumpingWall(1),
                new JumpingWall(2),
                new RunningTrack(301)};


        System.out.println("Участники вышли на полосу препятствий и разминаются.");
        for (Participant participant : participants) {
            participant.running();
            participant.jumping();
            System.out.println();
        }

        System.out.println("Соревнования начинаются!");
        for (Participant participant : participants) {
            for (Obstacle obstacle : obstacles) {
                participant.overcome(obstacle);
                if (!participant.isSuccess()) {
                    System.out.println(participant.getName() + " выбывает из соревнований");
                    break;
                }
                System.out.println();
            }
        }

        for (Participant participant : participants) {
            if (participant.isSuccess()) System.out.println(participant.getName() + " преодолел все препятствия!");
        }
    }

}
