package Lesson5;

public class Employee {

    private int id;
    private String name;
    private String surname;
    private String position;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    public Employee(int id, String name, String surname, String position, String email, String phoneNumber, int salary, int age) {
        System.out.println("Внесена запись о сотруднике № " + id);
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public Employee() {
        this(-1, "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", -1, -1);
    }

    public int getAge() {
        return age;
    }

    public void printInfo(){
        System.out.println("Сотрудник № " + id);
        System.out.println("Фамилия: " + surname + " Имя: " + name + " Должность: " + position + " Электронный адрес: " + email);
        System.out.println("Номер телефона: " + phoneNumber + " Зарплата: " + salary + " Возраст: " + age);
        System.out.println();
    }
}
