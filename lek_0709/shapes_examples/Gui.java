package shapes_examples;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class Gui extends Application {

    private final int WIDTH = 1000;
    private final int HEIGHT = 1000;
    @Override
    public void start(Stage stage) {
        Pane root = initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Shapes");
        stage.setScene(scene);
        stage.show();

    }

    private Pane initContent() {
        Pane pane = new Pane();
        pane.setPrefSize(WIDTH, HEIGHT);
        drawShapes(pane);
        return pane;
    }

    // ------------------------------------------------------------------------

    private void drawShapes(Pane pane) {
            Color gul = Color.YELLOW;
            int offset100 = 100;

            Circle circle = new Circle(10, 70, 10);
            // Circle centrum 100,70 og radius 10
            pane.getChildren().add(circle);
            circle.setFill(gul);
            circle.setStroke(Color.BLACK);
            circle.setTranslateX(offset100);

            Rectangle Rektangel = new Rectangle(1, 1, 75, 25);
            pane.getChildren().add(Rektangel);
            Rektangel.setFill(gul);
            Rektangel.setTranslateX(offset100);

            Line linje = new Line(1, 30, 75, 30);
            pane.getChildren().add(linje);
            linje.setStroke(gul);
            linje.setTranslateX(offset100);

            Rectangle reknavn = new Rectangle(1, 100, 100, 50);
            pane.getChildren().add(reknavn);
            reknavn.setFill(Color.BLUE);

            Text navn = new Text(25, 125, "Jakob");
            pane.getChildren().add(navn);
            navn.setFill(Color.RED);

            Circle hoved = new Circle(50, 200, 30);
            pane.getChildren().add(hoved);
            hoved.setFill(Color.WHITE);
            hoved.setStroke(Color.BLACK);

            Circle eye1 = new Circle(40, 192, 3);
            pane.getChildren().add(eye1);
            eye1.setFill(Color.WHITE);
            eye1.setStroke(Color.BLACK);

            Circle eye2 = new Circle(60, 192, 3);
            pane.getChildren().add(eye2);
            eye2.setFill(Color.WHITE);
            eye2.setStroke(Color.BLACK);

            Line mund = new Line(37, 208, 63, 208);
            pane.getChildren().add(mund);

            Circle skydeskiveYderst = new Circle(50, 300, 22.5);
            pane.getChildren().add(skydeskiveYderst);
            skydeskiveYderst.setStrokeWidth(5);
            skydeskiveYderst.setFill(Color.WHITE);
            skydeskiveYderst.setStroke(Color.BLACK);

            Circle skydeskiveMidt = new Circle(50, 300,12.5);
            pane.getChildren().add(skydeskiveMidt);
            skydeskiveMidt.setStrokeWidth(5);
            skydeskiveMidt.setFill(Color.WHITE);
            skydeskiveMidt.setStroke(Color.BLACK);

            Circle skydeskiveInderst = new Circle(50, 300,2.5);
            pane.getChildren().add(skydeskiveInderst);
            skydeskiveInderst.setStrokeWidth(5);
            skydeskiveInderst.setFill(Color.WHITE);
            skydeskiveInderst.setStroke(Color.BLACK);

            Circle olblue = new Circle(75,400,50);
            pane.getChildren().add(olblue);
            olblue.setStrokeWidth(4);
            olblue.setStroke(Color.BLUE);
            olblue.setFill(Color.WHITE);

            Circle olblack = new Circle(175,400,50);
            pane.getChildren().add(olblack);
            olblack.setStrokeWidth(4);
            olblack.setStroke(Color.BLACK);
            olblack.setFill(Color.WHITE);

            Circle olred = new Circle(275,400,50);
            pane.getChildren().add(olred);
            olred.setStrokeWidth(4);
            olred.setStroke(Color.RED);
            olred.setFill(Color.WHITE);

            Circle olYellow = new Circle(125,450,50);
            pane.getChildren().add(olYellow);
            olYellow.setStrokeWidth(4);
            olYellow.setStroke(Color.YELLOW);
            olYellow.setFill(Color.TRANSPARENT);

            Circle olGreen = new Circle(225,450,50);
            pane.getChildren().add(olGreen);
            olGreen.setStrokeWidth(4);
            olGreen.setStroke(Color.GREEN);
            olGreen.setFill(Color.TRANSPARENT);

            Circle sun = new Circle(900, 100, 30);
            pane.getChildren().add(sun);
            sun.setFill(Color.YELLOW);

            Line ground = new Line(600,300,850,300);
            pane.getChildren().add(ground);
            ground.setFill(Color.BROWN);

            Rectangle house = new Rectangle(650,180,120,120);
            pane.getChildren().add(house);
            house.setFill(Color.RED);

            Polygon roof = new Polygon(625,180,710,120,795,180);
            pane.getChildren().add(roof);
            roof.setFill(Color.GREEN);

            

    }
/*        Line line = new Line(70, 70, 100, 70); // Line from (70,70) to (100,70)
        pane.getChildren().add(line);

        // Rectangle from (100,40) width 75 and height 25
        Rectangle rektangel = new Rectangle(100, 40, 75, 25);
        pane.getChildren().add(rektangel);
        rektangel.setFill(Color.CORAL);

        // Polygon with 3 points (100,100)(200,100)(150,150)
        Polygon polygon = new Polygon(100, 100, 200, 100, 150, 150);
        pane.getChildren().add(polygon);
        polygon.setFill(Color.PINK);

        // Ellipse with centrum (70,230) radius1 50 and radius2 100
        Ellipse ellipse = new Ellipse(70, 230, 50, 100);
        pane.getChildren().add(ellipse);
        ellipse.setFill(Color.YELLOW);
        ellipse.setStroke(Color.GREEN);
        ellipse.setStrokeWidth(5);

        // Text Datamatiker placed at 100,350
        Text text = new Text(100, 350, "Datamatiker");
        text.setFill(Color.BLUEVIOLET);
        pane.getChildren().add(text);

*/


}

