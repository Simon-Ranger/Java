/* Project Name: wordGames
   Project Purpose: To have a set of word games involving different tasks.
 */

package WordGames;

// Imports that are required for different libraries 
import java.util.regex.*;
import java.util.Scanner;

public class WordGames {
    /* Sets the variables that will be used, having it here lets it work 
    regardless of the method*/

    // Lets the user have input on the console
    static Scanner scanner = new Scanner(System.in);

    // Dictionary list of words used throughout the games
    static String[] dictionary = new String[] {"passersby", "absobloominglutely"
        , "nana", "banana", "the", "quick", "brown", "fox", "jumps", "over", 
        "the", "lazy", "dog", "a", "mm", "wow", "noon", "radar", "redder", 
        "racecar", "redivider", "aibohphobia", "tattarrattat"};
    
    /* Int method using regex to gather the pattern of letters with the words
    used in the dictionary*/
    public static int countMatches(String regex, String input, int multiplier) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        int counter = 0;
        while (matcher.find()) {
            counter++;
        }
        return counter * multiplier;
    }
	
    // Main menu where the user selects what game to play
    public static void getSelection() {
        
        String choices = "";

        // The welcoming message
        System.out.println("Welcome to the Word Games program menu. Select"
                + "from one of the following options: ");
        // The four (4) options the user can choose from
	System.out.println("1. Substring problem");
	System.out.println("2. Points problem");
	System.out.println("3. Palindrome problem");
	System.out.println("4. Exit");
	/*gets the user input in what they wanted to select and goes to that 
        section*/
	System.out.println("Please enter your selection: ");
	scanner.nextInt();

        // Helps let the program know what method to jump to based on user input
        switch (choices) {
            case "1":
                substringProblem("t");
            case "2":
                pointsProblem();
            case "3":
                palindromeProblem();
            case "4":
		exitProgam();
                break;
        }
    }

    // First game of the program containing a subtring problem
    public static void substringProblem(String input) {
        
        // Loops through the words finding what starts and ends with "t"
        for (String word: dictionary) {
            boolean prefix = word.startsWith(input);
            boolean suffix = word.endsWith(input);
            boolean infix = false;
           
           // Checks the length of the words
           if (word.length() > 1) {
             String innerString = word.substring(1, word.length() - 1);
             infix = innerString.equals(input);
           } else {
             infix = word.equals(input);
           } 

            // Checks to see what is and isn't containing "t"
            if (!prefix && !suffix && !infix) {
              System.out.println(word + " - not found");
            } else {
              String result = ""; 
              result += prefix ? " - prefix" : "";
              result += infix ? " - infix" : "";
              result += suffix ? " - suffix" : "";
              System.out.println(word + result);
          }
        }
		
	// Redirects back to the menu option page
        getSelection();
    }
	
    // Second game user can play, consisting of a point problem system
    public static void pointsProblem() {

        // Loops through the dictionary list looking for these letters
        for (String word: dictionary) {
            
            int points = 0;
            
            // Calculates the letters/words based on the countMatches method
            points += countMatches("[aeilnorstu]+", word, 1);
            points += countMatches("[dg]+", word, 2);
            points += countMatches("[bcmp]+", word, 3);
            points += countMatches("[fhvwy]+", word, 4);
            points += countMatches("[k]+", word, 5);
            points += countMatches("[jx]+", word, 8);
            points += countMatches("[qz]+", word, 10);
            System.out.println(word + " is worth " + points);
        }

        // Redirects back to the menu option page
        getSelection();
    }
	
    // The final gaming option for the user 
    public static void palindromeProblem() {

        for (String words: dictionary) {
            
            StringBuilder reversed = new StringBuilder();
            
            reversed.append(words);
            reversed = reversed.reverse();
            
            // Checks if the word is a palindrome or not
            if (!words.contains(reversed)) {
                System.out.println(words + " is not a palindrome");
            } else {
                System.out.println(words + " is a palindrome");
            }
        }
    
        getSelection();
    }
	
    // Final stage exiting the game program
    public static void exitProgam() {

        // Lets the user know program is closing before it closes
        System.out.println("Closing game...Goodbye!");
		
	// Exits the program once option 4 is selected in the menu selection
        System.exit(0);
    }
	
    // The main method that runs through all other classes making them run
    public static void main(String[] args) {
		
        // Sets the different methods in order of being ran
	WordGames.getSelection();
	WordGames.substringProblem("t");
	WordGames.pointsProblem();
	WordGames.palindromeProblem();
        WordGames.exitProgam();
    }
}