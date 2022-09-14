package Opgave5;

public class CopierApp {
    public static void main(String[] args) {
        Copier kopi = new Copier(19);
        kopi.printPaper();
        kopi.makePaperJam();
        kopi.makeCopy(6);
        kopi.printPaper();
        kopi.insertPaper(47);
        kopi.printPaper();
        kopi.insertPaper(600);
        kopi.printPaper();
        kopi.fixJam();
        kopi.makeCopy(10);
        kopi.printPaper();
        kopi.makeCopy(100);
        kopi.printPaper();
    }
}
