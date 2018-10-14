/**
 * Driver class for the Shares program
 *
 * Student Number: 3073208
 * Answer 2 of Assignment 2
 * @author Robby Renz Abeysinghe
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        LinkedQueue<Shares> list = new LinkedQueue<>();
        Transactions calc = new Transactions(list);
        menuDisplay(list, calc);
        System.out.println("Goodbye, human...");
    }

    // method to display the menu and accept input
    public static void menuDisplay(LinkedQueue<Shares> list, Transactions calc) {
        Scanner keyboard = new Scanner(System.in);
        String input = "";
        do {
            System.out.println();
            System.out.println("Make a selection: ");
            System.out.println("\t1. Buy shares\n\t2. Sell shares\n\t3. Quit\n");
            input = keyboard.next();

            switch (input) {
                case "1": buyShares(list); break;
                case "2": sellShares(list, calc); break;
                case "3": return;
                default: System.out.println("Invalid selection!");
            }
            summary(list, calc);
        } while (!input.equals("3"));
    }

    // method to buy shares
    public static void buyShares(LinkedQueue<Shares> stuff) {
        Scanner keyboard = new Scanner(System.in);
        int quantity, price;
        System.out.println("Enter the number of shares to buy: ");
        quantity = exceptionHandle(keyboard);
        System.out.println("Enter the purchase price per share: ");
        price = exceptionHandle(keyboard);
        stuff.enqueue(new Shares(quantity, price));
    }

    // method to sell shares
    public static void sellShares(LinkedQueue<Shares> stuff, Transactions calc) {
        Scanner keyboard = new Scanner(System.in);
        int quantity, price, capitalGain;
        System.out.println("Enter the number of shares to sell: ");
        quantity = exceptionHandle(keyboard);
        System.out.println("Enter the selling price per share: ");
        price = exceptionHandle(keyboard);
        capitalGain = calc.sellShares(quantity, price, stuff);
        System.out.println("Capital gain: " + capitalGain);

    }

    // method that shows a summary
    public static void summary(LinkedQueue<Shares> stuff, Transactions calc) {
        System.out.println("Shares held: " + stuff.toString());
        System.out.println("Total shares: " + calc.getTotalShares());
        System.out.println("Total share value: $" + calc.getTotalValue());
    }

    // method to catch the InputMismatchException
    public static int exceptionHandle(Scanner keyboard) {
        int num = 1;
        try {
            num = keyboard.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Valid number was not entered! Using 1 by default");
            num = 1;
        }
        return num;
    }
}
