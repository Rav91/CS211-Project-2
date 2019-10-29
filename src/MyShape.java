import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class MyShape {
    private double x;
    private double y;
    private Color color;

    MyShape(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public String toString(){
        return "MyShape centered at x = " + x + ", y = " + y;
    }

    public void draw(GraphicsContext gc, Canvas canvas){
        gc.setFill(getColor());
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getWidth());
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
