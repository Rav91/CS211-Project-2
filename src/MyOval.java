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

    double getPerimeter(){
        return  2*Math.PI*Math.sqrt(0.5*(getWidth()*getHeight()+getHeight()*getWidth()));
    }

    double getArea(){
        return Math.PI*getWidth()*getHeight();
    }

    public String toString(){
        return "MyOval axes: " + getHeight() + ", " + getWidth()
                + "\nMyOval perimeter: " + this.getPerimeter()
                + "\nMyOval area: " + this.getArea();
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

    public String getPoint(){
        return "("+ getX() + ","+ getY() +")";
    }

    public void moveTo(double dx, double dy) {
        setX(getX()+dx);
        setY(getY()+dy);
    }

    public double distanceTo(double x, double y){
        return Math.ceil(Math.sqrt((Math.pow((x-getX()),2))+(Math.pow((y-getY()),2))));
    }

    public void getBoundingBox(GraphicsContext g) {
        System.out.println("The coordinates of the bounding box are (" + getX() + "," + getY() + "), (" +
                (getX()+width) + "," + getY() + "), (" + getX() + "," + (getY()-height) + "), (" + (getX()+width) + "," + (getX()-height) + ").");
        g.setFill(Color.BLUE);
        g.fillRect(getX(), getY(), width, height);
    }

    public boolean doOverlap(MyLine line, MyCircle circle, MyPolygon polygon, MyOval oval, MyRectangle rectangle){
        if(line.getX() == this.getX() || circle.getX() == this.getX() || polygon.getX() == this.getX() || rectangle.getX() == this.getX() ){
            return true;
        }
        else{
            return false;
        }
    }
}
