import Controller.ArrayUtil;
import Controller.SortingFunctions;

import java.util.Arrays;

public class Main {

    public static void main(String[] args)
    {
        int[] a = ArrayUtil.randomIntArray(20, 100);
        System.out.println(Arrays.toString(a));

        SortingFunctions.selectionSort(a, true);
        System.out.println(Arrays.toString(a));

        SortingFunctions.selectionSort(a, false);
        System.out.println(Arrays.toString(a));
    }
}
