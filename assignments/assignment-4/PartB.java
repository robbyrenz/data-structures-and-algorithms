/**
 * @author Robby Renz Abeysinghe
 * Student Number: 3073208
 * Answer of Part B of Assignment 4
 */

import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.lang.Iterable;

public class PartB {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner keyboard = new Scanner(new File("PartB.txt"));
        ALChainHashMap<String,Order> map = new ALChainHashMap<>();

        while (keyboard.hasNext()) {
            Order line = new Order(keyboard.next(), keyboard.next(), keyboard.nextDouble());
            map.put(line.getOrderID(), line);
        }

        // printing out the orders
        for (Entry<String,Order> foo : map.entrySet())
            System.out.println(foo);
    }
}
