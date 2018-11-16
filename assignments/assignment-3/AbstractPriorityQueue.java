/**
 * @author Robby Renz
 * Student Number: 3073208
 * Answer of Part 2 of Assignment 3
 */

// an abstract base class to assist implementations of the PriorityQueue interface
public abstract class AbstractPriorityQueue<K,V> implements PriorityQueue<K,V> {

	//--------------------nested PQEntry class--------------------
	protected static class PQEntry<K,V> implements Entry<K,V> {
		private K k; // key
		private V v; // value
		public PQEntry(K key, V value) {
			k = key;
			v = value;
		}
		// methods of the Entry interface
		public K getKey() {
			return k;
		}
		public V getValue() {
			return v;
		}
		// utilities not exposed as part of the Entry interface
		protected void setKey(K key) {
			k = key;
		}
		protected void setValue(V value) {
			v = value;
        }
        
        // other methods
        public String toString() {
            return "Key: " + k + ", value: " + v;
        }
	} //--------------------end of nested PQEntry class--------------------

	// instance variable for an AbstractPriorityQueue
	// the comparator defining the ordering of keys in the priority queue
	private Comparator<K> comp;

	// creates an empty priority queue using the given comparator to order keys
	protected AbstractPriorityQueue(Comparator<K> c) {
		comp = c;
	}

	// creates an empty priority queue based on the natural ordering of its keys
	protected AbstractPriorityQueue() {
		this(new DefaultComparator<K>());
	}

	// method for comparing two entries according to key
	protected int compare(Entry<K,V> a, Entry<K,V> b) {
		return comp.compare(a.getKey(), b.getKey());
	}

	// determines whether a key is valid
	protected boolean checkKey(K key) throws IllegalArgumentException {
		try {
			return (comp.compare(key, key) == 0); // see if key can be compared to itself
		} catch (ClassCastException e) {
			throw new IllegalArgumentException("Incompatible key");
		}
	}

	// tests whether the priority queue is empty
	public boolean isEmpty() {
		return size == 0;
	}
}
