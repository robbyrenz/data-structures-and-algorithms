/**
 * @author Robby Renz Abeysinghe
 * Student Number: 3073208
 * Answer of Part A of Assignment 4
 */

public abstract class AbstractHashMap<K,V> extends AbstractMap<K,V> {
	protected int n = 0; // number of entries in the dictionary
	protected int capacity; // length of the table
	private int prime; // prime factor
	private long scale, shift; // the shift and scaling factors
	public AbstractHashMap(int cap, int p) {
		prime = p;
		capacity = cap;
		Random rand = new Random();
		scale = rand.nextInt(prime - 1) + 1;
		shift = rand.nextInt(prime);
		createTable();
	}
	public AbstractHashMap(int 

