package Lesson8;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestClassReflection{

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Class catClass = Cat.class;
        start(catClass);
    }
    public static void start (Class testClass) throws InvocationTargetException, IllegalAccessException {
        Method bsMethod = null;
        Method asMethod = null;
        System.out.println(testClass.getName());

        Method[] methods = testClass.getDeclaredMethods();
        int countBeforeSuite = 1;
        int countAfterSuite = 1;
        for (Method method : methods) {
            try {
                if (method.getAnnotation(BeforeSuite.class) != null) {
                    try {
                        if (countBeforeSuite == 1) {
                            countBeforeSuite--;
                            bsMethod = testClass.getMethod(method.getName());
                        } else {
                            throw new RuntimeException("В переданном классе больше одной аннотации @BeforeSuite");
                        }
                    } catch (RuntimeException e) {
                        e.printStackTrace();
                        return;
                    }
                }
                if (method.getAnnotation(AfterSuite.class) != null) {
                    try {
                    if (countAfterSuite == 1) {
                        countAfterSuite--;
                        asMethod = testClass.getMethod(method.getName());
                    } else {
                        throw new RuntimeException("В переданном классе больше одной аннотации @AfterSuite");
                    }
                    } catch (RuntimeException e) {
                        e.printStackTrace();
                        return;
                    }
                }

            } catch (RuntimeException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

        assert bsMethod != null;
        System.out.println("Запуск первого метода: " + bsMethod.getName());
        bsMethod.invoke(testClass);


        for (int i = 1; i <= 10; i++) {
            for (Method method : methods) {
                Test testAnnotation = method.getAnnotation(Test.class);
                if ((testAnnotation != null) && (testAnnotation.value() == i)) {
                    System.out.println("Запуск тестового метода: " + method.getName());
                    method.invoke(testClass);
                }
            }
        }

        assert asMethod != null;
        System.out.println("Запуск последнего метода: " + asMethod.getName());
        asMethod.invoke(testClass);

    }
}
