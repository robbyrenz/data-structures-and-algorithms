    /**
 * @author Robby Renz Abeysinghe
 * Student Number: 3073208
 * Answer 1 of Assignment 3
 */

// import java.util.Queue;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.concurrent.LinkedTransferQueue;

// an abstract base class providing some functionality of the Tree interface
public abstract class AbstractTree<E> implements Tree<E> {

    public boolean isInternal(Position<E> p) {
        return numChildren(p) > 0;
    }

    public boolean isExternal(Position<E> p) {
        return numChildren(p) == 0;
    }

    public boolean isRoot(Position<E> p) {
        return p == root();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    //--------------------nested ElementIterator Class--------------------
    // this class adapts the iteration produced by positions() to return elements
    private class ElementIterator implements Iterator<E> {
        Iterator<Position<E>> posIterator = positions().iterator();
        public boolean hasNext() {
            return posIterator.hasNext();
        }
        public E next() {
            return posIterator.next().getElement(); // return element!
        }
        public void remove() {
            posIterator.remove();
        }
    }

    // returns an iterator of the elements stored in the tree
    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    public Iterable<Position<E>> positions() {
        return breadthfirst();
    }

    // returns an iterable collection of positions of the tree in breadth-first order
    public Iterable<Position<E>> breadthfirst() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            LinkedTransferQueue<Position<E>> fringe = new LinkedTransferQueue<>();
            fringe.add(root());
            while (!fringe.isEmpty()) {
                Position<E> p = fringe.poll(); // remove from front of the queue
                snapshot.add(p);
                for (Position<E> c : children(p))
                    fringe.add(c); // add children back to queue
            }
        }
        return snapshot;
    }
}
