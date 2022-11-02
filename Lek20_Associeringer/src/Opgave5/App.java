package Opgave5;

import Opgave5.Model.Episode;
import Opgave5.Model.Series;

import java.io.FileReader;
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
        guestActorsEp2.add("Emily");

        series.createEpisode(2,guestActorsEp2,35);

        ArrayList<String> guestActorsEp3 = new ArrayList<>();

        series.createEpisode(3,guestActorsEp3,32);

        System.out.println("total længde på episoderne: " + series.totalLength());

        System.out.println(series.getGuestActors());

        System.out.println("Titlen på episode 1: " + series.getEpisodes().get(0).getSeries().getTitle());

        series.printEpisodes();
        System.out.println();

        series.removeEpisode(1);
        System.out.println();

        series.printEpisodes();
        System.out.println();

        System.out.println("total længde på episoderne: " + series.totalLength());
        System.out.println();

        System.out.println(series.getGuestActors());
        System.out.println();

        series.removeEpisode(2);
        System.out.println();

        series.printEpisodes();
        System.out.println();

        System.out.println(series.getGuestActors());
        System.out.println();
    }
}
