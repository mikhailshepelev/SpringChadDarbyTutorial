package mainApps;

import classes.Coach;
import classes.TrackCoach;

public class MyApp {

    public static void main(String[] args) {

        //this is still hardcoded, because we should change source code
        Coach theCoach = new TrackCoach();

        System.out.println(theCoach.getDailyWorkout());
    }
}
