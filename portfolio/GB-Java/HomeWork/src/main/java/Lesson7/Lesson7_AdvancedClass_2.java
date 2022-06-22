package Lesson7;
//Расширить задачу про котов и тарелки с едой, выполнив следующие пункты:
//        Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например,
//        в миске 10 еды, а кот пытается покушать 15-20).
//        Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать
//        (хватило еды), сытость = true.
//        Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть наполовину
//        сыт (это сделано для упрощения логики программы).
//        Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести
//        информацию о сытости котов в консоль.
//        Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.




import java.util.Scanner;

public class Lesson7_AdvancedClass_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cat[] cats = {
                new Cat("Барсик", 15),
                new Cat("Маруся", 12),
                new Cat("Пушишка", 18),
                new Cat("Вездепух", 20),
                new Cat("Борька", 25),
                new Cat("Мурзик", 15)
        };
        Plate[] plates = {
                new Plate(10),
                new Plate(15),
                new Plate(20)};

        //Переменная для задачи с одной тарелкой
        Plate bigPlate = new Plate(50);

        for (Cat cat: cats){
            //Решение задачи с несколькими тарелками
            for(int plate = 0; plate < plates.length; plate++) System.out.printf("В %d-й тарелке осталось  %d eды.\n",
                    (plate + 1), plates[plate].info());
            System.out.printf("%s хочет %d еды. Из какой тарелки ему покушать?\n", cat.getName(), cat.getAppetite());
            int pl;
            do{
                pl = scanner.nextInt();
            } while (pl > 3 || pl < 1);

            do{
                cat.eat(plates[pl-1]);
                    if (cat.isSatiety())
                    {
                        System.out.printf("%s наелся из %d-й тарелки. Теперь в тарелке %d еды.\n\n", cat.getName(), pl, plates[pl-1].info());break;
                    }
                System.out.printf("Добавляем еду в %d-ю тарелку.\n", pl);
                    plates[pl-1].addFood(20);
            }while(!cat.isSatiety());


        //Решение задачи с одной тарелкой
//            do{
//                    System.out.printf("Котик хочет %d еды. Кот пробует поесть из тарелки.\n",cat.getAppetite());
//                    cat.eat(bigPlate);
//                    if (cat.isSatiety())
//                    {
//                        System.out.printf("%s наелся. Теперь в тарелке %d еды.\n\n", cat.getName(), bigPlate.info());break;
//                    }
//                    System.out.printf("Добавляем еду в тарелку.\n", bigPlate);
//                    bigPlate.addFood(20);
//
//                System.out.println();
//            }while (!cat.isSatiety());

        }
        for(int plate = 0; plate < plates.length; plate++) System.out.printf("В %d-й тарелке осталось  %d eды.\n",
                                                                            (plate + 1), plates[plate].info());

 //       System.out.printf("В тарелке осталось %d еды", bigPlate.info());
    }

}
