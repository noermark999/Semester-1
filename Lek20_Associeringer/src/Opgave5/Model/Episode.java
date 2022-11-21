package Opgave5.Model;

import java.util.ArrayList;

public class Episode {
    private final int number;
    private final ArrayList<String> guestActors;
    private final int lengthMinutes;
    private final Series series;

    public Episode(int number, ArrayList<String> guestActors, int lengthMinutes, Series series) {
        this.number = number;
        this.guestActors = guestActors;
        this.lengthMinutes = lengthMinutes;
        this.series = series;
    }
    public int getNumber() {
        return number;
    }

    public int getLengthMinutes() {
        return lengthMinutes;
    }

    public ArrayList<String> getGuestActors() {
        return guestActors;
    }

    public Series getSeries() {
        return series;
    }

}
