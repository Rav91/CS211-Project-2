import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyRectangle extends MyShape {
    MyRectangle(double x, double y) {
        super(x, y);
    }
    private double height;
    private double width;
    MyRectangle(double x, double y, double height, double width){
        super(x, y);
        this.height = height;
        this.width = width;
    }

    double getHeight(){
        return  height;
    }

    double getWidth(){
        return width;
    }

    void setHeight(double height){
        this.height = height;
    }

    void setWidth(double width){
        this.width = width;
    }

    public String toString(){
        return "MyRectangle height: " + height
                + "\nMyRectangle width: " + width
                + "\nMyRectangle perimeter: " + 2*(height+width)
                + "\nMyRectangle area: " + height*width;
    }

    public void draw(GraphicsContext gc){
        gc.setFill(getColor());
        gc.fillRect(getX()-width/2, getY()-height/2, width, height);
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
        System.out.println("The coordinates of the bounding box are (" + getX() + "," + getY() + "), (" +
                (getX()+width) + "," + getY() + "), (" + getX() + "," + (getY()-height) + "), (" + (getX()+width) + "," + (getX()-height) + ").");
        g.setFill(Color.BLUE);
        g.fillRect(getX(), getY(), width, height);
    }

    public boolean doOverlap(MyLine line, MyCircle circle, MyPolygon polygon, MyOval oval, MyRectangle rectangle){
        if(line.getX() == this.getX() || circle.getX() == this.getX() || polygon.getX() == this.getX() || oval.getX() == this.getX() ){
            return true;
        }
        else{
            return false;
        }
    }
}
