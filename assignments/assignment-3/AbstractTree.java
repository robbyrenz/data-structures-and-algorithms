/**
 * @author Robby Renz Abeysinghe
 * Student Number: 3073208
 * Answer 1 of Assignment 3
 */

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
}
