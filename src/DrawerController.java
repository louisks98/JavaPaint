import java.awt.*;
import java.util.ArrayList;

public class DrawerController {

    public enum State{Pointer, Rectangle}

    public ArrayList<Point> mousePointsList;
    public ArrayList<Rectangle> rectangleList;
    private State currentState;

    DrawerController(){
        mousePointsList = new ArrayList<Point>();
        rectangleList = new ArrayList<Rectangle>();
    }

    public void addMousePoint(Point mousePoint){
        mousePointsList.add(mousePoint);
    }

    public void addRectangle(Rectangle rect){
        rectangleList.add(rect);
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public State getCurrentState() {
        return currentState;
    }
}
