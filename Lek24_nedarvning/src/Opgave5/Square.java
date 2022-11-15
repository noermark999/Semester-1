package Opgave5;

public class Square extends GeometricFigures{
    private double side;

    public Square(int xCoordinate, int yCoordinate, double side) {
        super(xCoordinate, yCoordinate);
        this.side = side;
    }
    @Override
    public double getArea() {
        return Math.pow(side, 2);
    }

}
