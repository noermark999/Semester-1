package Opgave3.Exercise6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application
{
    

    @Override
    public void start(Stage stage)
    {
        GridPane root = this.initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Loops");
        stage.setScene(scene);
        stage.show();
    }

    private GridPane initContent()
    {
        GridPane pane = new GridPane();
        Canvas canvas = new Canvas(200, 200);
        pane.add(canvas, 0, 0);
        this.drawShapes(canvas.getGraphicsContext2D());
        return pane;
    }

    // ------------------------------------------------------------------------

    private void drawShapes(GraphicsContext gc)
    {
        gc.strokeLine(0,180,180,180);
        int x = 180;
        int y = 180;
        int length = 6;
        int width = 2;
        gc.strokeLine(x,y,x-length,y-width);
        gc.strokeLine(x,y,x-length,y+width);

        int x1 = 10;
        int y1;
        int y2;
        int antalLinjer = 11;
        for (int i = 1;i<=antalLinjer;i++) {
            if (x1%5==0) {
                y1 = 175;
                y2 = 185;
                gc.fillText(String.valueOf(i-1),x1,y2+10);
            } else {
                y1 = 177;
                y2 = 183;
            }
            gc.strokeLine(x1,y1,x1,y2);
            x1 = x1+x/antalLinjer;
        }
    }

}
