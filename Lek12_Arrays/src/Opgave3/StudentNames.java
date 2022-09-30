package Opgave3;

import java.util.Arrays;
import java.util.Random;

public class StudentNames {

    private static final String[] mNames = {"Adam", "Amin", "Andreas", "Anton", "Christian Rosendal",
                       "Christian Skræddergaard", "Elias", "Jacob Gram",
                       "Jakob Noermark", "Jeppe", "John", "Kamilla", "Kasper",
                       "Lasse Calvillo", "Lasse Kirkegaard", "Louise","Lucas",
                       "Lucas", "Lucas Holm", "Mads Ilsø", "Mads Overgaard",
                       "Maksym", "Mathias", "Mikkel Hess", "Mikkel Lindhøj",
                       "Niclas", "Ol Ha", "Oliver Lochert", "Oliver Rosenquist",
                       "Peter", "Rasmus", "Silas", "Simon", "Tayylp", "Tobias"};
    private final Random random = new Random();
    private final int numOfGroups;

    public StudentNames(int a){
        numOfGroups = a;
    }

    public String[] getNames() { return mNames; }

    public void randomize(){
        int length = (mNames.length)-1;
        for (int i = mNames.length-1; i>0;i--) {
            int rand = random.nextInt(length);
            String x = mNames[rand];
            mNames[rand] = mNames[i];
            mNames[i] = x;
            length--;
        }
    }

    public void createGroups(){
        randomize();
        int length = mNames.length;
        int amountInGroups = length/numOfGroups;
        for (int i = 0; i < numOfGroups; i++) {
            System.out.println("Gruppe nummer: " + (i + 1));
            for (int i1 = 0; i1 < amountInGroups;i1++){
                System.out.print(mNames[i1+(i*amountInGroups)] + ", ");
            }
            System.out.println();
            System.out.println();
        }
        int x = length-1;
        if (length%numOfGroups != 0) {
            System.out.println("Personer til overs: ");
            for (int i = 0; i < length%numOfGroups; i++) {
                System.out.print(mNames[x] + ", ");
                x--;
            }
        }
    }
}
