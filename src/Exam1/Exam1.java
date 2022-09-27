package Exam1;

import java.util.Scanner;

public class Exam1 {

    public static int twoSevenExclusive(int n){
        int count = 0;
        while(n > 0){
            if ((n % 10) > 2 && (n % 10) < 7) {
                count++;
            }
            n = n/10;
        }
        return count;
    }

    public static int getInt(Scanner kbd) {
        boolean valid = false;
        int n = 0;

        while (!valid) {
            System.out.print("Enter a positive integer: ");

            if (kbd.hasNextInt()) {
                n = kbd.nextInt();
                if (n < 0) {
                    System.out.print("You entered: " + n + ". ");
                } else {
                    valid = true;
                }
            } else {
                String word = kbd.next();
                System.out.print("You entered: " + word + ". ");
            }
        }
        return n;
    }

    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);

        int n = getInt(kbd);

        System.out.print(twoSevenExclusive(n));


    }
}
