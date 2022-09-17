import java.util.Random;

public class Die {
    int currentValue;
    int numberOfFaces;
    private static final Random random = new Random();

    public Die(int numberOfFaces) {
        this.numberOfFaces = numberOfFaces;
    }

    public void roll() {
        currentValue = random.nextInt(numberOfFaces) + 1;
    }

    public int nextInt(int maxValue) {
        return maxValue;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public int getNumberOfSides() {
        return numberOfFaces;
    }
}
