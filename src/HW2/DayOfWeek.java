/*
August Kotula
9/6/2022
HW2
 */


package HW2;

import java.util.Scanner;

public class DayOfWeek {

    public static int dayofweek(int m, int d, int y){
        int y1 = y - (14 - m)/12;

        int x = y1 + y1/4 - y1/100 +y1/400;

        int m1 = m + 12 * ((14 - m)/12) - 2;

        return (d + x + 31 * m1 / 12)%7;
    }
    public static void main(String [] args){

        Scanner kbd = new Scanner(System.in);

        System.out.print("Enter a month (1-12): ");
        int m = kbd.nextInt();

        System.out.print("Enter a day (1-31): ");
        int d = kbd.nextInt();

        System.out.print("Enter a year (4 digits): ");
        int y = kbd.nextInt();

        System.out.print(dayofweek(m, d, y));

    }
}
