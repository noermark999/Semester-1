package Opgave5.Model;

import java.util.ArrayList;
import java.util.Iterator;

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
        Episode episode = new Episode(number,guestActors,lengthMinutes, this);
        episodes.add(episode);
        return episode;
    }


    public ArrayList<Episode> getEpisodes() {
        return episodes;
    }

    public int totalLength() {
        int length = 0;
        for (Episode episode : episodes) {
                length += episode.getLengthMinutes();
        }
        return length;
    }

    public ArrayList<String> getGuestActors() {
        ArrayList<String> guestActors = new ArrayList<>();
        for (Episode episode : episodes) {
            for (int i = 0; i < episode.getGuestActors().size(); i++) {
                if (!guestActors.contains(episode.getGuestActors().get(i))){
                        guestActors.add(episode.getGuestActors().get(i));
                }
            }
        }
        return guestActors;
    }

    public void printEpisodes() {
        System.out.println("Episoder:");
        for (Episode episode : episodes) {
            System.out.println("Episode nr: " + episode.getNumber());
        }
    }

    public void removeEpisode(int number) {
        episodes.removeIf(episode -> episode.getNumber() == number);
    }
}
