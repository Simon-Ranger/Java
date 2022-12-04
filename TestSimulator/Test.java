package testsimulator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Random;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Test implements QuestionFinder {

    // Instances

    private ArrayList<Question> questions;

    // Constructor
    public Test(int numQ, QuestionBank questionBank) {
        questions = new ArrayList();

        if (numQ > questionBank.getLength()) {
            System.out.println("The question bank does not have " + numQ
                    + " questions." + "\n");
            System.out.println("The test will have " + questionBank.getLength()
                    + " questions instead");
            numQ = questionBank.getLength();
        }
        selectQuestions(numQ, questionBank);
    }

    // Accessor method
    public int getLength() {
        return questions.size();

    }

    // Randomly selects questions from the list
    void selectQuestions(int numQ, QuestionBank questionBank) {
        Random r = new Random();

        for (int i = 0; i < numQ; i++) {
            int randomNum = r.nextInt(questionBank.getLength());
            Question question = questionBank.getQuestion(randomNum);

            if (containsQuestion(question.getQuestionID(), questions)) {
                i--;
                continue;
            }
            questions.add(question);
            System.out.println(question.getQuestionID());
        }

    }

    // Runs a test and reprompts for invaild answers
    public boolean runTest() {
        int quest = 0;
        Scanner input = new Scanner(System.in);

        // Runs the test one question at a time
        for (Question question : questions) {
            System.out.println("question: " + ++quest + " "
                    + question.getQuestionText());

            // Checks if multiple choice or true/false questions
            if (question instanceof MultipleChoiceQuestion) {
                char c = 'a';

                for (String s : ((MultipleChoiceQuestion)question).getAnswers())
                {
                    System.out.println(c++ + ": " + s);
                }
            } else {
                System.out.println("true");
            }

            boolean answer = false;
            char answer1 = 'a';
            do {
                // Asks user for input
                System.out.println("Enter your answer: ");
                String c = input.nextLine();
                System.out.println("");
                
                // Checks for wrong input
                if(c.length() != 1) {
                    System.out.println("Character is needed!");
                }
                else{
                    /*Lets user quit anytime by clicking 'q' & returns you to
                    the menu screen*/
                    answer1 = Character.toLowerCase(c.charAt(0));
                    if (answer1 == 'q') {
                       System.out.println("Exiting test");
                       TestSimulator.getSelection();
                       answer = false;
                    // Checks if the question is multiple choice or true/false
                    }else if (question instanceof MultipleChoiceQuestion && 
                            answer1 >= 'a' && answer1 <= 'd') {
                        answer = true;
                        ((MultipleChoiceQuestion)question).
                            setChosenAnswer(answer1);
                    } else if (question instanceof TrueFalseQuestion && answer1 
                            >= 'a' && answer1 <= 'b') {
                        answer = true;
                        ((TrueFalseQuestion)question).
                            setChosenAnswer(answer1  == 'a' ? true : false);
                    } else {
                        System.out.println("Invaild answer, please try again!");
                    }
                }
            } while (!answer);

       
            // Gives instant feedback on the answers given
            if (question instanceof MultipleChoiceQuestion && answer1 >= 'a' && 
                answer1 <= 'd') {
                ((MultipleChoiceQuestion)question).isAnswerCorrect();
                // Prints out a message with the correct answer
                System.out.println(("Feedback: Incorrect. Correct answer was " 
                    + MultipleChoiceQuestion)question).getCorrectAnswer();
            } else if (question instanceof TrueFalseQuestion && answer1 >= 'a' 
                && answer1 <= 'b') {
                ((TrueFalseQuestion)question).isAnswerCorrect();
                System.out.println(("Feedback: Incorrect. Correct answer was " 
                    + TrueFalseQuestion)question).getCorrectAnswer();
            } else {
                System.out.println("Feedback: Correct!");
            }
        }
        return true;
    }

    // Prints a summary performance
    public void showTestSummary() {
        double obtainedScore = 0, totalScore = 5;
        float Percentage;
        Percentage = (float) ((obtainedScore * 100) / totalScore);
        
        for (Question question : questions) {
            System.out.println("question: " + ++obtainedScore + " "
                    + question.isAnswerCorrect());
            
            System.out.println(("You answered " + MultipleChoiceQuestion)
                question.isAnswerCorrect() + "questions correctly out of " + 
                    questions.size());
            
            System.out.println("Your score was " + Percentage + "%");
        }
    }

    // Saves the results to a file
    public void saveTestResults() {
        // Creates the files & saves the data
        try {
            Scanner s = new Scanner((Path) new FileOutputStream("test-yymmdd-"
                    + "hhmmss.txt"));
            s.nextLine();

        } catch (IOException e) {
            System.out.println("error: could not save file");
            System.exit(0);
        }

        // Sets the time
        LocalDateTime current = LocalDateTime.now();
        // Formates the date
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd-MM-yyyy "
                + "HH:mm:ss");
        String formatDateTime = current.format(date);

        // Prints out the date and time
        System.out.println("File saves on: " + formatDateTime
                + "Test result saved to test-180612-110754.txt.");
        System.out.println("File saves on: " + formatDateTime
                + "Test record added to test-summary.txt.");
    }
}
