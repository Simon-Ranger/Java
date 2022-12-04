package VictoriaZoo;

// Imports that are required for different libraries 
import java.util.Scanner;

public class UserInput {
    /* Sets the variables that will be used, having it here lets it work 
    regardless of the method*/
    int ticketOrder, ticketNumber;
    double[] ticketAmount = {18.00, 36.00, 32.50};
    Scanner scanner = new Scanner(System.in);
    int confirmOrder = 1;
    
    // This method runs the main part of user interaction
    public void ticketChoice() {
        // Asks the user for a ticket select and prints the message
        System.out.println("Please select one of the ticket number "
            + "options provided: ");
        // Obtains the input from the user via the console
        ticketOrder = scanner.nextInt();
        
        // Checks if the user input is correct
        while (ticketOrder > 2) {
            System.out.println("Incorrect input, please provide a correct "
                + "input displayed on the menu before continuing:");
            ticketOrder = ticketOrder = scanner.nextInt();
        }
          
        // Asks the user for the amount of tickets they want
        System.out.println("Enter the number of tickets you would like "
            + "to purchase: ");
        ticketNumber = scanner.nextInt();
        
        /* Lets the user know how much their order is by adding the ticket
        option with the amount of tickets*/
        System.out.println("Your order is " + ticketNumber + " ticket(s) at " 
            + "$" + ticketAmount[ticketOrder] + " each!");
        
        confirm();
    }
    
    public void confirm() {
        // Instructs the user to confirm the order 
        System.out.println("Please press 1 to confirm the order: ");
        confirmOrder = scanner.nextInt();
        
        /* If user doesn't want to confirm or presses the wrong button they are
        sent back to the main menu*/
        if (confirmOrder != 1) {
            System.out.println("Incorrect key, going to main menu...\n");
            MainMenu mainMenu = new MainMenu();
            mainMenu.getTicketOptions();
        } else {
           /* If user confirms they are shown the total amount for their current
           order*/
           System.out.println("Total amount for " + ticketNumber 
            + " ticket(s): " + "$" + ticketNumber * ticketAmount[ticketOrder]); 
        }
    }
    
    public void proceed() {
        String proceeding;
        boolean yn = true;
        // Calulates the total amount for tickets selected by user
        int totalAmount = (int)(ticketNumber * ticketAmount[ticketOrder]);
        Scanner p = new Scanner(System.in);
        
        // Lets the user decide to continue ordering or finalise payment
        while (yn) {
            System.out.println("Do you want to continue or finalise your "
            + "purchase? [y/n]");
            proceeding = p.nextLine(); 
            
            switch(proceeding) {
                // If "y" is pressed user will be directed to the main menu
                case "y":
                    MainMenu mainMenu = new MainMenu();
                    mainMenu.getTicketOptions();
                    ticketChoice();
                // If "n" is pressed the total amount for the order is shown
                case "n":
                    System.out.println("Total amount payable is: $" + 
                        totalAmount + "\n" + "have a nice day");
            }
            
            // Exits the code once the user selects the "n" option
            System.exit(0);
        }
        
        
    }
}
