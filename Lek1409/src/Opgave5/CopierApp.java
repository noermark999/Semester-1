package Opgave5;

public class CopierApp {
    public static void main(String[] args) {
        Copier kopi = new Copier(19);
        kopi.makePaperJam();                   //paper stuck
        kopi.makeCopy(6);                //prøver at lave kopier, men der kommer error
        System.out.println("Antal stk. papir i printer " + kopi.getPaper());
        kopi.insertPaper(47);                   //indsætter 47 stk. papir uden problemer
        System.out.println("Antal stk. papir i printer " + kopi.getPaper());
        kopi.insertPaper(600);                  //prøver at indsætte mere end 500, error
        System.out.println("Antal stk. papir i printer " + kopi.getPaper());
        kopi.fixJam();                          //fixer papirstop
        kopi.makeCopy(10);                //prøver at lave 10 kopier og virker
        System.out.println("Antal stk. papir i printer " + kopi.getPaper());
        kopi.makeCopy(100);               //prøver at lave flere kopier end der er papir, error
        System.out.println("Antal stk. papir i printer " + kopi.getPaper());
    }
}
