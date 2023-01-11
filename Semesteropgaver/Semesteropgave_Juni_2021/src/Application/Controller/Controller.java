package Application.Controller;

import Application.Model.Kamp;
import Application.Model.Professionel;
import Application.Model.Spiller;
import Storage.Storage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Controller {
    public static Spiller createSpiller(String navn, int årgang) {
        Spiller spiller = new Spiller(navn, årgang);
        Storage.addSpiller(spiller);
        return spiller;
    }

    public static Kamp createKamp(String sted, LocalDate dato, LocalTime tid) {
        Kamp kamp = new Kamp(sted, dato, tid);
        Storage.addKamp(kamp);
        return kamp;
    }

    public static Professionel createProfessionel(String navn, int årgang, double kampHonorar) {
        Professionel professionel = new Professionel(navn, årgang, kampHonorar);
        Storage.addSpiller(professionel);
        return professionel;
    }

    public static String findKampSted(LocalDate dato, LocalTime tid) {
        String res = null;
        for (Kamp kamp : Storage.getKampe()) {
            if (kamp.getDato().equals(dato) && kamp.getTid().equals(tid)) {
                res = kamp.getSted();
            }
        }
        return res;
    }

    public static ArrayList<Kamp> alleKampe(ArrayList<Kamp> list1, ArrayList<Kamp> list2) {
        ArrayList<Kamp> result = new ArrayList<Kamp>();
        int i1 = 0;
        int i2 = 0;

        while (i1 < list1.size() && i2 < list2.size()) {
            if (list1.get(i1).compareTo((list2.get(i2))) < 0) {

                result.add(list1.get(i1));
                i1++;
            }
            else if (list1.get(i1).compareTo((list2.get(i2))) > 0){
                result.add(list2.get(i2));
                i2++;
            } else {
                result.add(list1.get(i1));
                i1++;
                i2++;
            }
        }

        while (i1 < list1.size()) {
            result.add(list1.get(i1));
            i1++;
        }

        while (i2 < list2.size()) {
            result.add(list2.get(i2));
            i2++;
        }

        return result;
}

    public static void createSomeObjects() {
        Spiller spiller1 = createSpiller("Peter Jensen", 1999);
        Spiller spiller2 = createSpiller("Lars Hansen", 2000);
        Spiller spiller3 = createSpiller("Morten Petersen", 1999);

        Professionel professionel1 = createProfessionel("Sofus Kjeldsen", 1999, 100);
        Professionel professionel2 = createProfessionel("Janus Nielsen", 2000, 120);

        Kamp kamp1 = createKamp("Herning", LocalDate.of(2021,6,22), LocalTime.of(10,30));
        Kamp kamp2 = createKamp("Viborg", LocalDate.of(2021,6,29), LocalTime.of(13,30));

        for (Spiller spiller : Storage.getSpillere()) {
            kamp1.createDeltagelse(spiller);
            kamp2.createDeltagelse(spiller);
        }
        kamp1.getDeltagelser().get(0).setAfbud(true);
        kamp1.getDeltagelser().get(0).setBegrundelse("han skal læse til eksamen");

        kamp2.getDeltagelser().get(3).setAfbud(true);
        kamp2.getDeltagelser().get(3).setBegrundelse("Han er syg");
    }
}
