package part2;

import java.util.Scanner;

public class FootballGame {
    int roundNumber;
    int homeGoals;
    int homeBehinds;
    int awayGoals;
    int awayBehinds;
    
    // Constructor
    public FootballGame(int roundNumber, int homeGoals, int homeBehinds, 
        int awayGoals, int awayBehinds) {
        roundNumber = 0;
        homeGoals = 0;
        homeBehinds = 0;
        awayGoals = 0;
        awayBehinds = 0;
    }
    
    // Summarizes the scores
    public String summarize() {
        int homeCalc = homeGoals++ + homeBehinds++;
        int awayCalc = awayGoals++ + awayBehinds++;
        
        if (homeCalc > awayCalc) {
            System.out.println(roundNumber++ + ": " + "Home team won" + homeCalc
                + "to" + awayCalc);
        } else if (awayCalc > homeCalc) {
            System.out.println(roundNumber++ + ": " + "Home team lost" + 
                homeCalc + "to" + awayCalc);
        } else if (homeCalc == awayCalc){
            System.out.println(roundNumber++ + ": " + "Match was tied" + 
                homeCalc + awayCalc + "points each.");
        }
        return null;
    }
    
    // Separates everything with commas
    public String toString() {
        Scanner scan = null;
        while (scan.hasNext()) {
            String file = scan.nextLine();
            String[] sLine = file.split(",");
            this.summarize();
        }
        return null;
    }
}
