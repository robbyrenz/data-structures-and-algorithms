/**
 * Name: Robby Renz Abeysinghe
 * Student Number: 3073208
 * Answer 1 of Assignment 2
 */

import java.util.Random;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        // Peg[] listOfPegs = pegMaker(4);
        // System.out.println(listOfPegs[1].getColor());

        ArrayList<Peg> pegList = new ArrayList<>();
        ArrayList<String> playerGuess = new ArrayList<>();

        Peg one = new Peg(randomColors());
        Peg two = new Peg(randomColors());
        Peg three = new Peg(randomColors());
        Peg four = new Peg(randomColors());
        System.out.println(one);
        System.out.println(two);
        System.out.println(three);
        System.out.println(four);

        // adding the pegs to an Array-based List ADT
        pegList.addToLast(one);
        pegList.addToLast(two);
        pegList.addToLast(three);
        pegList.addToLast(four);

        System.out.println();
        System.out.println(pegList.get(0));

        // output(playerGuess);

        Scanner keyboard = new Scanner(System.in);
        String foo = keyboard.nextLine();
        System.out.println(foo);

        
    }

    // displaying the feedback in a 2x2 grid
    public static void output(ArrayList<String> playerGuess) { // TODO: maybe add arguments?
        Scanner keyboard = new Scanner(System.in);
        // for (int i = 0; i < 4; i++) {
        //     playerGuess.addToLast(keyboard.next());
        // }
        playerGuess.addToLast(keyboard.next());
        System.out.println(playerGuess.get(0));

        // System.out.println("Guess #" + number + ":");
        // code the color of the pegs
        // then code the pegs themselves (x, o or -)
    }

    // randomizing colors for the pegs
    public static String randomColors() {
        String[] colors = {"red", "orange", "yellow", "green", "blue", "purple"};
        Random rand = new Random();
        return colors[rand.nextInt(6)];
    }

    // redundant array as it is not working
    // instantiating any number of pegs
    // public static Peg[] pegMaker(int number) {
    //     Peg[] list = new Peg[number];
    //     for (int i = 0; i < number; i++) {
    //         String name = "peg" + Integer.toString(i);
    //         name = new Peg(randomColors());
    //         list[i] = name;
    //     }
    //     return list;
    // }
}