package vejledning.sortedArrays;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        testSortedArrayList();
    }

    private static void testSortedArray() {
        SortedArray a = new SortedArray(10);

        for (var value: new int[] {3, 6, 1, 6, 4})
        {
            a.insert(value);
            System.out.println("Har indsat " + value);
            System.out.println(a);
        }


    }

    private static void testSortedArrayList() {
        SortedArrayList a = new SortedArrayList();

        for (var value: new int[] {3, 6, 1, 6, 4})
        {
            a.insert(value);
            System.out.println("Har indsat " + value);
            System.out.println(a);
        }


    }
}