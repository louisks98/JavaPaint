import java.awt.*;

public class Drawer {

    private final DrawerController controller;

    public Drawer(DrawerController controller){
        this.controller = controller;
    }

    public void draw(Graphics g){

        if(controller.getCurrentState() == DrawerController.State.DrawingRectangle){

            int x = Math.min(controller.RectTopPoint.x, controller.dragPoint.x);
            int y = Math.min(controller.RectTopPoint.y, controller.dragPoint.y);

            int width = Math.max(controller.RectTopPoint.x, controller.dragPoint.x) - x;
            int height = Math.max(controller.RectTopPoint.y, controller.dragPoint.y) - y;

            controller.currentDrawRectangle = new Rectangle(x, y, width, height);Graphics2D g2d = (Graphics2D)g.create();
            g2d.setStroke(new BasicStroke(3));
            g2d.setColor(Color.CYAN);
            g2d.draw(controller.currentDrawRectangle);
            g2d.dispose();

        }

        if(!controller.mousePointsList.isEmpty()){
            controller.mousePointsList.forEach((point ->
                    g.drawString("( " + String.valueOf(point.getX()) + ", " + String.valueOf(point.getY()) + " )", (int)point.getX(), (int)point.getY())
            ));
        }

        if(!controller.rectangleList.isEmpty()){
            controller.rectangleList.forEach(rectangle -> g.drawRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height));
        }

    }

}
