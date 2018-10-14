/**
 * Name: Robby Renz Abeysinghe
 * Student Number: 3073208
 * Answer 1 of Assignment 1
 */

import java.util.Random;

public class Driver {
    public static void main(String[] args) {
        CircularlyLinkedList<Player> list = new CircularlyLinkedList<>();

        int elim = 0; // counts the number of player eliminated

        Random dice1 = new Random();
        Random dice2 = new Random();

        Player harry = new Player("Harry");
        Player ron = new Player("Ron");
        Player hermione = new Player("Hermione");
        Player luna = new Player("Luna");

        list.addFirst(harry);
        list.addLast(ron);
        list.addLast(hermione);
        list.addLast(luna);

        System.out.println("Let the games begin!!!");

        do {
            if (list.first().getEliminated()) {
//                elim++;
                list.rotate();
                continue;
            }
            diceRoll(dice1, dice2, list.first());
            list.rotate();
        } while (list.last().getScore() <= 100);

        System.out.println("\n\n");
        finalResults(list);
        System.out.println("Thanks for Playing!\n");
    }

    // method to find out the result of a dice roll
    public static void diceRoll(Random one, Random two, Player p) {
        int i, j;
        i = one.nextInt(6) + 1;
        j = two.nextInt(6) + 1;

        if (i + j == 7)
            decrease(p);
        else if (i == 6 && j == 6)
            setToZero(p);
        else if (i == 1 && j == 1)
            elimination(p);
        else
            updateScore(p, i, j);

        messages(p, i, j);
    }

    // method to decrease the player's score
    public static void decrease(Player p) {
        p.updateScore(-7);
        if (p.getScore() < 0)
            p.setScore(0);
    }

    // methods to set the player's score to 0
    public static void setToZero(Player p) {
        p.setScore(0);
    }

    // method to eliminate the player
    public static void elimination(Player p) {
        p.setEliminated();
    }

    // method to update the player's score
    public static void updateScore(Player p, int i, int j) {
        p.updateScore(i + j);
    }

    // method to display the final scores
    public static void finalResults(CircularlyLinkedList<Player> list) {
        System.out.println(list.last().getName() + " has won the game! :)");
        System.out.println("Final scores are: \n");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.last().getName() + ": " + list.last().getScore());
            if (list.last().getEliminated())
                System.out.println(" (Eliminated!)");
            else
                System.out.println();
            list.rotate();
        }
    }

    // method to print out the messages
    public static void messages(Player p, int i, int j) {
        int total = i + j;
        if (total == 7)
            System.out.println(p.getName() + " rolled unlucky " + total + ", score is now " + p.getScore());
        else if (total == 12)
            System.out.println(p.getName() + " rolled a double 6, score is now back to 0!");
        else if (total == 2)
            System.out.println(p.getName() + " rolled a double 1, which means s/he's eliminated!");
        else
            System.out.println(p.getName() + " rolled " + total + ", score is now " + p.getScore());
    }
}
