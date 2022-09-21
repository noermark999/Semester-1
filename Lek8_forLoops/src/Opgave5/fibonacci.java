package Opgave5;

public class fibonacci {
    public void fibonacci(long n) {
        long i = -1;
        long fibo = 1;
        for (int tal = 0; tal<=n;tal++) {
            fibo = i + fibo;
            i = fibo - i;
            if (fibo!=0) {
                System.out.println(fibo);
            }
        }
    }
}
