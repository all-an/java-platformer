/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Platformer;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author all-a
 */
public class Player {
    
    GamePanel panel;
    int x, y, width, height;
    double xspeed, yspeed;
    
    Rectangle hitBox;
    
    boolean keyLeft, keyRight, keyUp, keyDown;
    
    public Player(int x, int y, GamePanel panel){
        this.panel = panel;
        this.x = x;
        this.y = y;
    
        width = 50;
        height = 100;
        hitBox = new Rectangle(x, y, width, height);
        
    } 
    
    public void set(){
        
        x += xspeed;
        y += yspeed;
        
        hitBox.x = x;
        hitBox.y = y;
    }
    
    public void draw(Graphics2D gtd){
        gtd.setColor(Color.BLACK);
        gtd.fillRect(x, y, width, height);
    }
    
}
