package VictoriaZoo;

public class Main {

    // The main method that runs through all other classes making them run
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        mainMenu.getTicketOptions();
        UserInput userInput = new UserInput();
        userInput.ticketChoice();
        userInput.proceed();
        userInput.confirm();
    } 
}
