package vejledning.sortedArrays;

import java.util.Arrays;

public class SortedArray {

    int[] a;
    int size;

    public SortedArray(int initialKapacitet){
        a = new int[initialKapacitet];
        size = 0;
    }

    public void insert(int value){
        if (size == 0)
        {
            a[0] = value;
            size = 1;
            return;
        }
        // size > 0
        int idx = findIndex(value);
        for (int i = size-1; i >= idx; i--)
            a[i+1] = a[i];
        a[idx] = value;
        size++;

    }

    private int findIndex(int value) {
        int res = 0;
        while (res < size && a[res] <= value)
            res++;
        return res;
    }

    public String toString(){
        return Arrays.toString(Arrays.copyOf(a, size));
    }

}
