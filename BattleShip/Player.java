package battleshipmodel;

// Player class contains a default implementation for a player.
// This class could represent a simple human or artificial player.
public class Player {
    
    int OCEAN_SIZE = 10;
    int FLEET_SIZE = 5;
    int HITS_TO_WIN = 17;
    int hitsOnOpponent;
    int missesOnOpponent;
    Coordinate[][] ocean;
    Ship[] fleet;
    
    enum Orientation {
        HORIZONTAL, VERTICAL;
    }
    
    public Player(String name) {
        /*Constructor to initialise instance variables. Also calls the 
        placeFleet() method as this is part of the initialisation*/
        hitsOnOpponent = 0;
        missesOnOpponent = 0;
        /* Grid representing the player’s ocean. 
        Dimensions: OCEAN_SIZE * OCEAN_SIZE */
        ocean = new Coordinate[10][10];
        for (int i = 0; i < ocean.length; i++) {
            for (int j = 0; j < ocean.length; j++) {
                ocean[i][j] = new Coordinate();
            }
        }
        // Fleet of the five ships. Length: FLEET_SIZE.
        fleet = new Ship[]{ 
        new Ship("Aircraft Carrier", 5),
        new Ship("Battleship", 4),
        new Ship("Cruiser", 3),
        new Ship("Submarine", 3),
        new Ship("Destroyer", 2)
    };
        
        placeFleet();
    };
    
    public Coordinate[][] getOcean() {
        // Accessor method for “ocean”.
        return ocean;
    };

    public void placeFleet() {
        /*Places the five ships at random locations in random orientations.
        The ship will be placed in an easterly direction from the coordinate 
        when in horizontal orientation, or the ship will be placed in a 
        southerly direction from the coordinate when in vertical orientation.
        Checks are made to make sure any ship does not exceed the boundary of 
        the ocean or overlap with another ship.*/
        for (int i = 0; i < fleet.length; i++) {
            Ship ship = fleet[i];
            boolean place = false;
            
            while (!place) {
                int x = (int) (Math.random() * 10);
                int y = (int) (Math.random() * 10);
            
                Orientation orientation = Math.random() < 0.5 ? 
                    Orientation.HORIZONTAL : Orientation.VERTICAL; 

                if (checkOcean(x, y, orientation, ship.getLength())) {
                    place = true;
                    placeShip(x, y, orientation, ship);
                }
            }
        }
    }
    
    public void printOcean(boolean showShips) {
        /*Prints the OCEAN_SIZE * OCEAN_SIZE ocean grid. Uses information from 
        the Coordinate.printCoordinate(showShips) method for the contents of 
        the individual coordinates*/
        System.out.print(" ");
        for (int i = 0; i < ocean.length; i++){
            System.out.print("   " + i);
        }
        
        System.out.println();
        
        int q = 0, i = 0;
        while (!(q % 2 == 1 && i == ocean.length)) {
            if (q % 2 == 0) {
                System.out.print("  +");
                for (int j = 0; j < ocean.length; j++){
                    System.out.print("---+");
                }
            } else {
                System.out.print(i + " |"); 
                for (int j = 0; j < ocean.length; j++){
                    String pco = ocean[i][j].printCoodinate(showShips);
                    System.out.print(" " + pco + " |");
                }
                i += 1;
            }
            q += 1;
            System.out.println();
        }
    } 
    
    private boolean checkOcean(int x, int y, Orientation orient, int length) {
    
        for (int k = 0; k < length; k++) {
            int currentX = x;
            int currentY = y;
            if (orient == Orientation.HORIZONTAL) {
                currentX = x + k;
            } else {
                currentY = y + k;
            }
            
            if (!this.checkCoordinate(currentX, currentY)) {
            return false;
            }
        }

        return true;
    }
    
    private void placeShip(int x, int y, Orientation o, Ship s) {
        
        for (int k = 0; k < s.getLength(); k++) {
            int currentX = x;
            int currentY = y;
            if (o == Orientation.HORIZONTAL) {
                currentX = x + k;
            } else {
                currentY = y + k;
            }
            Coordinate c = ocean[currentX][currentY];
            c.setSHIP(s);
        } 
    }
    
    private boolean checkCoordinate(int x, int y) {
        if (x < 0 || y < 0 || x > ocean.length -1 || y > ocean.length -1) {
            return false;
        }
        
        Coordinate cor = ocean[x][y];
        
        return !cor.hasShip();
    }
    
    public boolean hasWon() {
        // Returns true if all 17 ship spaces have been hit, otherwise false.
        boolean won = (HITS_TO_WIN == hitsOnOpponent);
        
        return won;
    };
} 