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
        Lavender(150, 123, 182),
        Yellow(255, 255, 0),
        LightBlue(135, 206, 250),
        Brown(165, 42, 42),
        LightGreen(124, 252, 0),
        Beige(245, 245, 220);

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
        Canvas canvas = new Canvas(500, 250);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        StackPane pane = new StackPane();
        pane.getChildren().add(canvas);

        MyColor black = MyColor.Black;
        MyColor lavender = MyColor.Lavender;
        MyColor yellow = MyColor.Yellow;
        MyColor lightBlue = MyColor.LightBlue;
        MyColor brown = MyColor.Brown;
        MyColor lightGreen = MyColor.LightGreen;
        MyColor beige = MyColor.Beige;

        MyOval outer = new MyOval(canvas.getWidth()/2, canvas.getHeight()/2, canvas.getHeight()/2, canvas.getWidth()/2);
        outer.setColor(beige.getColor());
        outer.setOvalColor(lightGreen.getColor());
        outer.draw(gc);

        MyOval middle = new MyOval(outer.getX(), outer.getY(), outer.getHeight()/Math.sqrt(2), outer.getWidth()/Math.sqrt(2));
        middle.setColor(brown.getColor());
        middle.setOvalColor(lightBlue.getColor());
        middle.draw(gc);

        MyOval inner = new MyOval(outer.getX(), outer.getY(), middle.getHeight()/Math.sqrt(2), middle.getWidth()/Math.sqrt(2));
        inner.setColor(yellow.getColor());
        inner.setOvalColor(lavender.getColor());
        inner.draw(gc);

        MyLine l = new MyLine(0, 0, canvas.getWidth(), canvas.getHeight());
        l.setColor(black.getColor());
        System.out.println(l);
        l.draw(gc);

        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
