package part2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;

public class FootballScores {
    // Instances 
    private final static int NUM_ROUNDS = 5;
    private final static int MAX_SHOTS = 10;
    private final static String TEXT_FILE = "text-scores.txt";
    
    // Writes the scores to a file 
    public static void writeTextScores() throws FileNotFoundException {
        Random rand = new Random();
        int rounds = rand.nextInt(10);
        
        PrintWriter printing = new PrintWriter(TEXT_FILE);
        printing.print(rounds);
        
        String files = printing.toString();
        String[] sLine = files.split(",");
        
        
    }
    
    // Reads the scores from a file
    public static void printTextScores() throws FileNotFoundException {
        
    }

    public static void main(String[] args) throws FileNotFoundException {
        writeTextScores();
        printTextScores();
    }
    
}

/*
TASK 2 - QUESTION 5 Answers!
a) I would have to change the way i'm writing to the file 
b) DataInput
c) DataOutput
d) You could use a try/catch statement when exception handling
*/
