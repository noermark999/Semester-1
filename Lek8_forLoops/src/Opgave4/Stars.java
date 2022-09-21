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

    public void starPictureA(int rows) {
        for (int row = 1; row <= rows; row++) {
            for (int star = rows; star >= row; star--) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void starPictureB(int rows) {
        for (int row = 1; row <= rows; row++) {
            for (int space = rows-1; space >= row; space--) {
                System.out.print(" ");
                }
            for (int star = 1; star <= row; star++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void starPictureC(int rows) {
        for (int row = 1; row <= rows; row++) {
            for (int star = 2; star <= row; star++) {
                System.out.print(" ");
            }
            for (int star = rows; star >= row; star--) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void starPictureD(int rows) {
        for (int row = 1; row <= rows; row++) {
            if (row<= Math.ceil((double)rows/2)) {
                for (int space = (int) (Math.ceil((double)rows/2)-1); space >= row; space--) {
                    System.out.print(" ");
                }
                for (int star = 1; star <= row; star++) {
                    System.out.print("*");
                }
                for (int star = 2; star <= row; star++) {
                    System.out.print("*");
                }
            } else {
                for (int space = (rows/2+2); space <= row; space++) {
                    System.out.print(" ");
                }
                for (int star = rows; star >= row; star--) {
                    System.out.print("*");
                }
                for (int star = rows-1; star >= row; star--) {
                    System.out.print("*");
                }
            }


            System.out.println();
        }
        System.out.println();
    }

}
