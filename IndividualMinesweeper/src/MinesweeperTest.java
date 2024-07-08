import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Game.Minesweeper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class MinesweeperTest {

    @Test
    public void testPromptForFileName() {
        Scanner scanner = new Scanner("input.txt\n");
        String fileName = Minesweeper.promptForFileName(scanner);
        assertEquals("input.txt", fileName);
    }

    @Test
    public void testProcessMinefields() throws FileNotFoundException {
        Scanner input = new Scanner(new File("input.txt"));
        PrintStream out = new PrintStream(new File("testOutput.txt"));
        Minesweeper.readAndWrite(input, out);
        // Further checks can be done to verify the file output if needed
    }

    @Test

    public void testScanMinefield() {
        Scanner scanner = new Scanner("4 4\n*...\n....\n.*..\n....\n");
        char[][] mineField = Minesweeper.scanMinefield(scanner, 4, 4);
        assertEquals('*', mineField[0][0]);
        assertEquals('.', mineField[0][1]);
    }

    @Test
    public void testChangeMinefield() {
        char[][] mineField = {
                { '*', '.', '.', '.' },
                { '.', '.', '.', '.' },
                { '.', '*', '.', '.' },
                { '.', '.', '.', '.' }
        };
        char[][] changedMineField = Minesweeper.changeMinefield(mineField);
        assertEquals('1', changedMineField[0][1]);
        assertEquals('0', changedMineField[0][1]);
    }

    @Test
    public void testWriteMinefield() throws FileNotFoundException {
        char[][] mineField = {
                { '*', '1', '0', '0' },
                { '1', '2', '1', '0' },
                { '0', '1', '*', '1' },
                { '0', '1', '1', '1' }
        };
        PrintStream out = new PrintStream(new File("testWriteOutput.txt"));
        Minesweeper.writeMinefield(out, mineField, 1);
        // Further checks can be done to verify the file output if needed
    }
}