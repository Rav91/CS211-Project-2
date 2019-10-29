import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyOval extends MyShape {
    MyOval(double x, double y) {
        super(x, y);
    }
    MyOval(double x, double y, double height, double width) {
        super(x, y);
        this.height = height;
        this.width = width;
    }
    private double height;
    private double width;
    private Color ovalColor;

    public Color getOvalColor() {
        return ovalColor;
    }

    public void setOvalColor(Color ovalColor) {
        this.ovalColor = ovalColor;
    }

    void setHeight(double height){
        this.height = height;
    }

    void setWidth(double width){
        this.width = width;
    }

    public String toString(){
        return "MyOval axes: " + getHeight() + ", " + getWidth()
                + "\nMyOval perimeter: " + 2*Math.PI*Math.sqrt(0.5*(getWidth()*getHeight()+getHeight()*getWidth()))
                + "\nMyOval area: " + Math.PI*getWidth()*getHeight();
    }

    public void draw(GraphicsContext gc) {
        gc.setFill(getColor());
        gc.fillRect(getX()-getWidth()/2, getY()-getHeight()/2, getWidth(), getHeight());
        gc.setFill(getOvalColor());
        gc.fillOval(getX()-getWidth()/2, getY()-getHeight()/2, getWidth(), getHeight());
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }
}
