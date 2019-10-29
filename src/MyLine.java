import javafx.scene.canvas.GraphicsContext;

public class MyLine extends MyShape {
    MyLine(double x, double y) {
        super(x, y);
    }
    private double x2;
    private double y2;
    MyLine(double x, double y, double x2, double y2){
        super(x, y);
        this.x2 = x2;
        this.y2 = y2;
    }

    public String toString(){
        return "MyLine length: " + Math.sqrt(Math.pow((getX()-x2), 2) + Math.pow((getY()-y2), 2))
                + "\n" + "Angle with respect to x-axis: " + Math.atan((y2-getY())/(x2-getX()));
    }

    public void draw(GraphicsContext gc){
        gc.setStroke(getColor());
        gc.strokeLine(getX(), getY(), x2, y2);
    }
}
