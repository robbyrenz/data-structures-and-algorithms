/**
 * @author Robby Renz Abeysinghe
 * Student Number: 3073208
 * Answer of Part B of Assignment 3
 */

import java.util.Comparator;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.concurrent.LinkedTransferQueue;

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

    // protected utilities
    // exchanges the entries at positions i and j of the linked binary tree, positions will not be swapped
    protected void swap(Position<Entry<K,V>> a, Position<Entry<K,V>> b) {
        Position<Entry<K,V>> tempOne = a;
        a = b;
        b = tempOne;
    }

    // moves the entry at position j higher, if necessary, to restore the heap property
    protected void upheap(Position<Entry<K,V>> p) {
        while (compare(p.getElement(), (Entry) heap.parent(p)) >= 0) {
            swap(p, heap.parent(p));
            p = heap.parent(p);
        }
    }

    // moves the entry at a position lower, if necessary, to restore the heap property
    protected void downheap(Position<Entry<K,V>> p) {
        // code here
    }

    // public methods
    // returns the number of entries in the priority queue
    public int size() {
        return heap.size();
    }

    // returns, but does not remove, an entry with minimal key
    public Entry<K,V> min() {
        if (heap.isEmpty())
            return null;
        return (Entry) heap.root();
    }

    // inserts a key-value pair and returns the entry created
    public Entry<K,V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key); // auxiliary key-checking method (could throw exception)
        Entry<K,V> newest = new PQEntry<>(key, value);
        // code to add to the end of the list
        Position cursor = heap.root();
        String binary = Integer.toBinaryString(heap.size());
        char[] binaryArr = binary.toCharArray();
        for (int i = 1; i < binaryArr.length - 1; i++) {
            if (binaryArr.length - 1 == i) {
                if (binaryArr[i] == '0')
                    cursor = heap.addLeft(cursor, newest);
                else
                    cursor = heap.addRight(cursor, newest);
            }
            else if (binaryArr[i] == '1')
                cursor = heap.right(cursor);
            else
                cursor = heap.left(cursor);
        }
        upheap(cursor);
        return newest;
    }

    // removes and returns an entry with minimal key, if any
    public Entry<K,V> removeMin() {
        if (heap.isEmpty())
            return null;
        Entry<K,V> answer = this.min();
        swap(heap.root(), returnsLast());
        heap.remove(returnsLast());
        downheap(heap.root());
        return answer;
    }

    // returns the last entry in the priority queue
    public Position<Entry<K,V>> returnsLast() {
        Position<Entry<K,V>> last = heap.root();
        for (Position e : heap.positions())
            last = e;
        return last;
    }

    // --------------------nested ElementIterator Class--------------------
    // this class adapts the iteration produced by positions() to return elements
    private class ElementIterator implements Iterator<K> {
        Iterator<Position<K>> posIterator = positions().iterator();
        public boolean hasNext() {
            return posIterator.hasNext();
        }
        public K next() {
            return posIterator.next().getElement(); // return element!
        }
        public void remove() {
            posIterator.remove();
        }
    }

    // returns an iterator of the elements stored in the tree
    public Iterator<K> iterator() {
        return new ElementIterator();
    }

    public Iterable<Position<K>> positions() {
        return breadthfirst();
    }

    // returns an iterable collection of positions of the tree in breadth-first order
    public Iterable<Position<K>> breadthfirst() {
        List<Position<K>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            LinkedTransferQueue<Position<K>> fringe = new LinkedTransferQueue<>();
            fringe.add((Position) heap.root());
            while (!fringe.isEmpty()) {
                Position<Entry<K,V>> p = fringe.poll(); // remove from front of the queue
                snapshot.add((Position) p);
                for (Position<K> c : heap.children(p))
                    fringe.add(c); // add children back to queue
            }
        }
        return snapshot;
    }
}