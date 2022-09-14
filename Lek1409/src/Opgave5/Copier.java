package Opgave5;

public class Copier {
    private int paper;
    private boolean paperStuck;

    public Copier(int paper) {
        this.paper = paper;
        paperStuck = false;
    }
    public void insertPaper(int paper) {
        if (this.paper + paper <=500) {
            this.paper = this.paper + paper;
            System.out.println("You have inserted " + paper + " pieces of paper");
        } else if (this.paper + paper>500) {
            System.out.println("Error you tried inserting " + paper + " pieces of paper, but copier can only hold 500");
        }
    }
    public int getPaper() {
        return paper;
    }

    public void makeCopy(int paper) {
        if (!paperStuck) {
            if (this.paper-paper>=0) {
                this.paper = this.paper - paper;
                System.out.println("You have copied " + paper + " pieces of paper");
            } else {
                System.out.println("You tried coping " + paper + " pieces of paper, but theres only " + this.paper + " pieces in the tray");
            }
        } else {
            System.out.println("Error: You tried copying " + paper + " pieces of paper but there's a paperjam!");
        }
    }

    public void makePaperJam() {
        paperStuck = true;
        System.out.println("Paper has jammed!");
    }

    public void fixJam() {
        paperStuck = false;
        System.out.println("The paperjam has been resolved");
    }

    public void printPaper() {
        System.out.println("Pieces of paper in the tray: " + paper);
    }

}
