/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Platformer;

import java.awt.Color;

/**
 *
 * @author all-a
 */
public class MainFrame extends javax.swing.JFrame {

    public MainFrame(){
        GamePanel panel = new GamePanel();
        panel.setLocation(0, 0);
        panel.setSize(this.getSize());
        panel.setBackground(Color.YELLOW);
        panel.setVisible(true);
        this.add(panel);
    }
    
    
    
}
