package Application.Model;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Kamp implements Comparable<Kamp> {
    private String sted;
    private LocalDate dato;
    private LocalTime tid;
    private ArrayList<Deltagelse> deltagelser;

    public Kamp(String sted, LocalDate dato, LocalTime tid) {
        this.sted = sted;
        this.dato = dato;
        this.tid = tid;
        deltagelser = new ArrayList<>();
    }

    public String getSted() {
        return sted;
    }

    public LocalDate getDato() {
        return dato;
    }

    public LocalTime getTid() {
        return tid;
    }

    public ArrayList<Deltagelse> getDeltagelser() {
        return deltagelser;
    }

    public Deltagelse createDeltagelse(Spiller spiller) {
        Deltagelse deltagelse = new Deltagelse(spiller, this);
        deltagelser.add(deltagelse);
        return deltagelse;
    }

    public ArrayList<String> afbud() {
        ArrayList<String> res = new ArrayList<>();
        for (Deltagelse deltagelse : deltagelser) {
            if (deltagelse.isAfbud()) {
                res.add(deltagelse.getBegrundelse());
            }
        }
        return res;
    }

    public void spillerHonorar(String tekstFil) {
        try (PrintWriter printWriter = new PrintWriter("Semesteropgaver/Semesteropgave_Juni_2021/res/" + tekstFil)){
            for (Deltagelse deltagelse : deltagelser) {
                if (!deltagelse.isAfbud()) {
                    printWriter.println(deltagelse.getSpiller());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public int compareTo(Kamp o) {
        if (!this.dato.equals(o.getDato())) {
            return this.dato.compareTo(o.getDato());
        } else if (!this.tid.equals(o.getTid())) {
            return this.tid.compareTo(o.getTid());
        } else {
            return this.sted.compareTo(o.getSted());
        }
    }

    @Override
    public String toString() {
        return sted + ", " + dato.toString() + ", " + tid.toString();
    }
}
