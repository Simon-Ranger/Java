/* Project Name: VictoriaZoo
   Project Purpose: To display a main menu showing all the details of what the 
user(s) purchased, including prices, tickets and amount of people involved.
 */
package VictoriaZoo;

// @author Simon Ranger
public class MainMenu {
    
    // The 1st part of the menu display
    public void getTicketOptions() {
        // The heading of the menu
        System.out.println("@@@@ Welcome to VictoriaZoo @@@@\n");
        
        // Lets the user know it's the main menu of the site
        System.out.println("      M A I N  M E N U\n");
        
        // Lets the user know what the options will be for tickets
        System.out.println("The following options for tickets are: \n");
        
        // Prints out the options the user can choose from
        System.out.println("      0 = Child  (4-5 yrs)");
        System.out.println("      1 = Adult  (18+ yrs)");
        System.out.println("      2 = Senior (60+ yrs)\n");
                         
        // Lets the user know what the options will be for ticket prices
        System.out.println("The following options for prices are: \n");
        
        // Displays the price selection to the user
        System.out.println("      Child  = $18.00 per person");
        System.out.println("      Adult  = $36.00 per person");
        System.out.println("      Senior = $32.50 per person\n");
    }  
}