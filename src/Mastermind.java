import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

// Author: Maciej Lewandowski
//        The player has 10 chances to guess the code.
//        After each attempt to guess the code, the computer evaluates it.
//        - how many digits in the code are in place: score 1
//        if the given digit is not present in the code you get no point
//        the score is given so as not to reveal which places in the code it refers to
//        full points are given first, then zeros

// todo: InputMismatchException
public class Mastermind {

    public static void main(String[] args) {

        Random r = new Random();

        Scanner sc = new Scanner(System.in);

        int[] thread = new int[4];

        for (int i = 0; i < 4; i++) {
            thread[i] = r.nextInt(6) + 1;
        }
        int counter = 0;

        int[] guess = new int[4];

        ArrayList<String> result = new ArrayList<>();
        boolean winner = false;
        
        System.out.println("Welcome to Mastermind!");

        while (counter < 10) {
            counter++;
            int position = 1;


            System.out.println(" Attempt number " + counter);

            for (int i = 0; i < 4; i++) {
                System.out.println("Position " + position++ + "");
                guess[i] = sc.nextInt();

                try {
                    if (guess[i] > 6 || guess[i] < 1) {
                        throw new IllegalArgumentException("Choose between 1 and 6!");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Choose between 1 a 6!");
                }
            }
            for (int i = 0; i < 4; i++) {
                if (guess[i] == thread[i]) {
                    result.add(String.valueOf('1'));
                }

            }
            if (guess[0] == thread[1] || guess[0] == thread[2] || guess[0] == thread[3]) {
                result.add(String.valueOf('0'));
            }

            if (guess[1] == thread[2] || guess[1] == thread[3] || guess[1] == thread[0]) {
                result.add(String.valueOf(('0')));
            }

            if (guess[2] == thread[0] || guess[2] == thread[1] || guess[2] == thread[3]) {
                result.add(String.valueOf('0'));
            }

            if (guess[3] == thread[0] || guess[3] == thread[1] || guess[3] == thread[2]) {
                result.add(String.valueOf('0'));
            }

            if (guess[0] == thread[0] && guess[1] == thread[1] && guess[2] == thread[2] && guess[3] == thread[3]) {
                winner = true;
                break;
            }

            System.out.print(" Your score is as follows:   " + result);

            result.clear();

            if (counter == 10) {
                System.out.println(" Unfortunately you didn't guess my code. ");
                System.out.println(" Code: ");
                break;
            }

        }

        if (winner) {
            System.out.println("Congrats, you won!");
        }
        for (int i = 0; i < 4; i++) {
            System.out.print(thread[i] + " ");
        }


    }
}