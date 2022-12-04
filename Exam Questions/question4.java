import java.util.Scanner;

public class question4 {

    public static void main(String[] args) {
        boolean b1 = true;
        boolean b2 = true;
        String username = Boolean.toString(b2);
        String password = Boolean.toString(b1);
        
        Scanner name = new Scanner(System.in);
        
        System.out.println("Enter your business name: ");
        username = name.nextLine();
        
        if ("LaTrobe".equals(username)) {
            System.out.print("please input the business location: \n");
            username = name.nextLine();
            
        } else if (!"LaTrobe".equals(username)){
            System.out.println("invalid business name");
        } else {
            if ("Melbourne".equals(password)) {
                System.out.println("Welcome to AIMS");
                password = name.nextLine();
            } else {
                System.out.println("invalid business location");
            }
        }
    }
    
}
