/**
 * Name: Robby Renz Abeysinghe
 * Student Number: 3073208
 * Answer 2 of Assignment 1
 */

public class LinkedQueue<E> implements Queue<E> {
    private SinglyLinkedList<E> list = new SinglyLinkedList<>();
    public LinkedQueue() {}

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void enqueue(E element) {
        list.addLast(element);
    }

    public E first() {
        return list.first();
    }

    public E dequeue() {
        return list.removeFirst();
    }

    public String toString() {
        return list.toString();
    }
}
