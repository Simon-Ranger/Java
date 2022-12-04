package testsimulator;

import java.util.Scanner;

public class TestSummary {
    // Instances
    final static String FILENAME_SUMMARY = "test-summary.txt";
    private static int TEST_REPORT_FIELDS;
    private int chapterQuestionsAnswered;
    private int chapterQuestionsCorrect;
    
    // Constructor
    public TestSummary() {
        TEST_REPORT_FIELDS = 4;
        chapterQuestionsAnswered = 8;
        chapterQuestionsCorrect = 8;
    }
    
    public void summarisePerformance() {
        int score = chapterQuestionsAnswered + chapterQuestionsCorrect;
        
        // Opens the summary test file
        try {
          Scanner sp = new Scanner("test-yymmdd-hhmmss.txt\"");  
          while (sp.hasNext()) {
              // Calculates the total correct answers from total questions
              System.out.println("You answers " + chapterQuestionsCorrect + 
                "correctly out of " + chapterQuestionsAnswered);
              System.out.println("Your score was " + score);
          }
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void reportPerformance() {
        int totalCorrect = chapterQuestionsCorrect + TEST_REPORT_FIELDS;
        int totalAnswered = chapterQuestionsAnswered + TEST_REPORT_FIELDS;
        int totalPercent = chapterQuestionsCorrect + chapterQuestionsAnswered;
        
        System.out.println("Performance report...");
        System.out.println();
    }
}
