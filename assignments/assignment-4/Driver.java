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
		String[] foo = {};
		Scanner keyboard = new Scanner(new File("PartA.txt"));

		int i = 0;
		while (keyboard.hasNext()) {
			foo[i] = keyboard.next();
			i++;
		}

		System.out.println(foo[2]);
	}
}

