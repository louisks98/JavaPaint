import javax.swing.*;
import java.awt.event.*;

public class MainWindow {
    private JPanel MainPanel;
    private JMenuBar menuBar;
    private PainterPanel painterPanel;
    public DrawerController controller;

    public MainWindow() {

        controller = new DrawerController();
        menuBar = createMenuBar();

        painterPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);

                if(controller.getCurrentState() == DrawerController.State.RectangleFirstPt){
                    controller.RectTopPoint = e.getPoint();
                    controller.setCurrentState(DrawerController.State.DrawingRectangle);
                }
                painterPanel.controller = controller;
            }
        });
        painterPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseMoved(e);
                if(controller.getCurrentState() == DrawerController.State.DrawingRectangle){
                    controller.setCurrentState(DrawerController.State.DrawingRectangle);
                    controller.dragPoint = e.getPoint();
                    painterPanel.controller = controller;
                    painterPanel.repaint();
                }
            }
        });
        painterPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if(controller.getCurrentState() == DrawerController.State.DrawingRectangle){
                    controller.setCurrentState(DrawerController.State.Pointer);
                    controller.createRectangle(e.getPoint());
                }
                painterPanel.controller = controller;
                painterPanel.repaint();
            }
        });
    }

    private JMenuBar createMenuBar(){
        menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem openItemMenu = new JMenuItem("Open");
        JMenuItem exitItemMenu = new JMenuItem("Exit");
        fileMenu.add(openItemMenu);
        fileMenu.add(exitItemMenu);

        JMenu shapeMenu = new JMenu("Shapes");
        JMenuItem rectItemMenu = new JMenuItem("Rectangle");
        rectItemMenu.addActionListener(actionEvent -> controller.setCurrentState(DrawerController.State.RectangleFirstPt));

        shapeMenu.add(rectItemMenu);

        menuBar.add(fileMenu);
        menuBar.add(shapeMenu);
        return menuBar;
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("MainWindow");
        MainWindow mainWindow = new MainWindow();
        frame.setContentPane(mainWindow.MainPanel);
        frame.setJMenuBar(mainWindow.menuBar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
