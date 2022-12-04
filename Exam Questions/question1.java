import java.util.Scanner;

public class question1 {

    public static void main(String[] args) {
        // initates the user input
        Scanner nums = new Scanner(System.in);

        int user_number1, user_number2, user_number3;
        System.out.println("Please enter the first number: ");
        user_number1 = nums.nextInt();
        
        System.out.println("Please enter the second number: ");
        user_number2 = nums.nextInt();
        
        System.out.println("Please enter the third number: ");
        user_number3 = nums.nextInt();
        
        int sum_of_numbers = user_number1 + user_number2 + user_number3;
        System.out.println("The sum of three variables is: " + sum_of_numbers);
        
    }
    
}
