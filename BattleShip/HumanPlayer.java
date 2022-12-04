package battleshipmodel;

import java.util.Scanner;

public class HumanPlayer extends Player {
    
    public HumanPlayer(String name) {
        // Constructor that calls the parent constructor
        super(name);
    };
    
    public void takeGuess(ArtificialPlayer opponent) {
        /* Prompts the user to choose an unguessed coordinate and try to “hit” a 
        ship. Calls the Coordinate.tryHit() method to help with this. Prints 
        the message “You hit!” or “You missed!” as appropriate.*/
        Scanner input = new Scanner(System.in);
        System.out.println("Your turn: ");
        
        System.out.println("Enter X coordinate: ");
        int x = input.nextInt();
        
        System.out.println("Enter Y coordinate: ");
        int y = input.nextInt();
        
        if (ocean[y][x].tryHit()) {
            System.out.println("You hit!");
            super.hitsOnOpponent++;
        } else {
            System.out.println("You missed!");
            super.missesOnOpponent++;
        }
    }
};