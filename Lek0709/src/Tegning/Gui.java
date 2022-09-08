package Tegning;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;
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

            Polygon tail = new Polygon(10,50,75,150,10,250);
            pane.getChildren().add(tail);
            tail.setFill(Color.SLATEGRAY);

            // Ellipse with centrum (70,230) radius1 50 and radius2 100
            Ellipse body = new Ellipse(200,150,150,75);
            pane.getChildren().add(body);
            body.setFill(Color.SLATEGRAY);

            Polygon mouth = new Polygon(265,155,350,165,325,200);
            pane.getChildren().add(mouth);
            mouth.setFill(Color.WHITE);





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

