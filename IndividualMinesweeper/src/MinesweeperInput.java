/*
 * T CSS 360 - Summer 2024
 * Group Assignment 1
 * (INDIVIDUAL SUBMISSION)
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * MinesweeperInput class randomly generates a 2nd-dimensional character
 * array filled with landmines and safe spots. It outputs the 2nd-dimensional
 * array into a text file named "minefield.txt."
 *
 * @author Noah Ogilvie
 * @version 2024-06-27
 */
public class MinesweeperInput {

    /**
     * main() method calls in other methods.
     * @param args  the command lime prompt.
     */
    public static void main(String[] args) {
        introduction();
        programStart();

    }

    /**
     * introduction() method prompts the user the introduction and purpose of the application.
     */
    private static void introduction() {
        System.out.println("Minefield creator.\n");
        System.out.println("The purpose of this application is to generate a 2-dimensional array of a" +
                           "minefield.");
        System.out.println("The output file name is minefield.txt.");
    }

    /**
     * programStart() method is used to generate a random sized 2nd-dimensional character
     * array and calls other methods to populate and print it out into a text file.
     */
    private static void programStart() {
        Random rand = new Random();
        int rowNumber = rand.nextInt(100) + 1;
        int columnNumber = rand.nextInt(100) + 1;
        char[][] minefield = populateMinefield(new char[rowNumber][columnNumber]);
        fileMinefield(minefield, rowNumber, columnNumber);

        //Debugging and testing purposes
//        char[][] minefield = populateMinefield(new char[2][5]);
//        fileMinefield(minefield, 2, 5);
    }

    /**
     * populateMinefield() method is used to randomly populate the randomly generated
     * 2nd-dimensional character array with either landmines or space spots.
     * @param theMinefield  the empty 2nd-dimensional character array
     * @return a filled 2nd-dimensional array.
     */
    private static char[][] populateMinefield(final char[][] theMinefield) {
        for (int i = 0; i < theMinefield.length; i++) {
            for (int j = 0; j < theMinefield[i].length; j++) {
                Random generator = new Random();
                int randomNumber = generator.nextInt(10) + 1;
                if (randomNumber % 10 == 0) {
                    theMinefield[i][j] = '*';
                } else {
                    theMinefield[i][j] = '.';
                }
            }
        }
        return theMinefield;
    }

    /**
     * fileMinefield() method is used to print out the number of rows first, the number of
     * columns second, and then the 2nd-dimensional array itself into a text file.
     * @param theMinefield      the filled 2nd-dimensional character array
     * @param rowNumber         the number of rows
     * @param columnNumber      the number of columns
     */
    private static void fileMinefield(final char[][] theMinefield,
                                      final int rowNumber, final int columnNumber) {
        PrintStream out = null;
        try {
            out = new PrintStream(new File("minefield.txt"));
        } catch (final FileNotFoundException e) {
            System.out.println("File did not create. Try again");
        }
        out.println(rowNumber + " " + columnNumber);
        for (int i = 0; i < theMinefield.length; i++) {
            for (int j = 0; j < theMinefield[i].length; j++) {
                out.print(theMinefield[i][j]);
                if (j == theMinefield[i].length - 1) {
                    out.println('\n');
                }
            }
        }
        out.close();
    }
}
