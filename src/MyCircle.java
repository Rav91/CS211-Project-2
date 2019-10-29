import javafx.scene.canvas.GraphicsContext;

public class MyCircle extends MyOval {
    private double radius;
    MyCircle(double x, double y, double radius){
        super(x, y);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String toString(){
        return "MyCircle radius: " + getRadius()
                + "\nMyCircle perimeter: " + 2*Math.PI*getRadius()
                + "\nMyCircle area: " + Math.PI*Math.pow(getRadius(), 2);
    }

    public void draw(GraphicsContext gc){
        gc.setFill(this.getColor());
        gc.fillOval(getX()-getRadius()/2, getY()-getRadius()/2, getRadius(), getRadius());
    }
}
