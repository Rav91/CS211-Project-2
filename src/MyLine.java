import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

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

    public String getPoint(){
        return "("+ getX() + ","+ getY() +")";
    }

    public void moveTo(double dx, double dy) {
        setX(getX()+dx);
        setY(getY()+dy);
    }

    public double distanceTo(double x, double y){
        return Math.sqrt((Math.pow((x-getX()),2))+(Math.pow((y-getY()),2)));
    }

    public void getBoundingBox(GraphicsContext g) {
        System.out.println("The coordinates of the bounding box are (" + getX() + "," + getY() + "), (" + x2 + "," + y2 + "), ("
                + (getX()-5) + "," + (getY()-10) + "), (" + (getX()+Math.sqrt(Math.pow((getX()-x2), 2) + Math.pow((getY()-y2), 2))-5)
                + "," + (getX()-5) + ").");
        g.setFill(Color.BLUE);
        g.fillRect(getX(), getY(), 10, Math.sqrt(Math.pow((getX()-x2), 2) + Math.pow((getY()-y2), 2)));
    }

    public boolean doOverlap(MyLine line, MyCircle circle, MyPolygon polygon, MyOval oval, MyRectangle rectangle){
        if(oval.getX() == this.getX() || circle.getX() == this.getX() || polygon.getX() == this.getX() || rectangle.getX() == this.getX() ){
            return true;
        }
        else{
            return false;
        }
    }
}
