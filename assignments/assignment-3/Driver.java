/**
 * @author Robby Renz Abeysinghe
 * Student Number: 3073208
 * Answer 1 of Assignment 3
 */

public class Driver {
    public static void main(String[] args) {
    //     LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();
    //     tree.addRoot("Are you nervous?");
    // }

        LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();

        Position root = tree.addRoot("JLB");
        Position pos = tree.addLeft(root, "Chad");
        tree.addRight(root, "Justin");
        
        displayFamily(tree); 
        
        //replace Chad
        tree.set(pos, "Kennedy");
        System.out.println("\nAfter Kennedy replaces Chad: ");
        displayFamily(tree);
        
        //add Brandt
        pos = tree.addLeft(pos, "Brandt");
        System.out.println("\n" + pos + "'s parent is " + tree.parent(pos));
        
        //remove Kennedy
        pos = tree.parent(pos);
        tree.remove(pos);
        
        System.out.println("\nAfter removing Kennedy: ");
        displayFamily(tree);

        System.out.println(tree);
    }

    /* Displays root and its 2 children */
    public static void displayFamily(LinkedBinaryTree lbt){
        System.out.println("Root: " + lbt.root().getElement());
        System.out.println("Children of " + lbt.root().getElement() + ": ");
        System.out.println(lbt.left(lbt.root()) + " and " + lbt.right(lbt.root()));     
    }
}
