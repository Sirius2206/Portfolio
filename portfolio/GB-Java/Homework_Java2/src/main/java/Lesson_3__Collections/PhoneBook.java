package Lesson_3__Collections;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    static HashMap<String, String> phoneBook = new HashMap<>();

    public static void add(String surname, String phoneNumber){
        phoneBook.put(phoneNumber, surname);
    }

    public static void get(String surname){
        for (Map.Entry entry: phoneBook.entrySet()){
            if (entry.getValue().equals(surname)){
                System.out.println(surname + ": " + entry.getKey());
            }
        }
    }
}
