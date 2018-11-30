/**
 * @author Robby Renz Abeysinghe
 * Student Number: 3073208
 * Answer of Part A of Assignment 4
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Driver {
	public static void main(String[] args) throws FileNotFoundException {
		Map<String, Integer> map = new ProbeHashMap<>();
		Scanner keyboard = new Scanner(new File("PartA.txt")).useDelimiter("[^a-zA-Z']+");

		while (keyboard.hasNext()) {
			String word = keyboard.next();
			if (map.get(word) == null)
				map.put(word, 1);
			else
				map.put(word, map.get(word) + 1);
		}
	}
}

