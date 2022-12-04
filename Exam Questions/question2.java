import java.util.Scanner;

public class question2 {

    public static void main(String[] args) {
       Scanner numb = new Scanner(System.in);
       
       System.out.println("Enter a number: ");
       int number = numb.nextInt();
       
       if (number > 0) {
           System.out.println("The number is positive");
       } else {
           System.out.println("The number is negative");
    }
    }
    
}
