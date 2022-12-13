package ZipCodeDB;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/*
 *Hold data about one zipcode
 */
public class Zipcode implements Comparable<Zipcode>, Distance, WeatherInfo, LatLngInterface {

    private String code;
    private String state; //two-character abbreviation
    private String city;
    private double lng; //longitude
    private double lat; //latitude
    private int pop;

    public Zipcode(String code, String state, String city, double lng, double lat, int pop) {
        this.code = code;
        this.state = state;
        this.city = city;
        this.lng = lng;
        this.lat = lat;
        this.pop = pop;
    }


    public String toString() {
        return "Zipcode{" +
                "code='" + code + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", lng=" + lng +
                ", lat=" + lat +
                ", pop=" + pop +
                '}';
    }

    public String getCode() {
        return code;
    }

    // the natural ordering for zipcode
    @Override
    public int compareTo(Zipcode zc) {
        return this.code.compareTo(zc.code);
    }

    @Override
    public double distance(Zipcode zip) {
        return 0; // fancy great circle distance
    }

    public WeatherObservation getWeatherData() {
        URL url = null;
        Scanner s = null;

        String path = "http://api.geonames.org/findNearByWeatherJSON?formatted=true&lat=" +
                this.lat + "&lng=-" + this.lng + "&username=edharcourt\n";
        try {
            url = new URL(path);
            s = new Scanner(url.openConnection().getInputStream());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        double humidity = 0, temp = 0, speed = 0;
        String clouds = "";

        while (s.hasNextLine()) {
            String line = s.nextLine();

            //check for humidity
            if (line.indexOf("humidity")>0) {
                humidity = Double.parseDouble(
                        line.substring(line.indexOf(':') + 1,
                                       line.indexOf(',')));
            }

            if (line.indexOf("temperature")>0) {
                temp = Double.parseDouble(
                        line.substring(line.indexOf(':') + 3,
                                line.indexOf(',')-1));
            }

            if (line.indexOf("windSpeed")>0) {
                speed = Double.parseDouble(
                        line.substring(line.indexOf(':') + 3,
                                line.indexOf(',')-1));
            }

            if (line.indexOf("clouds")>0) {
                clouds = line.substring(line.indexOf(':') + 1,
                                line.indexOf(','));
            }

    }
        WeatherObservation ob = new WeatherObservation(humidity, speed, temp, clouds);
        return ob;
}}
//http://api.geonames.org/findNearByWeatherJSON?formatted=true&lat=44&lng=-74&username=edharcourt



