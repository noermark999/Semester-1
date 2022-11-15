package Opgave5;

import java.util.ArrayList;

import static Opgave5.GeometricFigures.totalArea;

public class App {
    public static void main(String[] args) {
        ArrayList<GeometricFigures> figures = new ArrayList<>();

        Circle circle = new Circle(100,50,10);
        figures.add(circle);
        System.out.println("Circle area: " + circle.getArea());

        Ellipse ellipse = new Ellipse(200,100,10,5);
        figures.add(ellipse);
        System.out.println("Ellipse area: " + ellipse.getArea());

        Rectangle rectangle = new Rectangle(0,0,50,25);
        figures.add(rectangle);
        System.out.println("Rectangle area: " + rectangle.getArea());

        Square square = new Square(50,50,20);
        figures.add(square);
        System.out.println("Square area: " + square.getArea());

        System.out.println("Total area: " + totalArea(figures));
        System.out.println();

        System.out.println("Circle X coordinate: " + circle.getXCoordinate());
        circle.offsetX(100);
        System.out.println("The coordinate is offset by 100");
        System.out.println("Circle X coordinate: " + circle.getXCoordinate());
        System.out.println();

        System.out.println("Circle Y coordinate: " + circle.getYCoordinate());
        circle.offsetY(-10);
        System.out.println("The coordinate is offset by -10");
        System.out.println("Circle X coordinate: " + circle.getYCoordinate());



    }
}
