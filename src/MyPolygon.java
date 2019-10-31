import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyPolygon extends MyShape {
    private int numSides;
    private double[] xPoints;
    private double[] yPoints;
    private double radius;
    private Color polygonColor;

    MyPolygon(double x, double y, int numSides, double radius){
        super(x, y);

        this.numSides = numSides;
        this.radius = radius;
        this.xPoints = new double[numSides];
        this.yPoints = new double[numSides];

        for(int i = 0; i < numSides; i++) {
            double angle = 2*Math.PI/numSides;
            this.xPoints[i] = (this.getX()) + radius * Math.sin(i*angle) * -1;
            this.yPoints[i] = (this.getY()) + radius * Math.cos(i*angle) * -1;
        }
    }

    public void setPolygonColor(Color polygonColor){
        this.polygonColor = polygonColor;
    }

    public Color getPolygonColor(){
        return this.polygonColor;
    }

    public String toString(){
        return "MyPolygon side length: " + Math.sqrt(Math.pow(xPoints[0], 2) + Math.pow(yPoints[0], 2))
                + "\nMyPolygon interior angle: " + (numSides-2)*180/numSides
                + "\nMyPolygon Perimeter: " + Math.sqrt(Math.pow(xPoints[0], 2) + Math.pow(yPoints[0], 2))*numSides
                + "\nMyPolygon Area: " + ((Math.sqrt(Math.pow(xPoints[0], 2) + Math.pow(yPoints[0], 2))*numSides)*(Math.sqrt(Math.pow(xPoints[0], 2) + Math.pow(yPoints[0], 2))/(2 * Math.tan(180 / numSides))))/2;
    }

    public void draw(GraphicsContext gc){
        gc.setFill(getColor());
        gc.fillOval(getX()-getRadius(), getY()-getRadius(), 2*getRadius(), 2*getRadius());
        gc.setFill(getPolygonColor());
        gc.fillPolygon(xPoints, yPoints, numSides);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
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
        System.out.println("The coordinates of the bounding box are (" + getX() + "," + getY() + "), (" + (getX()+radius*2)
                + "," + getY() + "), (" + getX() + "," + (getY()-radius*2) + "), (" + (getX()+radius*2) + "," + (getX()-radius*2) + ").");
        g.setFill(Color.BLUE);
        g.fillRect(getX(), getY(), radius*2, radius*2);
    }

    public boolean doOverlap(MyLine line, MyCircle circle, MyPolygon polygon, MyOval oval, MyRectangle rectangle){
        if(line.getX() == this.getX() || circle.getX() == this.getX() || oval.getX() == this.getX() || rectangle.getX() == this.getX() ){
            return true;
        }
        else{
            return false;
        }
    }
}
