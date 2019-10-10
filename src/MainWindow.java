import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                if(controller.getCurrentState() == DrawerController.State.RectangleFirstPt){
                    //todo
                }
                //controller.addMousePoint(e.getPoint());
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
        rectItemMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                controller.setCurrentState(DrawerController.State.RectangleFirstPt);
            }
        });

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
