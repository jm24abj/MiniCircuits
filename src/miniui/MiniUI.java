package miniui;

import java.awt.*;
import javax.swing.JFrame;

public class MiniUI {
    public static void main(String[] args) {    
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        window.setSize((int) (screenSize.getWidth() / 1.1),(int) (screenSize.getHeight() / 1.1));
        //window.setExtendedState(JFrame.MAXIMIZED_BOTH); // sets screen to full screen
        window.setVisible(true);
    }
}
