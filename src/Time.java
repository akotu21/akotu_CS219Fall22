public class Time {
    public static int Time(int h, int m, int s) {
        return h*3600 + m*60 + s;
    }
    public static void main (String [] args) {

        System.out.println(Time(14, 49, 30) + " seconds since midnight");
    }
}
