/**
 * @author Robby Renz Abeysinghe
 * Student Number: 3073208
 * Answer 1 of Assignment 3
 */

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {

        LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();

        // building the linked binary tree, with the help of the Position object called cursor
        Position cursor = tree.addRoot("Are you nervous?");
        tree.addLeft(cursor, "Savings account.");
        cursor = tree.addRight(cursor, "Will you need to access most of the money within the next 5 years?");
        tree.addLeft(cursor, "Money market fund.");
        cursor = tree.addRight(cursor, "Are you willing to accept risks in exchange for higher expected returns?");
        tree.addLeft(cursor, "Stock portfolio.");
        cursor = tree.addRight(cursor, "Diversified portfolio with stocks, bonds and short-term instruments.");

        displayFamily(tree); // for debugging purposes

        Position root = tree.root();
        System.out.println(root.getElement());

    }

    // public static void example() {
    //     LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();

    //     Position root = tree.addRoot("JLB");
    //     Position pos = tree.addLeft(root, "Chad");
    //     tree.addRight(root, "Justin");
        
    //     displayFamily(tree); 
        
    //     //replace Chad
    //     tree.set(pos, "Kennedy");
    //     System.out.println("\nAfter Kennedy replaces Chad: ");
    //     displayFamily(tree);
        
    //     //add Brandt
    //     pos = tree.addLeft(pos, "Brandt");
    //     System.out.println("\n" + pos + "'s parent is " + tree.parent(pos));
        
    //     //remove Kennedy
    //     pos = tree.parent(pos);
    //     tree.remove(pos);
        
    //     System.out.println("\nAfter removing Kennedy: ");
    //     displayFamily(tree);

    //     System.out.println(tree);

    // }

    /* Displays root and its 2 children */
    public static void displayFamily(LinkedBinaryTree lbt){
        System.out.println("Root: " + lbt.root().getElement());
        System.out.println("Children of " + lbt.root().getElement() + ": ");
        System.out.println(lbt.left(lbt.root()).getElement() + " and " + lbt.right(lbt.root()).getElement());     
    }

    // method to evaluate the user's input and act accordingly
    public static void input(LinkedBinaryTree lbt) {
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.next();
        // if (input.equalsIgnoreCase("y"))
        //     lbt.
    }
}
