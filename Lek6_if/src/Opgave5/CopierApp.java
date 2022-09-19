package Opgave5;

public class CopierApp {
    public static void main(String[] args) {
        Copier kopi = new Copier(19);
        kopi.printPaper();
        System.out.println();

        //test af paperjam
        kopi.makePaperJam();
        kopi.makeCopy(6);
        kopi.printPaper();
        System.out.println();

        //test af indsæt papir + fejl ved overskridning
        kopi.insertPaper(47);
        kopi.printPaper();
        kopi.insertPaper(600);
        kopi.printPaper();
        System.out.println();

        //test af fixjam
        kopi.fixJam();
        kopi.makeCopy(10);
        kopi.printPaper();
        System.out.println();

        //test af for mange kopier
        kopi.makeCopy(100);
        kopi.printPaper();
    }
}
