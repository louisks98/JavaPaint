import javax.swing.*;
import java.awt.*;

public class PainterPanel extends JPanel {

    //public Point mousePoint;
    public DrawerController controller;

    public PainterPanel(){
    }

    public PainterPanel(MainWindow mainWindow){
        setPreferredSize(new Dimension(800, 600));
    }


    @Override
    protected void paintComponent( Graphics g ) {
        super.paintComponent(g);
        if(controller != null){
            Drawer drawer = new Drawer(controller);
            drawer.draw(g);
        }


    }

}
