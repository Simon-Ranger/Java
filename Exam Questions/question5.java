import java.util.Random;
import java.util.Scanner;

public class question5 {

    public static void main(String[] args) {
        Random num = new Random();
        int guessNumber = num.nextInt(10);
        Scanner guess = new Scanner(System.in);
        int nums = 5;
        
        
        System.out.println("Guess a number between 1 and 10: ");
        guessNumber = guess.nextInt();
        
        if (nums == guessNumber) {
            System.out.println("You won the game");
        } else {
            System.out.println("invaild guess");
        }
        
    }
    
}
