package Opgave1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] l1 = {2, 4, 6, 8, 10, 12, 14};
        int[] l2 = {1, 2, 4, 5, 6, 9, 12, 17};
        System.out.println(Arrays.toString(intersection(l1, l2)));
        System.out.println(Arrays.toString(difference(l1,l2)));
    }

    /*  Returnerer et sorteret array der indeholder alle
    elementer l1 og l2 har til fælles
    Krav: l1 og l2 er sorterede, indeholder ikke dubletter
    og indeholder ikke tomme pladser */
    public static int[] intersection(int[] l1, int[] l2){
        int[] result = new int[l1.length + l2.length];
        int i1 = 0;
        int i2 = 0;
        int j = 0;

        while (i1 < l1.length && i2 < l2.length) {
            if (l1[i1] < l2[i2]) {
                i1++;
            } else if (l2[i2] < l1[i1]) {
                i2++;
            } else {
                result[j] = l1[i1];
                j++;
                i1++;
                i2++;
            }
        }
        int[] result1 = new int[j];
        System.arraycopy(result, 0, result1, 0, result1.length);
        return result1;
    }

    /*  Returnerer et sorteret array der indeholder alle
    elementer fra l1, som ikke findes i l2 */
    public static int[] difference(int[] l1, int[] l2){
        int[] result = new int[l1.length + l2.length];
        int i1 = 0;
        int i2 = 0;
        int j = 0;
        while (i1 < l1.length) {
            if (l1[i1] < l2[i2]) {
                result[j] = l1[i1];
                j++;
                i1++;
            } else if (l2[i2] < l1[i1]) {
                i2++;
            } else {
                i1++;
                i2++;
            }
        }
        int[] result1 = new int[j];
        System.arraycopy(result, 0, result1, 0, result1.length);
        return result1;
    }
}


