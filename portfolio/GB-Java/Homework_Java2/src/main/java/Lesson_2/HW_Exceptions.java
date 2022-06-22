package Lesson_2;

//Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При подаче массива другого размера
// необходимо бросить исключение MyArraySizeException.
//        Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать. Если в каком-то
//        элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа), должно
//        быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
//        В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и
//        MyArrayDataException и вывести результат расчета (сумму элементов, при условии что подали на вход корректный массив).
//        Заметка: Для преобразования строки к числу используйте статический метод класса Integer:
//        Integer.parseInt(сюда_подать_строку);
//        Заметка: Если Java не сможет преобразовать входную строку (в строке число криво написано), то будет
//        сгенерировано исключение NumberFormatException.


public class HW_Exceptions {
    public static void main(String[] args){
        String[][] arrayData = new String[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                arrayData[i][j] = "1";
            }
        }
        arrayData[1][1] ="s";

        String[][] arraySize = new String[4][3];
        String[][] arrayCorrect = new String[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                arrayCorrect[i][j] = "1";
            }
        }
        try {
            System.out.println("Получен первый массив(неверное значение)");
            arraySum(arrayData);
        } catch (MyArraySizeException e) {
            System.out.println("Словлена ошибка о неверном размере массива.");
            e.printStackTrace();
            e.printMessage();
        } catch (MyArrayDataException e) {
            System.out.println("Словлена ошибка о неверном значении внутри массива");
            e.printStackTrace();
            e.printMessage();
        }

        try {
            System.out.println("Получен второй массив(неверный размер)");
            arraySum(arraySize);
        } catch (MyArraySizeException e) {
            System.out.println("Словлена ошибка о неверном размере массива.");
            e.printStackTrace();
            e.printMessage();
        } catch (MyArrayDataException e) {
            System.out.println("Словлена ошибка о неверном значении внутри массива");
            e.printStackTrace();
            e.printMessage();
        }

        try {
            System.out.println("Получен третий массив(верный массив)");
            arraySum(arrayCorrect);
        } catch (MyArraySizeException e) {
            System.out.println("Словлена ошибка о неверном размере массива.");
            e.printStackTrace();
            e.printMessage();
        } catch (MyArrayDataException e) {
            System.out.println("Словлена ошибка о неверном значении внутри массива");
            e.printStackTrace();
            e.printMessage();
        }
    }

    public static void arraySum(String[][] initialArray) {
        System.out.println("Получен массив...");
        if (initialArray.length != 4) {
            throw new MyArraySizeException("Получен массив неверного размера");
        }
        for (int i = 0; i < 4; i++) {
            if (initialArray[i].length != 4) {
                throw new MyArraySizeException("Получен массив неверного размера");
            }
        }

        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (!isDigit(initialArray[i][j])) {
                    throw new MyArrayDataException("Значение в одной из ячеек не является числом", i, j);
                }
                sum += Integer.parseInt(initialArray[i][j]);
            }
        }
        System.out.println("Сумма всех элементов массива равна " + sum);
    }

    public static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}