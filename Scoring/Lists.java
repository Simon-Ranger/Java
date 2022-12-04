package part1;

import java.util.ArrayList;

public class Lists {

    public static void main(String[] args) {
        // Creating the arraylist
        ArrayList<String> names = new ArrayList<>();
        int gather = names.indexOf("Bob");
        int index = 0;
        
        // Adding to the list
        names.add("Alice");
        names.add("Bob");
        names.add("Chelsie");
        names.add("Dave");
        names.add("Edward");
        names.add(0, "George");
        names.add(6, "Francene");
        
        // Removing from the list
        names.remove("Alice");
        names.remove(3);
        
        // Enhanced loop to print all the names
        for (String s: names) {
            System.out.println((index++) + ": " + s);
        }
        
        // Prints the index of bob & the 5th person
        System.out.println(names.get(4));
        System.out.println("the index of bob is: " + gather);
    }
}
