package Opgave5.Model;

import java.util.ArrayList;

public class Series {
    private String title;
    private final ArrayList<String> cast;
    private final ArrayList<Episode> episodes = new ArrayList<>();
    private final ArrayList<Boolean> remove = new ArrayList<>();

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
        remove.add(false);
        return episode;
    }


    public ArrayList<Episode> getEpisodes() {
        return episodes;
    }

    public int totalLength() {
        int length = 0;
        for (Episode episode : episodes) {
            if (!remove.get(episode.getNumber()-1)) {
                length += episode.getLengthMinutes();
            }
        }
        return length;
    }

    public ArrayList<String> getGuestActors() {
        ArrayList<String> guestActors = new ArrayList<>();
        for (Episode episode : episodes) {
            for (int i = 0; i < episode.getGuestActors().size(); i++) {
                if (!guestActors.contains(episode.getGuestActors().get(i))){
                    if (!remove.get(episode.getNumber()-1)) {
                        guestActors.add(episode.getGuestActors().get(i));
                    }
                }
            }
        }
        return guestActors;
    }

    public void removeEpisode(int number) {
        if (number<remove.size()) {
            remove.set(number-1,true);
            System.out.println("Episode nr " + number + " er blevet fjernet");
        }
    }

    public void printEpisodes() {
        System.out.println("Episoder:");
        for (Episode episode : episodes) {
            if (!remove.get(episode.getNumber()-1)) {
                System.out.println("Episode nr: " + episode.getNumber());
            }
        }
    }
}
