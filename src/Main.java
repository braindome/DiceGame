import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        ArrayList<Player> playerList = initialize();
        takeTurn(playerList);
        takeTurn(playerList);
        takeTurn(playerList);
        takeTurn(playerList);
        takeTurn(playerList);
        getWinners(playerList);
    }

    private static ArrayList<Player> initialize() {

        ArrayList<Player> playerList = new ArrayList<>();
        System.out.println("Enter number of players:");
        int playerNumber = sc.nextInt();
        System.out.println("Enter number of dices:");
        int diceNumber = sc.nextInt();
        System.out.println("Enter number of dice faces:");
        int diceFaces = sc.nextInt();

        sc.nextLine();
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

    private static void takeTurn(ArrayList<Player> players) {
        for (Player p : players) {
            p.rollDice();
            System.out.println("Psssst hint: " + p.getDieValue());
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

    private static ArrayList<Player> getWinners(ArrayList<Player> players) {
        ArrayList<Integer> scoreBoard = new ArrayList<>();
        int topScore = 0;
        System.out.println("Score summary:");
        for (Player p : players) {
            System.out.println(p + "  " + p.getPoints());
            scoreBoard.add(p.getPoints());
        }


        return players;
    }

}