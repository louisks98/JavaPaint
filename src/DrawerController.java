import java.awt.*;
import java.util.ArrayList;

public class DrawerController {

    public enum State{Pointer, RectangleFirstPt, DrawingRectangle, RectangleLastPt}

    public ArrayList<Point> mousePointsList;
    public ArrayList<Rectangle> rectangleList;
    private State currentState;
    public Rectangle currentDrawRectangle;
    public Point RectTopPoint;
    public Point dragPoint;

    DrawerController(){
        mousePointsList = new ArrayList<>();
        rectangleList = new ArrayList<>();
    }

    public void addMousePoint(Point mousePoint){
        mousePointsList.add(mousePoint);
    }

    public void createRectangle(Point point){
        int x = Math.min(this.RectTopPoint.x, this.dragPoint.x);
        int y = Math.min(this.RectTopPoint.y, this.dragPoint.y);

        int width = Math.max(this.RectTopPoint.x, this.dragPoint.x) - x;
        int height = Math.max(this.RectTopPoint.y, this.dragPoint.y) - y;
        rectangleList.add(new Rectangle(x, y, width, height));
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public State getCurrentState() {
        return currentState;
    }
}
