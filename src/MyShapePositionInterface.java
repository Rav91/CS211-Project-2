import javafx.scene.canvas.GraphicsContext;

public interface MyShapePositionInterface extends MyPositionInterface {
    public void getBoundingBox(GraphicsContext g);
    public boolean doOverlap(MyLine line, MyCircle circle, MyPolygon polygon, MyOval oval, MyRectangle rectangle);
}
