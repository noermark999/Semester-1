package Controller;

import Opgave3.Application.Model.Customer;

import java.util.ArrayList;
import java.util.Random;

public class ArrayUtil
{
    private static final Random generator = new Random();

    /**
     Creates an array filled with random values.
     @param length the length of the array
     @param n the number of possible random values
     @return an array filled with length numbers between
     0 and n - 1
     */
    public static int[] randomIntArray(int length, int n)
    {
        int[] a = new int[length];
        for (int i = 0; i < a.length; i++)
        {
            a[i] = generator.nextInt(n);
        }

        return a;
    }

    /**
     Swaps two entries of an array.
     @param a the array
     @param i the first position to swap
     @param j the second position to swap
     */
    public static void swap(int[] a, int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void swapCustomer(ArrayList<Customer> a, int i, int j)
{
    Customer tempi = a.get(i);
    Customer tempj = a.get(j);
    a.remove(i);
    a.add(i,tempj);
    a.remove(j);
    a.add(j,tempi);
}
}
