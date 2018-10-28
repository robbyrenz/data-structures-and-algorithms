/**
 * Name: Robby Renz Abeysinghe
 * Student Number: 3073208
 * Answer 1 of Assignment 2
 */

import java.util.Random;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        boolean gameEnded = false;
        int number = 1;

        ArrayList<Peg> pegList = new ArrayList<>();
        ArrayList<String> playerGuess = new ArrayList<>();

        Peg one = new Peg(randomColors());
        Peg two = new Peg(randomColors());
        Peg three = new Peg(randomColors());
        Peg four = new Peg(randomColors());

        // debugging purposes
        System.out.println(one);
        System.out.println(two);
        System.out.println(three);
        System.out.println(four);
        // -------------------------

        // adding the pegs to an Array-based List ADT
        pegList.addToLast(one);
        pegList.addToLast(two);
        pegList.addToLast(three);
        pegList.addToLast(four);
        System.out.println();
        // -------------------------

        System.out.println("Welcome to Mastermind!");
        System.out.println("The only colors you can enter are red, orange, yellow, green, blue and purple.\nHave fun!");
        System.out.println();

        do {
            gettingInput(playerGuess, number);
            // checkGuesses
            String[] xo = checkGuesses(pegList, playerGuess);
            output(xo);
            clearGuesses(playerGuess);
            number++;
        } while (number < 11/* || gameEnded == false*/); // maybe setting gameEnded to true, or using the &&?

        finalScreen(number);
    }
    // ------------------end of main class--------------------------------

    // getting input from the user
    public static void gettingInput(ArrayList<String> playerGuess, int number) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Guess #" + number);

        for (int i = 0; i < 4; i++) {
            playerGuess.addToLast(keyboard.next());
        }
    }

    // randomizing colors for the pegs
    public static String randomColors() {
        String[] colors = {"red", "orange", "yellow", "green", "blue", "purple"};
        Random rand = new Random();
        return colors[rand.nextInt(6)];
    }

    // clearing the user's guesses in the ArrayList
    public static void clearGuesses(ArrayList<String> playerGuess) {
        for (int i = 0; i < playerGuess.size(); i++)
            playerGuess.remove(i);
    }

    // comparing the ArrayLists for exact and non-exact matches
    public static String[] checkGuesses(ArrayList<Peg> pegList, ArrayList<String> playerGuess) {
        // instantiating an array to hold the x's, o's, and -'s
        String[] xo = {"-", "-", "-", "-"};

        // storing the colors of the pegs into an array
        String[] pegColors = new String[4];
        for (int i = 0; i < 4; i++)
            pegColors[i] = pegList.get(i).getColor();

        // storing the colors of the pegs into an array
        String[] arrOfGuess = new String[4];
        for (int i = 0; i < 4; i++)
            arrOfGuess[i] = playerGuess.get(i);

        // for exact matches
        for (int i = 0; i < 4; i++) {
            if (pegColors[i].equals(arrOfGuess[i]))
                xo[i] = "x";
        }

        // need to add a method here to check if the user has all x's, and so must set gameEnded to true
        return xo;
    }

    // displaying the feedback in a 2x2 grid
    public static void output(String[] xo) {
        System.out.println(xo[0] + xo[1] + "\n" + xo[2] + xo[3]);
    }

    // displaying the winning or losing screen
    public static void finalScreen(int number) {
        if (number > 10)
            System.out.println("Sorry, you lose");
        else
            System.out.println("Congrats, you won!");
    }
}
