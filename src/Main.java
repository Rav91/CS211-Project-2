import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    enum MyColor{
        Black(0, 0, 0),
        Thistle(225, 190, 231),
        Lavender(150, 123, 182),
        Yellow(255, 255, 0),
        LightBlue(135, 206, 250),
        Brown(165, 42, 42),
        LightGreen(124, 252, 0),
        Pink(255, 20, 93);

        private Color color;

        MyColor(int r, int g, int b){
            this.color = Color.rgb(r, g, b);
        }

        public Color getColor(){
            return this.color;
        }
        public void setColor(int r, int b, int g){ this.color = Color.rgb(r, g, b); }

    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Hello World");
        Group root = new Group();
        Canvas canvas = new Canvas(500, 500);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        StackPane pane = new StackPane();
        pane.getChildren().add(canvas);

        MyColor black = MyColor.Black;
        MyColor lavender = MyColor.Lavender;
        MyColor yellow = MyColor.Yellow;
        MyColor lightBlue = MyColor.LightBlue;
        MyColor brown = MyColor.Brown;
        MyColor lightGreen = MyColor.LightGreen;
        MyColor pink = MyColor.Pink;
        MyColor thistle = MyColor.Thistle;

        MyPolygon outer = new MyPolygon(canvas.getWidth()/2, canvas.getHeight()/2, 5, canvas.getWidth()/2);
        outer.setColor(pink.getColor());
        outer.setPolygonColor(lightGreen.getColor());
        outer.draw(gc);

        MyPolygon middle = new MyPolygon(outer.getX(), outer.getY(), 5, outer.getRadius()/Math.sqrt(1.6));
        middle.setColor(brown.getColor());
        middle.setPolygonColor(lightBlue.getColor());
        middle.draw(gc);

        MyPolygon inner = new MyPolygon(outer.getX(), outer.getY(), 5, middle.getRadius()/Math.sqrt(2));
        inner.setColor(yellow.getColor());
        inner.setPolygonColor(lavender.getColor());
        inner.draw(gc);

        MyCircle circle = new MyCircle(canvas.getWidth()/2, canvas.getHeight()/2, inner.getRadius()*Math.sqrt(2.5));
        circle.setColor(thistle.getColor());
        circle.draw(gc);

        MyLine l1 = new MyLine(0, 0, canvas.getWidth(), canvas.getHeight());
        l1.setColor(black.getColor());
        l1.draw(gc);

        MyLine l2 = new MyLine(canvas.getWidth(), 0, 0, canvas.getHeight());
        l2.setColor(black.getColor());
        l2.draw(gc);

        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
