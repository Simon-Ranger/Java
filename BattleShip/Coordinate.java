package battleshipmodel;

// Class Coordinate contains all implementation for one coordinate of the ocean
// for any player. Can be references when dealing with a player's ocean or
// the opponent's "target" ocean.
public class Coordinate {
    String HIT;
    String MISS;
    String EMPTY;
    String UNKNOWN;
    Ship ship;
    private boolean isHit;
    
    public Coordinate() {
        // Constructor to initialise variables
        HIT = "x";
        MISS = "-";
        EMPTY = " ";
        UNKNOWN = " "; 
        isHit = false;
    };
    
    public void setSHIP(Ship ship) {
        // Mutator method for “ship”
        this.ship = ship;
    };
    
    public boolean hasShip() {
        // Returns true if the coordinate has a ship, otherwise false.
        return this.ship != null;
    };
    
    public boolean isHit() {
        // Accessor method for “isHit”
        return isHit;
    };
    
    public boolean tryHit() {
        // Sets “isHit” to true. Returns value of “hasShip()”.
        isHit = true;
        return hasShip();
    };
    
    public String printCoodinate(boolean showShip) {
        /*Returns a one-character string regarding the coordinate as per the 
        following truth table. The strings are either the output of the 
        getInitial() method or one of the indicated constants.*/ 
        if (isHit()) {
            if (hasShip()) return showShip ? HIT : HIT;
            else return showShip ? MISS : MISS;
        } else {
            if (hasShip()) {
                String initial = String.valueOf(this.ship.getInitial());
                return showShip ? initial : UNKNOWN;
            } else {
                return showShip ? EMPTY : UNKNOWN;
            }
        }
    }
}
