package Platformer;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.WindowConstants;

public class App {
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();      
        
                
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(1400, 700);
        
        /*Full screen
        frame.setExtendedState(frame.MAXIMIZED_BOTH); 
        frame.setUndecorated(true);
        */
        
        frame.setLocation((int)(screenSize.getWidth()/2 - frame.getSize().getWidth()/2),(int)(screenSize.getHeight()/2 - frame.getSize().getHeight()/2));
    
        frame.setResizable(false);
        frame.setTitle("Platformer Game");
        frame.setVisible(true);
        
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    
    }
}
