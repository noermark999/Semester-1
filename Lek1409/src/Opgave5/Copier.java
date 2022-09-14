package Opgave5;

import java.awt.print.Paper;
import java.lang.management.ThreadInfo;

public class Copier {
    private int paper;
    private boolean paperStuck;

    public Copier(int paper) {
        this.paper = paper;
    }
    public void insertPaper(int paper) {
        if (this.paper + paper <=500) {
            this.paper = this.paper + paper;
        } else if (this.paper + paper>500) {
            System.out.println("Error cant insert more than 500");
        }
    }
    public int getPaper() {
        return paper;
    }

    public void makeCopy(int paper) {
        if (!paperStuck) {
            if (this.paper-paper>=0) {
                this.paper = this.paper - paper;
            } else {
                System.out.println("Not enough paper");
            }
        } else {
            System.out.println("Error: Paper stuck");
        }
    }

    public void makePaperJam() {
        paperStuck = true;
    }

    public void fixJam() {
        paperStuck = false;
    }

}
