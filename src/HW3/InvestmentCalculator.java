package HW3;

import Utility.Investment;

import java.util.Scanner;

public class InvestmentCalculator {

    public static void main(String [] args){

        Scanner kbd = new Scanner(System.in);

        System.out.print("Enter an initial deposit as a decimal: ");
        double c;

        if (kbd.hasNextDouble()){
            c = kbd.nextDouble();

            if (c < 0){
                System.out.print("Initial deposit cannot be less than 0, you entered " + c);
            return;

            }
        }

        else {
            String word = kbd.next();
            System.out.print("Decimal number expected, " + word +
                    " is not a number.");
        return;
        }


        System.out.print("Enter an interest rate as a decimal: ");
        double r;

        if (kbd.hasNextDouble()){
            r = kbd.nextDouble();

            if (r < 0) {
                System.out.print("Interest rate cannot be less than 0, you entered " + r);
                return;
            }
        }

        else {
            String word = kbd.next();
            System.out.print("Decimal number expected, " + word +
                    " is not a number.");
        return;
        }


        System.out.print("Enter a number of years:");
        int t;

        if (kbd.hasNextInt()){
            t = kbd.nextInt();

            if (t < 0) {
                System.out.print("Amount of years cannot be less than 0, you entered " + t);
                return;
            }
        }

        else {
            String word = kbd.next();
            System.out.print("Integral number expected, " + word +
                    " is not a number.");
            return;
        }

        System.out.println("Enter how many times compounded per year :");
        int n;

        if (kbd.hasNextInt()){
            n = kbd.nextInt();

            if (n < 0) {
                System.out.print("Times compounded yearly cannot be less than 0, you entered " + n);
                return;
            }
        }

        else {
            String word = kbd.next();
            System.out.print("decimal number expected, " + word +
                    " is not a number.");
            return;
        }


        System.out.printf("Your investment is worth %.2f", Investment.investment(c, r, t, n));

    }
}
