package Opgave1;


public class Student {
    private String name;
    private boolean active;
    private int age;
    
    private final int[] grades; // indeholder den studerendes karakterer
    private int numberOfGrades;
    
    private static final int MAX_NUMBER_OF_GRADES = 10;
    // det hoejeste antal karakterer en studerende kan have
    
    /*
     * Constructor, naar den studerende oprettes, skal den have et navn. Ved
     * oprettelse er den studerende ikke aktiv
     */
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.active = false;
        
        numberOfGrades = 0;
        grades = new int[MAX_NUMBER_OF_GRADES];
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setActive(boolean active) {
        this.active = active;
    }
    
    public boolean isActive() {
        return active;
    }
    
    /*
     * Tilføjer en karakter til den studerende. Hvis den studerende allerede har
     * 10 karakterer registreres intet
     */
    public void addGrade(int grade) {
        if (numberOfGrades < MAX_NUMBER_OF_GRADES) {
            grades[numberOfGrades] = grade;
            numberOfGrades++;
        }
    }

    public double averageGrade() {
        int sum = 0;
        double average = 0.0;
        for (int i = 0; i < numberOfGrades; i++) {
            sum = sum + grades[i];
        }
        if (numberOfGrades > 0) {
            average = (double) sum / numberOfGrades;
        }
        return average;
    }
    
    /*
     * Returnerer alle de karakterer den studerende har opnået
     */
    public int[] getGrades() {
        return grades;
    }
    
    /*
     * Returnerer antallet af karakterer den studerende har fået
     */
    public int getNumberOfGrades() {
        return numberOfGrades;
    }

    /**
     * Finder den højeste karakter for en person, Opgave 1.b
     * @return Der returneres den højeste karakter som int
     */
    public int maxGrade() {
        int maxGrade = -10;
        for (int i = 0; i<numberOfGrades; i++) {
            if (maxGrade<grades[i]){
                maxGrade = grades[i];
            }
        }
        return maxGrade;
    }

    /**
     * Finder den laveste karakter for en person, Opgave 1.c
     * @return Der returneres den laveste karakter
     */
    public int minGrade() {
        int minGrade = 20;
        for (int i = 0; i<numberOfGrades; i++) {
            if (minGrade>grades[i]){
                minGrade = grades[i];
            }
        }
        return minGrade;
    }
}
