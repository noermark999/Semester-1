package vejledning.sortedArrays;

import java.util.ArrayList;
import java.util.Arrays;

public class SortedArrayList {

    ArrayList<Integer> a;


    public SortedArrayList(){
        a = new ArrayList<>();
    }

    public void insert(int value){
        if (a.size() == 0)
        {
            a.add(value);
            return;
        }
        // size > 0
        int idx = findIndex(value);
        a.add(23);
        for (int i = a.size()-2; i >= idx; i--)
            a.set(i+1, a.get(i));
        a.set(idx, value);

    }

    private int findIndex(int value) {
        int res = 0;
        while (res < a.size() && a.get(res) <= value)
            res++;
        return res;
    }

   public String toString(){
        return a.toString();
    }
}
