import javafx.scene.canvas.GraphicsContext;

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
}
