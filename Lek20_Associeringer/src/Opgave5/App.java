package Opgave5;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<String> cast = new ArrayList<>();
        cast.add("Monica");
        cast.add("Chandler");
        cast.add("Ross");
        cast.add("Rachel");
        cast.add("Phoebe");
        cast.add("Joey");

        Series series = new Series("Friends", cast);

        System.out.println(series.getCast());

        ArrayList<String> guestActorsEp1 = new ArrayList<>();
        guestActorsEp1.add("Emily");
        guestActorsEp1.add("Charles");

        series.createEpisode(1,guestActorsEp1,30);

        ArrayList<String> guestActorsEp2 = new ArrayList<>();
        guestActorsEp2.add("Peter");

        series.createEpisode(2,guestActorsEp2,35);

        ArrayList<String> guestActorsEp3 = new ArrayList<>();

        series.createEpisode(3,guestActorsEp3,32);

        System.out.println(series.totalLength());

        System.out.println(series.getGuestActors());


    }
}
