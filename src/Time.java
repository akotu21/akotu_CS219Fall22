public class Time {
    public static void main (String [] args) {
        int hour = 10;
        int minute = 14;
        int second = 30;

        double SinceMidnight = hour * 3600 + minute * 60 + second;

        System.out.println(SinceMidnight + " seconds since midnight");

        double SecondsLeft = 86400 - SinceMidnight;

        System.out.println(SecondsLeft + " seconds left in the day");

        double PercentPassed = (SinceMidnight / 86400) * 100;

        System.out.println(PercentPassed + "% of the day has passed");


    }
}
