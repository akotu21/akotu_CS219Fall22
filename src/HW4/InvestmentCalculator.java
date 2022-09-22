package HW4;

import Utility.Investment;

import java.util.Scanner;

public class InvestmentCalculator {

    public static double getInitial(Scanner kbd) {
        boolean valid = false;
        double c = 0;

        while (!valid) {
            System.out.print("Enter an initial deposit as a decimal: ");

            if (kbd.hasNextDouble()) {
                c = kbd.nextDouble();
                if (c < 0) {
                    System.out.print("Initial deposit cannot be less than 0, you entered " + c);
                } else {
                    valid = true;
                }
            } else {
                String word = kbd.next();
                System.out.print("Decimal number expected, " + word +
                        " is not a number.");
            }
        }
        return c;
    }

    public static double getRate(Scanner kbd){
        boolean valid1 = false;
        double r = 0;

        while(!valid1){
            System.out.print("Enter an interest rate as a decimal: ");

            if (kbd.hasNextDouble()){
                r = kbd.nextDouble();

                if (r < 0) {
                    System.out.print("Interest rate cannot be less than 0, you entered " + r);
                }
                else{
                    valid1 = true;
                }
            }

            else {
                String word = kbd.next();
                System.out.print("Decimal number expected, " + word +
                        " is not a number.");
                    }
                }
        return r;
            }

    public static int getYears(Scanner kbd){
        boolean valid2 = false;
        int t = 0;

        while(!valid2){
            System.out.print("Enter a number of years:");

            if (kbd.hasNextInt()){
                t = kbd.nextInt();

                if (t < 0) {
                    System.out.print("Amount of years cannot be less than 0, you entered " + t);
                }
                else{
                    valid2 = true;
                }
            }

            else {
                String word = kbd.next();
                System.out.print("Integral number expected, " + word +
                        " is not a number.");
            }
        }
        return t;
    }

    public static int getCompounded(Scanner kbd) {
        boolean valid3 = false;
        int n = 0;

        while (!valid3) {

            System.out.print("Enter how many times compounded per year:");

            if (kbd.hasNextInt()) {
                n = kbd.nextInt();

                if (n < 0) {
                    System.out.print("Times compounded yearly cannot be less than 0, you entered " + n);
                } else {
                    valid3 = true;
                }
            } else {
                String word = kbd.next();
                System.out.print("decimal number expected, " + word +
                        " is not a number.");
            }
        }
        return n;
    }



    public static void main(String [] args){

        Scanner kbd = new Scanner(System.in);

        double c = getInitial(kbd);
        double r = getRate(kbd);
        int t = getYears(kbd);
        int n = getCompounded(kbd);

        System.out.printf("Your investment is worth %.2f", Investment.investment(c, r, t, n));

    }
}
