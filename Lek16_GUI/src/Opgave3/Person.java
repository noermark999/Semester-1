package Opgave3;

public class Person {

    private final String name;
    private final String title;
    private final boolean senior;

    public Person(String name, String titel, boolean senior) {
        this.name = name;
        this.title = titel;
        this.senior = senior;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String toString() {
        String s = title + " " + name;
        if (senior) s = s + " (senior)";
        return s;
    }
}
