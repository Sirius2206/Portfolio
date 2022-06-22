package Lesson5;

public class Lesson5_Classes {


    public static void main(String[] args) {
        Employee[] employeeArray = new Employee[5];
        employeeArray[0] = new Employee(1, "James", "Sunderland", "Clerk", "sunjames@gmail.com",
                "+10 555 107 32 35", 40000, 29);
        employeeArray[1] = new Employee();
        employeeArray[2] = new Employee(2,  "Walter ", "White", "chemistry teacher", "Heisenberg@allmail.com",
                "+5 162 012 50 52", 99999, 50);
        employeeArray[3] = new Employee(3, "Raynald", "Chatillon", "journeyman", "klepray@gmail.com",
                "+66 320 901 01 97", 30000, 45);
        employeeArray[4] = new Employee(4, "Harrier", "Dubois", "Militioner", "dercm@revmail.com",
                "+83 092 163 18 35", 45000, 42);

        for (Employee e : employeeArray){
            if (e.getAge() > 40) e.printInfo();
        }

        System.out.println();

    }
}
