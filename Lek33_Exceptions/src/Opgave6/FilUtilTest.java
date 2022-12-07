package Opgave6;

public class FilUtilTest {
    public static void main(String[] args) {
        System.out.println("Største tal fil 1: " + FilUtil.max("Opgave6_RandomTal.txt"));
        System.out.println("Største tal fil 2: " + FilUtil.max("Opgave6_RandomTal2.txt"));

        System.out.println("Mindste tal fil 1: " + FilUtil.min("Opgave6_RandomTal.txt"));
        System.out.println("Mindste tal fil 2: " + FilUtil.min("Opgave6_RandomTal2.txt"));

        System.out.println("Gennemsnit fil 1: " + FilUtil.average("Opgave6_RandomTal.txt"));
        System.out.println("Gennemsnit fil 2: " + FilUtil.average("Opgave6_RandomTal2.txt"));
    }
}
