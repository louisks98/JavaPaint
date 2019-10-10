import java.awt.*;

public class Drawer {

    public final DrawerController controller;

    public Drawer(DrawerController controller){
        this.controller = controller;
    }

    public void draw(Graphics g){

        if(!controller.mousePointsList.isEmpty()){
            controller.mousePointsList.forEach((point ->
                    g.drawString("( " + String.valueOf(point.getX()) + ", " + String.valueOf(point.getY()) + " )", (int)point.getX(), (int)point.getY())
            ));
        }

    }

}
