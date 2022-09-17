import javax.naming.PartialResultException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        //The player list is initialized. Game method is invoked five times.
        ArrayList<Player> playerList = initialize();
        takeTurn(playerList);
        takeTurn(playerList);
        takeTurn(playerList);
        takeTurn(playerList);
        takeTurn(playerList);
        getWinners(playerList);
    }

    private static ArrayList<Player> initialize() {

        //Initialize object list and int variables. Input is requested.
        ArrayList<Player> playerList = new ArrayList<>();
        System.out.println("Enter number of players:");
        int playerNumber = sc.nextInt();
        System.out.println("Enter number of dices:");
        int diceNumber = sc.nextInt();
        System.out.println("Enter number of dice faces:");
        int diceFaces = sc.nextInt();


        sc.nextLine();
        //This loop assigns a player ID, depending on the number of players.
        for ( int i = 0; i < playerNumber; i++) {
            System.out.println("Enter Player " + (i+1) + " name:");
            String name = sc.nextLine();
            playerList.add(new Player(name));
            for (int dice = 0; dice < diceNumber; dice++) {
                playerList.get(i).addDie(diceFaces);
            }

        }
        return playerList;
    }

    //Rolls the dice(s) for each player, takes in a guess and compares it with the rolled number.
    //Added a print for testing (commented out)
    private static void takeTurn(ArrayList<Player> players) {
        for (Player p : players) {
            p.rollDice();
            //System.out.println("Psssst hint: " + p.getDieValue());
            System.out.println(p + ", guess a number:");
            int guess = sc.nextInt();
            if (guess == p.getDieValue()) {
                System.out.println("You've guessed right!");
                p.increaseScore();
            } else {
                System.out.println("Fail.");
            }
            System.out.println("End of turn");
        }
    }

    //Creates a list of winner(s) and prints it.
    private static ArrayList<Player> getWinners(ArrayList<Player> players) {
        int topScore = 0;
        ArrayList<Player> winners = new ArrayList<>();
        //The for loop goes through the player list and assigns a top score.
        for (Player p : players) {
            if (p.getPoints() > topScore) {
                topScore = p.getPoints();
                }
            }
        //Then the if statement adds the highest score connected to the object to the winner list by going again through
        //all the players in the players list.
        if (topScore > 0) {
            for (Player p : players) {
                if (p.getPoints() == topScore) {
                    winners.add(p);
                }
            }
        }
        //Conditional statments depending on the outcome of the game.
        if (winners.size() == 0) {
            System.out.println("You are all failures");
        } else if (winners.size() == 1) {
            System.out.println("And the winner is: " + winners);
        } else {
            System.out.println("We have a tie! The winners are " + winners);
        }
        return winners;


    }


}

