package Opgave2;

import java.util.ArrayList;

public class SwimmerApp {
    
    public static void main(String[] args) {

        ArrayList<Double> lapTimes = new ArrayList<>();
        lapTimes.add(1.02);
        lapTimes.add(1.01);
        lapTimes.add(0.99);
        lapTimes.add(0.98);
        lapTimes.add(1.02);
        lapTimes.add(1.04);
        lapTimes.add(0.99);
        Swimmer s1 = new Swimmer("Jan", 1994, lapTimes, "AGF");

        lapTimes = new ArrayList<>();
        lapTimes.add(1.03);
        lapTimes.add(1.01);
        lapTimes.add(0.99);
        lapTimes.add(0.96);
        lapTimes.add(1.02);
        lapTimes.add(1.04);
        lapTimes.add(0.99);
        Swimmer s3 = new Swimmer("Peter", 1992, lapTimes, "Læsø");

        lapTimes = new ArrayList<>();
        lapTimes.add(1.05);
        lapTimes.add(1.01);
        lapTimes.add(1.04);
        lapTimes.add(1.06);
        lapTimes.add(1.08);
        lapTimes.add(1.04);
        lapTimes.add(1.02);
        Swimmer s2 = new Swimmer("Bo", 1995, lapTimes, "Lyseng");



        //Opgave 2.3
        TrainingPlan levelA = new TrainingPlan('A',16,10);
        TrainingPlan levelB = new TrainingPlan('B',10,6);

        //opgave 2.3
        levelA.addSwimmer(s1);
        levelB.addSwimmer(s2);
        levelA.addSwimmer(s3);

        //Opgave 2.4
        System.out.println("Svømmere med træningsplan level a: ");
        for (Swimmer swimmer : levelA.getSwimmer()) {
            System.out.println(swimmer.getName());
            System.out.println(swimmer.getYearGroup());
            System.out.println(swimmer.getClub());
            System.out.println();
        }
        System.out.println("Svømmere med træningsplan level b: ");
        for (Swimmer swimmer : levelB.getSwimmer()) {
            System.out.println(swimmer.getName());
            System.out.println(swimmer.getYearGroup());
            System.out.println(swimmer.getClub());
            System.out.println();
        }
    }
    
}
