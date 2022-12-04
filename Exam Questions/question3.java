import java.util.Scanner;

public class question3 {

    public static void main(String[] args) {
        Scanner numbers = new Scanner(System.in);
        boolean numb = true;
        int number1, number2, number3;
        
        
        System.out.println("Enter three numbers: ");
        number1 = numbers.nextInt();
        number2 = numbers.nextInt();
        number3 = numbers.nextInt();
        
        if (numb != true) {
            System.out.println("All numbers are different");
        } else {
            System.out.println("All numbers are equal");
        }
        
    }
    
}
