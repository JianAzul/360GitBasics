/*
 * T CSS 360 - Summer 2024
 * Group Assignment 1
 * (INDIVIDUAL SUBMISSION)
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

/**
 * MinesweeperOutput class is an application that handles the amount of surrounding
 * mines in a given position found in a 2nd-dimensional array. It asks the user
 * for a text file and converts it to the solution. It outputs into a file named
 * "minefiledoutput.txt."
 *
 * @author Noah Ogilvie
 * @version 2027-06-27
 */
public class MinesweeperOutput {

    /**
     * main() method is used to call other methods.
     * @param args  the command line
     */
    public static void main(String[] args) {
        final Scanner console = new Scanner(System.in);
        programStart(console);
    }

    /**
     * introduction() method prints out a prompt that tells the user the applications.
     */
    private static void introduction() {
        System.out.println("Welcome to the Minesweeper!");
        System.out.println("The output file is named minefiledoutput.txt.");
        System.out.print("Input a minefield file: ");
    }

    /**
     * programStart() method prompts the user to input a text file. Calls other
     * methods to replace values with the appropriate value, either a number
     * or a landmine. It also outputs into a file.
     * @param theScan   the scanner that reads the user's input from the console
     */
    private static void programStart(final Scanner theScan) {
        Scanner input = null;
        boolean fileExist = false;
        introduction();
        String fileName = theScan.nextLine();
        do {
            try {
                input = new Scanner(new File(fileName));
                fileExist = true;
            } catch (final FileNotFoundException e) {
                System.out.print("File not found. Try again: ");
                fileName = theScan.nextLine();
            }
        } while (!fileExist);

        if (fileExist) {
            PrintStream out = null;
            try {
                out = new PrintStream(new File("minefieldoutput.txt"));
            } catch (final FileNotFoundException e) {
                System.out.println("File did not create. Try again");
            }
            int count = 1;
            boolean zero = false;
            while (!zero) {
                int rowsCheck = input.nextInt();
                if (rowsCheck == 0) {
                    zero = true;
                }
                int columnsCheck = input.nextInt();
                if (columnsCheck == 0) {
                    zero = true;
                }
                if (!zero) {
                    char[][] field = scanMinefield(input, rowsCheck, columnsCheck);

//                    System.out.println("Field #" + count + ": ");
                    field = changeMinefield(field);
                    out.println("Field #" + count + ": ");
                    for (int i = 0; i < field.length; i++) {
                        for (int j = 0; j < field[i].length; j++) {
                            out.print(field[i][j]);
                            if (j == field[i].length - 1) {
                                out.print('\n');
                            }
                        }
                    }
                    out.println();
                    //fileMinefield(field, count, out);
                    count++;
                }
            }
            System.out.print("Finished, thank you for using this application!");
            out.close();
        }
        input.close();
    }

    /**
     * scanMinefield() method scans the file and constructs the minefield in a 2nd-dimensional
     * character array.
     * @param theScan   the scanner that scans the file
     * @return the 2nd-dimensional character array populated with the matching appropriate values.
     */
    private static char[][] scanMinefield(final Scanner theScan,
                                          final int theRows,
                                          final int theColumns) {
        int rows = 0;
        char[][] mineField = new char[theRows][theColumns];
        while (!theScan.hasNextInt()) {
            String text = theScan.next();
            //System.out.println(text);
            for (int i = 0; i < text.length(); i++) {
                mineField[rows][i] = text.charAt(i);
            }
            if (rows < theRows) {
                rows++;
            }

        }
        //Debugging purposes
//        for (int i = 0; i < rowsCheck; i++) {
//            for (int j = 0; j < columnsCheck; j++) {
//                System.out.print(Character.toString(mineField[i][j]));
//            }
//            System.out.println();
//        }
        return mineField;
    }

    /**
     * changeMinefield() method is used to determine the number of landmines that is surrounding a
     * specific position in the 2nd-dimensional array. Then, it replaces the parameter 2nd-dimensional
     * array's current position with the number found. If the current position is a landmine, then it
     * does not do anything.
     * @param theField     the passed 2nd-dimensional character array.
     * @return the finished 2nd-dimensional character array with the appropriate solution.
     */
    private static char[][] changeMinefield(final char[][] theField) {
        for (int i = 0; i < theField.length; i++) {
            for (int j = 0; j < theField[i].length; j++) {
                int count = 0;
                if (theField[i][j] != '*') {
                    if (i - 1 >= 0) {
                        if (j - 1 >= 0) {
                            if (theField[i - 1][j - 1] == '*') {
                                count++;
                            }
                        }
                        if (theField[i - 1][j] == '*') {
                            count++;
                        }
                        if (j + 1 < theField[i].length) {
                            if (theField[i - 1][j + 1] == '*') {
                                count++;
                            }
                        }
                    }
                    if (i + 1 < theField.length) {
                        if (j - 1 >= 0) {
                            if (theField[i + 1][j - 1] == '*') {
                                count++;
                            }
                        }
                        if (theField[i + 1][j] == '*') {
                            count++;
                        }
                        if (j + 1 < theField[i].length) {
                            if (theField[i + 1][j + 1] == '*') {
                                count++;
                            }
                        }
                    }
                    if (j - 1 >= 0) {
                        if (theField[i][j - 1] == '*') {
                            count++;
                        }
                    }
                    if (j + 1 < theField[i].length) {
                        if (theField[i][j + 1] == '*') {
                            count++;
                        }
                    }
                    theField[i][j] = String.valueOf(count).charAt(0);
                }
            }
        }
        return theField;
    }
}