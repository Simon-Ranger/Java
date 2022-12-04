package testsimulator;

// Imports that are required for different libraries 
import java.util.Scanner;

public class TestSimulator {
    
    public static int getSelection() {
        // Prints out the menu options
        System.out.println("Welcome to the TestSimulator program menu."
            + "\n" + "Select from one of the following options.");
        System.out.println("(1) New test");
        System.out.println("(2) Test summary");
        System.out.println("(3) Exit");
        
        System.out.println("Enter your selection: ");
        Scanner scanner = new Scanner(System.in);
        String x = scanner.nextLine();
        Scanner input = new Scanner(x);
        int choice = 0;

        // Asks the user to enter again if non-number is given
        if (!input.hasNextInt()) {
            System.out.println("Please enter your selection again.");
        } else {
            choice = input.nextInt();
        }
        
        return choice;
    }
    
    public static void main(String[] args) {
        QuestionBank questionBank = new QuestionBank();
        Test test = new Test(5, questionBank);
//        test.showTestSummary();
//        test.saveTestResults();
        
        // Loops through the options until 3 is selected, then exits
        int choice;
        while ((choice = getSelection())!= 3) {
           switch (choice) {
               case 1:
                   System.out.println("");
                   System.out.println("Welcome to your test." + "\n" + "The "
                        + "test will have 5 questions.");
                   System.out.println("You may hit 'q' to quit the test any "
                           + "time," + "\n" + "but progress won't be saved.");
                   System.out.println("Starting your test now..." + "\n");
                   test.runTest();
                   break;
               case 2:
                   System.out.println("Performance report...");
                   TestSummary ts = new TestSummary();
                   ts.summarisePerformance();
                   ts.reportPerformance();
                   break;
               default:
                   System.out.println("Thank you for using TestSimulator!");
                   break;
           }
       }  
       System.out.println("Thank you for using TestSimulator!");
    }
}


