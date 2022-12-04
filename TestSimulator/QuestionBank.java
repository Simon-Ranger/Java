package testsimulator;

// Imports packages needed
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class QuestionBank implements QuestionFinder {
    // Instances
    final static int[] CHAPTERS = new int[] {8,9,10,11,13,14,15,16};
    private int MULTIPLE_CHOICE_FIELDS = 8;
    private int TRUE_FALSE_FIELDS = 4;
    private String MULTIPLE_CHOICE_FILE = "multiple-choice-questions.csv";
    private String TRUE_FALSE_FILE = "true-false-questions.csv";
    private ArrayList<Question> questions;
    int counters = 0;
    int counter = 0;
    
    // Constructor 
    public QuestionBank() {
        questions = new ArrayList();
        loadMultipleChoiceQuestions();
        loadTrueFalseQuestions();
        System.out.println("Loaded all " + questions.size() + " questions from "
            + "the question bank.");
    }
    
    // Accessor method for chapters
    public int getLength() {
        return questions.size();
    }
    
    // Accessor method for question
    public Question getQuestion(int index) {
        return questions.get(index);
    }
    
    // Loads the multiple choice questions into the array
    public void loadMultipleChoiceQuestions() {
        Scanner s = null;
        
        // Could not open a file
        try {
            s = new Scanner(new FileInputStream(MULTIPLE_CHOICE_FILE));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        // Goes over the file and separates the lines
        while (s.hasNextLine()) {
            String file = s.nextLine();
            String[] sLine = file.split(",");
            counters++;

            // File row has incorrect number of fields.
            char c = 'a';
            
            try {
                c = sLine[7].charAt(0);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                break;
            }
            
            /* chapterNumber field was not numeric & chapterNumber field 
            was not one of the allowed chapter numbers.*/
            int qu = 0;
            
            try {
                qu = Integer.parseInt(sLine[1]);
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println(e.getMessage());
                break;
            }

            // questionID is found to be a duplicate
            String qID = null;
            
            try {
                qID = sLine[0];
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                break;
            }
            
            // correctAnswer field was not one of ‘a’ to ‘d’
            String qText = null;
            
            try {
                qText = sLine[3];
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());  
                break;
            }
            
            MultipleChoiceQuestion m = new MultipleChoiceQuestion(qID, qu, 
                sLine[2], sLine[3], qText, sLine[5], sLine[6], c);
                questions.add(m);
        }
    }
    
    // Loads the true/false questions into the arraylist
    public void loadTrueFalseQuestions()  {
        Scanner scan = null;
        
        // Could not open a file
        try {
            scan = new Scanner(new FileInputStream(TRUE_FALSE_FILE));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        // Goes over the file and separates the lines
        while (scan.hasNextLine()) {
            String file = scan.nextLine();
            String[] sLine = file.split(",");
            counter++;
            
            /* chapterNumber field was not numeric & chapterNumber field 
            was not one of the allowed chapter numbers.*/
            int cNumber = 0;
            
            try {
                cNumber = Integer.parseInt(sLine[1]);
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println(e.getMessage());
            }

            // questionID is found to be a duplicate
            String qID = null;
            
            try {
                qID = sLine[0];
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        
            // correctAnswer field was not one of ‘true’ or 'false'
            String qText = null;
            
            try {
                qText = sLine[2];
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());  
            }

            TrueFalseQuestion trueFalse = new TrueFalseQuestion(qID, cNumber,
                qText, true);
            questions.add(trueFalse);
        }  
    }
}
 