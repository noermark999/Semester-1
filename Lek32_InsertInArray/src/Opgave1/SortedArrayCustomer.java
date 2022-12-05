package Opgave1;

public class SortedArrayCustomer {
    public static void insertCustomer(Customer[] all, Customer c) {
        if (all[0] == null) {
            all[0] = c;
            return;
        }
        int idx = findIndex(all,c);
        for (int i = findSize(all); i >= idx; i--)
            all[i+1] = all[i];
        all[idx] = c;

    }
    private static int findIndex(Customer[] all, Customer c) {
        int res = 0;
        while (res < findSize(all) && all[res].compareTo(c)<0)
            res++;
        return res;
    }

    private static int findSize(Customer[] all) {
        int size = 0;
        for (Customer customer : all) {
            if (customer != null) {
                size++;
            }
        }
        return size;
    }
}
