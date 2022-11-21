package Controller;

public class SortingFunctions {
    /**
     Sorts an array, using selection sort.
     @param a the array to sort
     */
    private static void selectionSortIncreasing(int[] a)
    {
        for (int i = 0; i < a.length; i++)
        {
            int minPos = minimumPosition(a, i);
            ArrayUtil.swap(a, minPos, i);
        }
    }

    //Opgave 1
    private static void selectionSortDecreasing(int[] a)
    {
        for (int i = 0; i < a.length; i++)
        {
            int maxPos = maximumPosition(a, i);
            ArrayUtil.swap(a, maxPos, i);
        }
    }

    public static void selectionSort(int[] a, boolean sortIncreasing) {
        if (sortIncreasing) {
            selectionSortIncreasing(a);
        } else {
            selectionSortDecreasing(a);
        }
    }

    /**
     Finds the smallest element in a tail range of the array.
     @param a the array to sort
     @param from the first position in a to compare
     @return the position of the smallest element in the
     range a[from] . . . a[a.length - 1]
     */
    private static int minimumPosition(int[] a, int from)
    {
        int minPos = from;
        for (int i = from + 1; i < a.length; i++)
        {
            if (a[i] < a[minPos]) { minPos = i; }
        }
        return minPos;
    }

    private static int maximumPosition(int[] a, int from) {
        int maxPos = from;
        for (int i = from + 1; i < a.length; i++) {
            if (a[i] > a[maxPos]){
                maxPos = i;
            }
        }
        return maxPos;
    }

    public static void bubbleSort(int[] a){
        for (int k=0; k < a.length; k++)
        for (int i=0; i < a.length-1-k; i++)
            if (a[i] > a[i+1])
                ArrayUtil.swap(a,i, i+1);
    }
}
