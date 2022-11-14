package Opgave1;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        ArrayList<Mekaniker> mekanikere = new ArrayList<>();

        Mekaniker m1 = new Mekaniker("Peter", "Langvej 1",2001,158);
        mekanikere.add(m1);
        Værkfører v1 = new Værkfører("Søren", "Langehusevej 12",2009,190,2018,5000);
        mekanikere.add(v1);
        Mekaniker m2 = new Mekaniker("Herman", "Rolighedsvej 35",2016,180);
        mekanikere.add(m2);
        Synsmand s1 = new Synsmand("Signe", "Petersgade 21", 2019,160,25);
        mekanikere.add(s1);

        System.out.println(samletLoen(mekanikere));
        System.out.println("Expected: 31181");

    }
        /**
         * Beregner summen af ugelønnen for alle i listen
         **/
        public static double samletLoen(ArrayList<Mekaniker> list){
            double sum = 0;
            for (Mekaniker mekaniker : list) {
                sum += mekaniker.beregnLoen();
            }
            return sum;
        }

}
