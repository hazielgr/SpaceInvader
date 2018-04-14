/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Interfaz.Manager;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Bullet {
    private ImageIcon bullet;
    private int x_pos;
    private int y_pos;
    private Bullet next;
    private boolean move = false;
    private Thread movement;
    private JLabel lblB;
    
    public Bullet(){
        this.lblB = new JLabel();
        
        this.bullet = new ImageIcon("Resources/bullet1.png");
        this.lblB.setIcon(bullet);
        this.y_pos=700;
        this.next = null;
    }
    
    public ImageIcon getImage(){
        return this.bullet;
    }
    
    public int getXpos(){
        return this.x_pos;
    }
    
    public int getYpos(){
        return this.y_pos;
    }
    
    public void setXpos(int x_pos){
        this.x_pos = x_pos;
    }
    public void setMov(boolean mov){
         this.move=mov;
     }
     
     public boolean getMov(){
         return this.move;
     }
     
     public Thread getMovB(){
         return this.movement;
     }
     
     public void createlbl(){
         JLabel lblB = new JLabel();
         lblB.setIcon(bullet);
         this.setLbl(lblB);
     }
     
     public void setLbl(JLabel lbl){
         this.lblB = lbl;
     }
     
     public JLabel getlbl(){
         return this.lblB;
     }
     public void setlblBounds(int x_pos, int y_pos){
         this.lblB.setBounds(x_pos, y_pos, 100,150);
     }
     public void resetYpos(){
         this.y_pos = 700;
     }
     
     public void remove(){
         this.lblB = null;
     }
     public void move(){
         this.y_pos-=16;
     }
     
     public Bullet getNext(){
         return this.next;
     }
     
     public void setNext(Bullet b){
            this.next=b;
        }
}
