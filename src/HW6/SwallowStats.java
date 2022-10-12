package HW6;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class SwallowStats {
    public static void SwallowStats() {

        // connect to the webpage of speeds
        URL url = null;                      // null is the nothing value
        Scanner s = null;
        String path = "http://10.60.15.25/~ehar/cs219/swallow-speeds.txt";


        try {
            url = new URL(path);
            s = new Scanner(url.openConnection().getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        double sum = 0.0;
        int count = 0;
        double maximum = Double.NEGATIVE_INFINITY;
        double minimum = Double.POSITIVE_INFINITY;

        while (true) {

            if (!s.hasNextLine()){
                break;
            }
            String line = s.nextLine(); //read a line of the website
            if (!line.contains("#") && !line.equals("")){ //modify condition for line.length = 0
                sum = sum + Double.parseDouble(line);


                if(Double.parseDouble(line) > maximum) {
                    maximum = Double.parseDouble(line);
                }

                if(Double.parseDouble(line) < minimum) {
                    minimum = Double.parseDouble(line);
                }
                count++;

                }

            }

        System.out.printf("The average swallow speed is %.2f m/s, the minimum speed \nis %.1f m/s, and the " +
                "maximum speed is %1.1f m/s.", (sum/count), minimum, maximum);
        }



    public static void main(String [] args) {
        SwallowStats();
    }
}
