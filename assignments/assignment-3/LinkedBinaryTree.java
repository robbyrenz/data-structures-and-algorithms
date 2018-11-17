/**
 * @author Robby Renz Abeysinghe
 * Student Number: 3073208
 * Answer 1 of Assignment 3
 */

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {

    //--------------------nested Node class--------------------
    protected static class Node<E> implements Position<E> {

        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        // constructs a Node with the given element and neighbors
        public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
            element = e;
            parent = above;
            left = leftChild;
            right = rightChild;
        }

        // accessor methods
        public E getElement() {
            return element;
        }
        public Node<E> getParent() {
            return parent;
        }
        public Node<E> getLeft() {
            return left;
        }
        public Node<E> getRight() {
            return right;
        }

        // update methods
        public void setElement(E e) {
            element = e;
        }
        public void setParent(Node<E> parentNode) {
            parent = parentNode;
        }
        public void setLeft(Node<E> leftChild) {
            left = leftChild;
        }
        public void setRight(Node<E> rightChild) {
            right = rightChild;
        }
 
        // toString method
        public String toString() {
            return this.getElement();
        }
    } //--------------------end of nested Node class--------------------

        // factory function to create a new node storing element e
        protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right) {
            return new Node<E>(e, parent, left, right);
        }

        // LinkedBinaryTree instance variables
        protected Node<E> root = null;
        private int size = 0;

        // constructor
        public LinkedBinaryTree() {}

        // nonpublic utility
        // validates the position and returns it as a new node
        protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
            if (!(p instanceof Node))
                throw new IllegalArgumentException("Not a valid position type");
            Node<E> node = (Node<E>) p; // safe cast
            if (node.getParent() ==  node)
                throw new IllegalArgumentException("p is no longer in the tree");
            return node;
        }

        // accessor methods (not already implemented in AbstractBinaryTree)
        // returns the number of nodes in the tree
        public int size() {
            return size;
        }

        // returns the root Position of the tree (or null if tree is empty)
        public Position<E> root() {
            return root;
        }

        // returns the Position of p's parent (or null if p is root)
        public Position<E> parent(Position<E> p) throws IllegalArgumentException {
            Node<E> node = validate(p);
            return node.getParent();
        }

        // returns the Position of p's left child (or null if no child exists)
        public Position<E> left(Position<E> p) throws IllegalArgumentException {
            Node<E> node = validate(p);
            return node.getLeft();
        }

        // returns the Position of p's right child (or null if no child exists)
        public Position<E> right(Position<E> p) throws IllegalArgumentException {
            Node<E> node = validate(p);
            return node.getRight();
        }

        // update methods supported by this class
        // places element e at the root of an empty tree and returns its new Position
        public Position<E> addRoot(E e) throws IllegalStateException {
            if (!isEmpty()) throw new IllegalStateException("Tree is not empty");
            root = createNode(e, null, null, null);
            size = 1;
            return root;
        }

        // creates a new left child of Position p storing element e; returns its Position
        public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException {
            Node<E> parent = validate(p);
            if (parent.getLeft() != null)
                throw new IllegalArgumentException("P already has a left chidl");
            Node<E> child = createNode(e, parent, null, null);
            parent.setLeft(child);
            size++;
            return child;
        }

        // creates a new right child of Position p storing element e; returns its Position
        public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException {
            Node<E> parent = validate(p);
            if (parent.getRight() != null)
                throw new IllegalArgumentException("P already has a left chidl");
            Node<E> child = createNode(e, parent, null, null);
            parent.setRight(child);
            size++;
            return child;
        }

        // replaces the element at Position p with e and returns the replaced element
        public E set(Position<E> p, E e) throws IllegalArgumentException {
            Node<E> node = validate(p);
            E temp = node.getElement();
            node.setElement(e);
            return temp;
        }

        // attaches trees t1 and t2 as left and right subtrees of external p
        // public void attach(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) throws IllegalArgumentException

        // removes the node at Position p and replaces it with its child, if any
        public E remove(Position<E> p) throws IllegalArgumentException {
            Node<E> node = validate(p);
            if (numChildren(p) == 2)
                throw new IllegalArgumentException("p has two children");
            Node<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight());
            if (child != null)
                child.setParent(node.getParent()); // child's grandparent becomes its parent
            if (node == root)
                root = child;
            else {
                Node<E> parent = node.getParent();
                if (node == parent.getLeft())
                    parent.setLeft(child);
                else
                    parent.setRight(child);
            }
            size--;
            E temp = node.getElement();
            node.setElement(null); // helps in garbage collection
            node.setLeft(null);
            node.setRight(null);
            node.setParent(node); // convention for defunct node
            return temp;
        }

        // toString method
        public String toString() {
            return node.getElement();
        }
} //--------------------end of LinkedBinaryTree class--------------------
