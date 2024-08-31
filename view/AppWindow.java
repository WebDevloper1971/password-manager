package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class AppWindow extends JFrame{
    
    final static int MAIN_WIDTH = 700;
    final static int MAIN_HEIGHT = 600;

    private Dimension size = new Dimension(MAIN_WIDTH,MAIN_HEIGHT);

    static JPanel app_panel;


    public AppWindow(){

        app_panel = new JPanel();
        app_panel.setPreferredSize(size);
        // app_panel.setBackground(Color.pink);
        app_panel.setBackground(Color.white);
        app_panel.setLayout(new BorderLayout());
        add(app_panel);

        update_panel(new SavePanel());
        // update_panel(new ShowPanel());

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }
    

    public static void update_panel(JPanel panel){
        app_panel.removeAll();
        app_panel.add(panel);
        app_panel.repaint();
        app_panel.revalidate();
    }

}
