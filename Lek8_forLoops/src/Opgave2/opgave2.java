package Opgave2;

public class opgave2 {
    public static void main(String[] args) {
        System.out.println("Opgave a:");
        int s = 1;
        for (int n = 1; n<=5; n++) {
            s = s + n;
            System.out.println(s + " ");
        }
        System.out.println("Expected: 2, 4, 7, 11, 16");
        System.out.println();

        System.out.println("Opgave b:");
        int s1 = 1;
        for (int n = 1; s1<=10; System.out.println(s1 + " ")) {
            n = n + 2;

            s1 = s1 + n;
        }
        System.out.println("Expected: 4, 9, 16");
        System.out.println();

        System.out.println("Opgave c:");
        int s2 = 1;
        int n;
        for (n = 1; n<=5; n++) {
            s2=s2+n;
            n++;
        }
        System.out.println(s2 + " " + n);
        System.out.println("Expected: 10 7");
    }
}
