package examples;

import java.util.Hashtable;

public class HashTableExample {
    public static void hash() {
        // Creating a hash table
        Hashtable<String, Integer> table = new Hashtable<>();

        // Adding key-value pairs
        table.put("Apple", 1);
        table.put("Banana", 2);
        table.put("Orange", 3);

        // Accessing values by key
        System.out.println("Value for 'Apple': " + table.get("Apple"));  // Output: 1
        System.out.println("Value for 'Banana': " + table.get("Banana"));  // Output: 2
    }
}