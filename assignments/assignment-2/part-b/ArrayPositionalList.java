/**
 * Implementation of a positional list with an array
 * @author 
 */

public class ArrayPositionalList<E> implements PositionalList<E> {

    private static class ArrPos<E> implements Position<E> {
        private int index;  
        private E element;  
        
        public ArrPos(E e, int i){
            index = i;
            element = e;
        }

        public E getElement() throws IllegalStateException {
           if (index == -1)
               throw new IllegalStateException("Position no longer valid");
           return element;
        }

        public void setElement(E e){
            element = e;
        }

        public int getIndex(){
            return index;
        }

        public void setIndex(int i){
            index = i;
        }   
    }   // end of nested ArrPos class

    // fields
    public static final int CAPACITY = 16;
    private E[] data;
    private int size = 0;

    // constructors
    public ArrayPositionalList() {
        this(CAPACITY);
        ArrPos<E> pos = new ArrPos();
    }

    public ArrayPositionalList(int capacity) {
        data = (E[]) new Object[capacity];
    }

    // methods

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public Position<E> first() {
        return data[0];
    }

    public Position<E> last() {
        
    }

    public Position<E> before(Position<E> p) throws IllegalArgumentException {

    }

    public Position<E> after(Position<E> p) throws IllegalArgumentException {

    }

    public Position<E> addFirst(E e) {

    }

    public Position<E> addLast(E e) {

    }

    public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {

    }

    public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {

    }

    public E set(Position<E> p, E e) throws IllegalArgumentException {

    }

    public E remove(Position<E> p) throws IllegalArgumentException {

    }
}
