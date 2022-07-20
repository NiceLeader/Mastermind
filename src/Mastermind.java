import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

// Autor: Maciej Lewandowski
//        Gracz ma 10 szans na odgadni�cie kodu.
//        Po ka�dej pr�bie odgadni�cia kodu  komputer ocenia
//        � ile cyfr w kodzie jest na swoim miejscu: punktacja 1
//        -  ile cyfr jest w kodzie ale nie na swoim miejscu: punktacja 0
//        je�eli podana cyfra nie wyst�puje w kodzie nie dostaje �adnego punktu
//        punktacja jest podawana tak, �eby nie zdradzi� do kt�rych miejsc w kodzie si� odnosi
//        najpierw podawane s� pe�ne punkty a potem zera

// todo: �apanie b��du InputMismatchException
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
        
        System.out.println("Witaj w Mastermind!");

        while (counter < 10) {
            counter++;
            int position = 1;


            System.out.println(" Pr�ba nr " + counter);

            for (int i = 0; i < 4; i++) {
                System.out.println("Miejsce " + position++ + "");
                guess[i] = sc.nextInt();

                try {
                    if (guess[i] > 6 || guess[i] < 1) {
                        throw new IllegalArgumentException("Strzelaj pomi�dzy 1 a 6!");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Strzelaj pomi�dzy 1 a 6!");
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

            System.out.print(" Twoja punktacja wygl�da nast�puj�co: " + result);

            result.clear();

            if (counter == 10) {
                System.out.println(" Niestety nie uda�o Ci si� odgadn�� mojego kodu. ");
                System.out.println(" M�j kod to: ");
                break;
            }

        }

        if (winner) {
            System.out.println("Brawo, wygra�e�!");
        }
        for (int i = 0; i < 4; i++) {
            System.out.print(thread[i] + " ");
        }


    }
}