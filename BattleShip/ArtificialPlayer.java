package battleshipmodel;

public class ArtificialPlayer extends Player {
    
    public ArtificialPlayer(String name) {
        // Constructor that calls the parent constructor
        super(name);
    };
    
    public void takeGuess(HumanPlayer opponent) {
        /* Chooses an unguessed coordinate at random and tries to “hit” a ship. 
        Calls the Coordinate.tryHit() method to help with this. Prints the 
        message “Player 2 hit!” or “Player 2 missed!” as appropriate. */
        int x = (int) (Math.random() * OCEAN_SIZE);
        int y = (int) (Math.random() * OCEAN_SIZE);

        this.takeGuess(opponent, x, y);
    }
    
    private void takeGuess(HumanPlayer opponent, int x, int y) {
        /* Scan the ocean for coordinates that have been hit and choose one 
        adjacent coordinate(north, east, south or west) as the guess if 
        available. Scan left to right and top to bottom, if (1) fails, revert 
        to random guessing. */
        if (ocean[x][y].isHit()) {
          int a = (int) (Math.random() * 2) - 1;
          int b = (int) (Math.random() * 2) - 1;
          this.takeGuess(opponent, x + a, y + b);
        } else {
            if (ocean[y][x].tryHit()) {
            System.out.println("opponent hit!");
            super.hitsOnOpponent++;
        } else {
            System.out.println("opponent missed!");
            super.missesOnOpponent++;
        }
      }
    }
}
