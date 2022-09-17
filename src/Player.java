import java.util.ArrayList;

public class Player {
    String name;
    int points;
    ArrayList<Die> diceList = new ArrayList<>();

    public Player(String s) {
        this.name = s;
        this.points = points;
        this.diceList = diceList;
    }

    public void rollDice() {
        for (Die die : diceList) {
            die.roll();
        }
    }

    public int getDieValue() {
        int sum = 0;
        for (Die die : diceList) {
            sum += die.getCurrentValue();
        }
        return sum;
    }

    public void increaseScore() {
        points++;
    }

    public void addDie(int sides) {
        Die newDie = new Die(sides);
        diceList.add(newDie);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public String toString() {
        return name;
    }
}
