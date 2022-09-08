package Windowstegning;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.text.Text;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;

import java.time.Clock;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Gui extends Application {

    private final int WIDTH = 425;
    private final int HEIGHT = 320;
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

        Rectangle background = new Rectangle(0,0,1000,1000);
        pane.getChildren().add(background);
        background.setFill(Color.CADETBLUE);

        Rectangle windowBackShade = new Rectangle(50,50,301,201);
        pane.getChildren().add(windowBackShade);
        windowBackShade.setFill(Color.DIMGRAY);

        Rectangle windowBack = new Rectangle(50,50,300,200);
        pane.getChildren().add(windowBack);
        windowBack.setFill(Color.DARKGRAY);

        Rectangle windowtop = new Rectangle(53,53,294,15);
        pane.getChildren().add(windowtop);
        windowtop.setFill(Color.ROYALBLUE);

        Text text = new Text(56,65 ,"Untitled - Notepad");
        pane.getChildren().add(text);
        text.setFill(Color.WHITE);
        text.setStyle("-fx-font: 12 arial");

        Rectangle xshade = new Rectangle(333,55,12,12);
        pane.getChildren().add(xshade);
        xshade.setFill(Color.DIMGRAY);

        Rectangle x = new Rectangle(333,55,11,11);
        pane.getChildren().add(x);
        x.setFill(Color.DARKGRAY);

        Rectangle maxshade = new Rectangle(318,55,12,12);
        pane.getChildren().add(maxshade);
        maxshade.setFill(Color.DIMGRAY);

        Rectangle max = new Rectangle(318,55,11,11);
        pane.getChildren().add(max);
        max.setFill(Color.DARKGRAY);

        Rectangle minshade = new Rectangle(306,55,12,12);
        pane.getChildren().add(minshade);
        minshade.setFill(Color.DIMGRAY);

        Rectangle min = new Rectangle(306,55,11,11);
        pane.getChildren().add(min);
        min.setFill(Color.DARKGRAY);

        Line close1 = new Line(335,57,342,64);
        pane.getChildren().add(close1);
        close1.setFill(Color.BLACK);

        Line close2 = new Line(342,57,335,64);
        pane.getChildren().add(close2);
        close2.setFill(Color.BLACK);

        Line maxLine = new Line(320,58,327,58);
        pane.getChildren().add(maxLine);
        maxLine.setFill(Color.BLACK);

        Rectangle maxSquare = new Rectangle(320,57,8,8);
        pane.getChildren().add(maxSquare);
        maxSquare.setFill(Color.TRANSPARENT);
        maxSquare.setStroke(Color.BLACK);

        Line minLine = new Line(308,63,313,63);
        pane.getChildren().add(minLine);
        minLine.setFill(Color.BLACK);
        minLine.setStroke(Color.BLACK);

        Rectangle writableshade = new Rectangle(53,82,294,164);
        pane.getChildren().add(writableshade);
        writableshade.setFill(Color.BLACK);

        Rectangle writable = new Rectangle(54,83,294,164);
        pane.getChildren().add(writable);
        writable.setFill(Color.WHITE);

        Text file = new Text(56,79,"File    Edit    Search   Help");
        pane.getChildren().add(file);
        file.setFill(Color.BLACK);

        Text hello = new Text(54,95,"Hello World!");
        pane.getChildren().add(hello);
        hello.setFill(Color.BLACK);

        Rectangle taskbarShade = new Rectangle(0,299,425,20);
        pane.getChildren().add(taskbarShade);
        taskbarShade.setFill(Color.LIGHTGRAY);

        Rectangle taskbar = new Rectangle(0,300,425,20);
        pane.getChildren().add(taskbar);
        taskbar.setFill(Color.DARKGRAY);

        Rectangle clockshade2 = new Rectangle(389,301,35,18);
        pane.getChildren().add(clockshade2);
        clockshade2.setFill(Color.DIMGRAY);

        Rectangle clockshade1 = new Rectangle(390,302,34,17);
        pane.getChildren().add(clockshade1);
        clockshade1.setFill(Color.LIGHTGRAY);

        Rectangle clock = new Rectangle(390,302,33,16);
        pane.getChildren().add(clock);
        clock.setFill(Color.DARKGRAY);

        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Calendar cal = GregorianCalendar.getInstance();
        int minute = cal.get(GregorianCalendar.MINUTE);
        int hour = cal.get(GregorianCalendar.HOUR_OF_DAY);
        String curTime = String.format("%02d:%02d", hour, minute);

        Text clockText = new Text(392, 314, curTime);
        pane.getChildren().add(clockText);
        clockText.setFill(Color.BLACK);

        Rectangle startshade2 = new Rectangle(3,301,35,18);
        pane.getChildren().add(startshade2);
        startshade2.setFill(Color.LIGHTGRAY);

        Rectangle startshade1 = new Rectangle(4,302,34,17);
        pane.getChildren().add(startshade1);
        startshade1.setFill(Color.DIMGRAY);

        Rectangle start = new Rectangle(4,302,33,16);
        pane.getChildren().add(start);
        start.setFill(Color.DARKGRAY);

        Text startText = new Text(7,314,"Start");
        pane.getChildren().add(startText);
        startText.setFill(Color.BLACK);


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

