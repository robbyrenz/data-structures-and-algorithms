/**
 * @author Robby Renz Abeysinghe
 * Student Number: 3073208
 * Part A of Assignment 2
 */

public class ArrayList<E> implements List<E> {

    // instance variables
    public static final int CAPACITY = 16; // default array capacity
    private E[] data; // generic array used for storage
    private int size = 0; // current number of elements

    // constructors
    public ArrayList() {
        this(CAPACITY); // constructs list with default capacity
    }
    public ArrayList(int capacity) { // constructs list with given capacity
        data = (E[]) new Object[capacity]; // safe cast; compiler may give warning
    }

    // public methods

    // returns the number of elements in the array list
    public int size() {
        return size;
    }

    // returns whether the array list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // returns (but does not remove) the element at index i
    public E get(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        return data[i];
    }

    // replaces the element at index i with e, and returns the replaced element
    public E set(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        data[i] = e;
        return temp;
    }

    // inserts element e to be at index i, shifting all subsequent elements later
    public void add(int i, E e) throws IndexOutOfBoundsException, IllegalStateException {
        checkIndex(i, size + 1);
        if (size == data.length) // not enough capacity
            throw new IllegalStateException("Array is full");
        for (int k = size - 1; k >= i; k--) // start by shifting rightmost
            data[k + 1] = data[k];
        data[i] = e; // ready to place the new element
        size++;
    }

    // appends an element at the end of the list (my definition)
    public void addToLast(E e) {
        if (size == data.length) 
            throw new IllegalStateException("Array is full");
        int i = 0;
        while (data[i] != null)
            i++;
        data[i] = e;
        size++;
    }

    // removes/returns the element at index i, shifting subsequent elements earlier
    public E remove(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        for (int k = i; k < size - 1; k++) // shift elements to fill hole
            data[k] = data[k + 1];
        data[size - 1] = null; // help garbage collection
        size--;
        return temp;
    }

    // utility method
    // checks whether the given index is in the range [0, n - 1]
    protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
        if (i < 0 || i >= n)
            throw new IndexOutOfBoundsException("Illegal index: " + i);
    }

    // other method
    // public boolean equals(ArrayList<E> list) {
    //     if (list == this)
    //         return true;
    //     return false;
    // }

    public boolean equals(ArrayList<E> list) {
        if (list == this)
            return true;
        return false;
    }
}
