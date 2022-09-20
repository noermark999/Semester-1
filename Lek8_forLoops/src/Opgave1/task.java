package Opgave1;

public class task {

    public void opgave1(int x) {
        for (int i = 1; i <= x; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }
    }

    public void opgave2(int x) {
        for (int tre = x; tre >= 3; tre--) {
            if (tre % 3 == 0) {
                System.out.println(tre);
            }
        }
    }
}
