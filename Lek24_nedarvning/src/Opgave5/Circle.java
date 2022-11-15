package Opgave5;

public class Circle extends GeometricFigures{
    private double radius;

    public Circle(int xCoordinate, int yCoordinate, double radius) {
        super(xCoordinate,yCoordinate);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI*radius;
    }
}
