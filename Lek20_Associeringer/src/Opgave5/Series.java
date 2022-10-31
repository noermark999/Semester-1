package Opgave5;

import java.util.ArrayList;

public class Series {
    private String title;
    private final ArrayList<String> cast;
    private final ArrayList<Episode> episodes = new ArrayList<>();

    public Series(String title, ArrayList<String> cast) {
        this.title = title;
        this.cast = cast;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<String> getCast() {
        return cast;
    }
    public Episode createEpisode(int number, ArrayList<String> guestActors, int lengthMinutes) {
        Episode episode = new Episode(number,guestActors,lengthMinutes);
        episodes.add(episode);
        return episode;
    }

    public ArrayList<Episode> getEpisodes() {
        return episodes;
    }

    public int totalLength() {
        int length = 0;
        for (var episodes : getEpisodes()) {
            length += episodes.getLengthMinutes();
        }
        return length;
    }

    public ArrayList<String> getGuestActors() {
        ArrayList<String> guestActors = new ArrayList<>();
        for (var episodes : getEpisodes()) {
            guestActors.add(episodes.getGuestActors().toString());
        }
        return guestActors;
    }
}
