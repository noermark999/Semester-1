package Opgave1;

public class app {
    public static void main(String[] args) {
        System.out.println("Opgave 1.1");
        for (int i = 1; i<=99; i++) {
            if (i%2!=0) {
                System.out.println(i);
            }
        }
        System.out.println("Opgave 1.2");
        for (int tre = 300;tre>=3;tre = tre-3) {
           System.out.println(tre);
        }
    }
}
