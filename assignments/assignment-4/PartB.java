/**
 * @author Robby Renz Abeysinghe
 * Student Number: 3073208
 * Answer of Part B of Assignment 4
 */

import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class PartB {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner keyboard = new Scanner(new File("PartB.txt"));
        ALChainHashMap<String,Order> map = new ALChainHashMap<>();

        // each line will be an instance of the Order object
        while (keyboard.hasNext()) {
            Order line = new Order(keyboard.next(), keyboard.next(), keyboard.nextDouble());
            map.put(line.getOrderID(), line);
        }

        // printing out the list of orders
        System.out.println("Printing out the List of Orders:");
        for (Entry<String,Order> foo : map.entrySet())
            System.out.println(foo);

        // printing out the number of orders
        System.out.println();
        System.out.println("Number of Orders: ");
        System.out.println(map.size());

        // printing out the number of collisions that occurred in the hashmap
        System.out.println();
        System.out.println("Number of Collisions that occured in the Hashmap: ");
        System.out.println(); // insert in here a method
    }
}
