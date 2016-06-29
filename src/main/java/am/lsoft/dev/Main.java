package am.lsoft.dev;

import java.util.ArrayList;

import static java.lang.Math.abs;

public class Main {

    public static double[] fareEstimator(int ride_time, int ride_distance, double[] cost_per_minute, double[] cost_per_mile) {
        double[] res = new double[cost_per_minute.length];
        for (int i = 0; i < cost_per_minute.length; i++) {
            res[i] = ride_time * cost_per_minute[i] + ride_distance * cost_per_mile[i];
        }
        return res;
    }

    public static double perfectCity(double[] departure, double[] destination) {
        double boundUPX;
        double boundUPY;
        if (departure[0] == (int) (departure[0])) {
            boundUPX = (int) departure[0];
        } else {
            boundUPX = (int) (departure[0] + 1);
        }
        if (destination[0] == (int) (destination[0])) {
            boundUPY = (int) destination[0];
        } else {
            boundUPY = (int) (destination[0] + 1);
        }
        System.out.println("boundUPX = " + boundUPX);
        System.out.println("boundUPY = " + boundUPY);

        System.out.println("departure[0] = " + departure[0]);
        System.out.println("destination[0] = " + destination[0]);

        System.out.println("boundUPX - departure[0] = " + (boundUPX - departure[0]));
        System.out.println("boundUPY - destination[0] = " + (boundUPY - destination[0]));

        return boundUPX - departure[0] + boundUPY - destination[0] + abs(boundUPX - boundUPY) +
                abs(departure[1] - destination[1]);
    }


    public static void main(String[] args) {
        // write your code here
        /*double[] dep = new double[2];
        dep[0] = 0.4;
        dep[1] = 1;
        double[] dest = new double[2];
        dest[0] = 0.9;
        dest[1] = 3;*/
        double[] dep = new double[2];
        dep[0] = 2.4;
        dep[1] = 1.0;
        double[] dest = new double[2];
        dest[0] = 5.0;
        dest[1] = 7.3;

        System.out.println(perfectCity(dep, dest));
    }
}
