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

        // reinitializing the cursor position to point to the root of the tree
        cursor = tree.root();
 
        System.out.println("Please answer each question with a 'y' or a 'n'");
        System.out.println();
        System.out.println(cursor.getElement());
        while (tree.isInternal(cursor))
            cursor = askQuestion(tree, cursor);

        System.out.println();
        System.out.println("********************Program Ended********************");

    }

    /* Displays root and its 2 children */
    public static void displayFamily(LinkedBinaryTree lbt){
        System.out.println("Root: " + lbt.root().getElement());
        System.out.println("Children of " + lbt.root().getElement() + ": ");
        System.out.println(lbt.left(lbt.root()).getElement() + " and " + lbt.right(lbt.root()).getElement());     
    }

    // method to evaluate the user's input and act accordingly
    public static Position<String> askQuestion(LinkedBinaryTree<String> lbt, Position<String> p) {
        Scanner keyboard = new Scanner(System.in);
        // System.out.println(p.getElement());
        String input = keyboard.next();
        if (input.equalsIgnoreCase("y"))
            p = lbt.left(p);
        else
            p = lbt.right(p);
        System.out.println(p.getElement());
        return p; // without returning the Position instance, the program will be stuck in a loop
    }
}
