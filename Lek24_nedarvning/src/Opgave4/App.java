package Opgave4;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        ArrayList<Ansat> ansatte = new ArrayList<>();

        Mekaniker m1 = new Mekaniker("Peter", "Langvej 1",2001,158);
        ansatte.add(m1);
        Værkfører v1 = new Værkfører("Søren", "Langehusevej 12",2009,190,2018,5000);
        ansatte.add(v1);
        Mekaniker m2 = new Mekaniker("Herman", "Rolighedsvej 35",2016,180);
        ansatte.add(m2);
        Synsmand s1 = new Synsmand("Signe", "Petersgade 21", 2019,160,25);
        ansatte.add(s1);
        Arbejdsdreng a1 = new Arbejdsdreng("Søren","Thorsgade 5",125);
        ansatte.add(a1);


        System.out.println(samletUgeLoen(ansatte));
        System.out.println("Expected: 34306");

    }
        /**
         * Beregner summen af ugelønnen for alle i listen
         **/
        public static double samletUgeLoen(ArrayList<Ansat> list){
            double sum = 0;
            for (Ansat ansat : list) {
                sum += ansat.beregnLoen();
            }
            return sum;
        }

}
