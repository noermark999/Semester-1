package Opgave4;

public class Stars {
    final int MAX_ROWS = 10;

    public void starPicture() {
        for (int row = 1; row <= MAX_ROWS; row++) {
            for (int star = 1; star <= row; star++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void starPictureA() {
        for (int row = 1; row <= MAX_ROWS; row++) {
            for (int star = 10; star >= row; star--) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void starPictureB() {
        for (int row = 1; row <= MAX_ROWS; row++) {
            for (int space = 9; space >= row; space--) {
                System.out.print(" ");
                }
            for (int star = 1; star <= row; star++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void starPictureC() {
        for (int row = 1; row <= MAX_ROWS; row++) {
            for (int star = 2; star <= row; star++) {
                System.out.print(" ");
            }
            for (int star = 10; star >= row; star--) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void starPictureD() {
        for (int row = 1; row <= MAX_ROWS; row++) {
            if (row<=5) {
                for (int space = 4; space >= row; space--) {
                    System.out.print(" ");
                }
                for (int star = 1; star <= row; star++) {
                    System.out.print("*");
                }
                for (int star = 2; star <= row; star++) {
                    System.out.print("*");
                }
            } else {
                for (int space = 7; space <= row; space++) {
                    System.out.print(" ");
                }
                for (int star = 10; star >= row; star--) {
                    System.out.print("*");
                }
                for (int star = 9; star >= row; star--) {
                    System.out.print("*");
                }
            }


            System.out.println();
        }
        System.out.println();
    }

}
