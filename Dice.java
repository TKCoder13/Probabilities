import java.util.Random;

public class Dice {

    public static Random rn = new Random();

    public static int roll(int sides) {
        return rn.nextInt(sides) + 1; // [1...6]
    }
    public static void OneDie() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        int sidesOfDice = 8;
        int N = 1000000;
        double sum = 0;
        int currentRoll = 0;
        for (int i = 0; i < N; i++) {
            currentRoll = roll(sidesOfDice);
            if (currentRoll == 1) {
                ++rolls[currentRoll];
                // System.out.println(currentRoll + " @ " + "1");
            } else if (currentRoll == 2) {
                ++rolls[currentRoll];
                // System.out.println(currentRoll + " @ " + "2");
            } else if (currentRoll == 3) {
                ++rolls[currentRoll];
                // System.out.println(currentRoll + " @ " + "3");
            } else if (currentRoll == 4) {
                ++rolls[3];
                // System.out.println(currentRoll + " @ " + "4");
            } else if (currentRoll == 5) {
                ++rolls[4];
                // System.out.println(currentRoll + " @ " + "5");
            } else if (currentRoll == 6) {
                ++rolls[5];
                // System.out.println(currentRoll + " @ " + "6");
            } else if (currentRoll == 7) {
                ++rolls[5];
                // System.out.println(currentRoll + " @ " + "7");
            } else {
                ++rolls[5];
                // System.out.println(currentRoll + " @ " + "8");
            }
        }
        for (int i = 1; i <= sidesOfDice; i++) {  
            System.out.println("The dice has rolled \"" + i + "\" " + rolls[i] + " times.");
            System.out.println(i + " --> " + (double)rolls[i] / N);
            sum += (double)rolls[i-1] / N;
        }
        System.out.println("The sum of the probabilities is: " + sum);
    }

    public static void TwoDice() {
        int dice[] = {0,0};
        int probs[] = new int[17]; //Ignore index 0
        long N = 1000000;
        int sidesOnDie = 8;
        int currentRoll = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < dice.length; j++) {
                currentRoll = roll(sidesOnDie);
                if (currentRoll == 1) {
                    dice[j] = currentRoll;
                    // System.out.println(currentRoll + " @ " + "1");
                } else if (currentRoll == 2) {
                    dice[j] = currentRoll;
                    // System.out.println(currentRoll + " @ " + "2");
                } else if (currentRoll == 3) {
                    dice[j] = currentRoll;
                    // System.out.println(currentRoll + " @ " + "3");
                } else if (currentRoll == 4) {
                    dice[j] = 3;
                    // System.out.println(currentRoll + " @ " + "4");
                } else if (currentRoll == 5) {
                    dice[j] = 4;
                    // System.out.println(currentRoll + " @ " + "5");
                } else if (currentRoll == 6) {
                    dice[j] = 5;
                    // System.out.println(currentRoll + " @ " + "6");
                } else if (currentRoll == 7) {
                    dice[j] = 5;
                    // System.out.println(currentRoll + " @ " + "7");
                } else {
                    dice[j] = 5;
                    // System.out.println(currentRoll + " @ " + "8");
                }
            }
            ++probs[dice[0] + dice[1]];
        }

        double sum = 0;

        for (int i = 2; i < 11; ++i) {
            System.out.println(i + "\t" + (double)probs[i]/N);
            sum += (double)probs[i] / N;
        }
        System.out.println("Sum = " + sum);
    }


    public static void main(String args[]) {
        TwoDice(); // 0 and 1 should have no rolls
    }
}
