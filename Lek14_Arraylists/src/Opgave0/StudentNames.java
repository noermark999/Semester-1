package Opgave0;

import java.util.*;

public class StudentNames {

    private final String[] mNames = {"Adam", "Amin", "Andreas", "Anton", "Christian Rosendal",
                       "Christian Skræddergaard", "Elias", "Jacob Gram",
                       "Jakob Noermark", "Jeppe", "John", "Kamilla", "Kasper",
                       "Lasse Calvillo", "Lasse Kirkegaard", "Louise","Lucas",
                       "Lucas", "Lucas Holm", "Mads Ilsø", "Mads Overgaard",
                       "Maksym", "Mathias", "Mikkel Hess", "Mikkel Lindhøj",
                       "Niclas", "Ol Ha", "Oliver Lochert", "Oliver Rosenquist",
                       "Peter", "Rasmus", "Silas", "Simon", "Tayylp", "Tobias"};
    private final ArrayList<String> mNames1 = new ArrayList<>(List.of(mNames));
    private final int numOfGroups;

    public StudentNames(int a){
        numOfGroups = a;
    }

    public ArrayList<String> getNames() { return mNames1; }

    public void randomize(){
        Collections.shuffle(mNames1);
    }

    public void createGroups(){
        randomize();
        int length = mNames1.size();
        int amountInGroups = length/numOfGroups;
        int numPutInGroups = amountInGroups*numOfGroups;
        for (int i = 0; i < numOfGroups; i++) {
            System.out.println("Gruppe nummer: " + (i + 1));
            for (int i1 = 0; i1 < amountInGroups;i1++){
                System.out.print(mNames1.get(i1+(i*amountInGroups)));
                if (i1+1<amountInGroups) {
                    System.out.print(", ");
                }
            }
            if (length%numOfGroups != 0 && numPutInGroups<(length)) {
                System.out.print(", ");
                System.out.print(mNames1.get(numPutInGroups));
                numPutInGroups++;
            }
            System.out.println();
            System.out.println();
        }
    }
}
