package Opgave5;

public class Ellipse extends GeometricFigures{
    private double radius1;
    private double radius2;
    public Ellipse(int xCoordinate, int yCoordinate, double radius1,double radius2) {
        super(xCoordinate, yCoordinate);
        this.radius1 = radius1;
        this.radius2 = radius2;
    }
    @Override
    public double getArea() {
        return Math.PI*radius1*radius2;
    }
}
