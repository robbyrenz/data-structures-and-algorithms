/**
 * A generic SinglyLinkedList class
 * Student Number: 3073208
 * Answer 2 of Assignment 1
 * @author Robby Renz Abeysinghe
 * @param E can represent any data type
 */
public class SinglyLinkedList<E> {
    //----------nested Node class----------
    private static class Node<E> {
        private E element;
        private Node<E> next;
        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }
        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }
    //----------end of nested Node class---

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList() {}

    // access methods
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty())
            return null;
        return head.getElement();
    }

    public E last() {
        if (isEmpty())
            return null;
        return tail.getElement();
    }

    // update methods
    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (size == 0)
            tail = head;
        size++;
    }

    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);

        if (isEmpty())
            head = newest;
        else
            tail.setNext(newest);
        tail = newest;
        size++;
    }

    public E removeFirst() {
        if (isEmpty())
            return null;
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if (size == 0)
            tail = null;
        return answer;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("<");
        Node<E> walk = head;
        while (walk != null) {
            sb.append(walk.getElement());
            if (walk != tail)
                sb.append(", ");
            walk = walk.getNext();
        }
        sb.append(">");
        return sb.toString();
    }
}
