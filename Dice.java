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

    public static int cDiceRoll(int[] cDie) {
        int[] currDie = cDie;
        int sides = 6;
        return currDie[rn.nextInt(sides)];
    }

    public static void diceCheck(int[] arr1, int[] arr2) {
        int[] dieA = arr1;
        int[] dieB = arr2;
        int N = 1000000;
        int winsDieA = 0;
        for (int i = 0; i < N; i++) {
            if (cDiceRoll(dieA) > cDiceRoll(dieB)) {
                winsDieA++;
            }
        }
        System.out.println("The first die won " + winsDieA + "/" + N + " times! The percentage is " + (double)winsDieA/(double)N);
    }

    public static void main(String args[]) {
        int[] die1 = {1,2,3,9,10,11};
        int[] die2 = {0,1,7,8,8,9};
        int[] die3 = {5,5,6,6,7,7};
        int[] die4 = {3,4,4,5,11,12};
        System.out.println("Die 1 vs Die 2");
        diceCheck(die1, die2);
        System.out.println("Die 1 vs Die 3");
        diceCheck(die1, die3);
        System.out.println("Die 1 vs Die 4");
        diceCheck(die1, die4);
        System.out.println("Die 2 vs Die 1");
        diceCheck(die2, die1);
        System.out.println("Die 2 vs Die 3");
        diceCheck(die2, die3);
        System.out.println("Die 2 vs Die 4");
        diceCheck(die2, die4);
        System.out.println("Die 3 vs Die 1");
        diceCheck(die3, die1);
        System.out.println("Die 3 vs Die 2");
        diceCheck(die3, die2);
        System.out.println("Die 3 vs Die 4");
        diceCheck(die3, die4);
        System.out.println("Die 4 vs Die 1");
        diceCheck(die4, die1);
        System.out.println("Die 4 vs Die 2");
        diceCheck(die4, die2);
        System.out.println("Die 4 vs Die 3");
        diceCheck(die4, die3);
    }
}
