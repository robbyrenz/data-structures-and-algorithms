/**
 * @author Robby Renz Abeysinghe
 * Student Number: 3073208
 * Answer of Part A of Assignment 4
 */

import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Driver {
	public static void main(String[] args) throws FileNotFoundException {
		ProbeHashMap<String,Integer> map = new ProbeHashMap<>();
		Scanner keyboard = new Scanner(new File("PartA.txt")).useDelimiter("[^a-zA-Z']+");

		while (keyboard.hasNext()) {
			String word = keyboard.next().toLowerCase();
			if (map.get(word) == null)
				map.put(word, 1);
			else
				map.put(word, map.get(word) + 1);
		}

		for (Entry<String,Integer> foo : map.entrySet())
			System.out.println(foo);

		// Entry<String,Integer> arr[] = new Entry[map.size()];

		// int i = 0;
		// for (Entry<String,Integer> foo : map.entrySet()) {
		// 	arr[i] = foo;
		// 	i++;
		// }

		// MergeSort.mergeSort(arr, new EntryComparator());
		// for (int j = 0; i < 10; i++)
		// 	System.out.println(arr[i]);
	}
}

