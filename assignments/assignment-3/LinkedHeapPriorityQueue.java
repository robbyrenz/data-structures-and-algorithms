/**
 * @author Robby Renz Abeysinghe
 * Student Number: 3073208
 * Answer of Part B of Assignment 3
 */

// an implementation of a priority queue using a linked binary tree heap
public class LinkedHeapPriorityQueue<K,V> extends AbstractPriorityQueue<K,V> {

    // primary collection of priority queue entries
    protected LinkedBinaryTree<Entry<K,V>> heap = new LinkedBinaryTree<>();

    // creates an empty priority queue based on the natural ordering of its keys
    public LinkedHeapPriorityQueue() {
	    super();
    }

    // createss an empty priority queue using the given comparator to order keys
    public LinkedHeapPriorityQueue(Comparator<K> comp) {
	    super(comp);
    }

    // exchanges the entries at positions i and j of the linked binary tree, positions will not be swapped
    protected void swap(Position<K,V> a, Position<K,V> b) {
        PQEntry<K,V> tempOne = a.getElement();

        a.getElement().setKey(b.getElement().getKey());
        a.getElement().setValue(b.getElement().getValue());

        b.getElement().setKey(tempOne.getKey());
        b.getElement().setValue(tempOne.getValue());
    }
}

