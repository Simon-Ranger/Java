package battleshipgame;

// Imports the required models
import battleshipmodel.*;

public class BattleshipGame {

    public static void main(String[] args) {
        /*For the AI to play itself
        ArtificialPlayer player1 = new ArtificialPlayer("Player 1 substitute");
        ArtificialPlayer player2 = new ArtificialPlayer("Player 2");*/
        
        HumanPlayer player1 = new HumanPlayer("Player1");
        ArtificialPlayer player2 = new ArtificialPlayer("Player2");

        System.out.println("Welcome to the Battleship game.\n");
        
        /* */
        int turn = 1;
        while (true) {
            System.out.println("It's turn: " + turn++);
            
            // Shows the grid if it's the opponents turn
            if (turn % 2 == 0) {
                System.out.println("It's your turn");
                System.out.println("Target grid (opponent):"); 
                player2.printOcean(false);
                System.out.println("Ocean grid (you):");
                player1.printOcean(true);
                player1.takeGuess(player2);
            } else {
                System.out.println("It's opponents turn");
                player1.printOcean(false);
                player2.takeGuess(player1);
            }

            if (player1.hasWon() && player2.hasWon()) {
                System.out.println("Great game...it's a DRAW!");
            } else if (player2.hasWon()) {
                System.out.println("The computer has won!");
            } else if (player1.hasWon()) {
                System.out.println("Congratulations you WON!");
            } 
            if (player1.hasWon() || player2.hasWon()) {
                break;
            }
        }
        
        // Thanks the player for playing
        System.out.println("Thanks for playing!");
    }
}