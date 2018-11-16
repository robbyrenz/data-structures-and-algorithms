/**
 * @author Robby Renz Abeysinghe
 * Student Number: 3073208
 * Answer to Part B of Assignment 3
 */

import java.util.Comparator;

public class DefaultComparator<E> implements Comparator<E> {
	public int compare(E a, E b) throws ClassCastException {
		return ((Comparable<E>) a).compareTo(b);
	}
}

