/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;


import javax.swing.*;

public class Bullet {
    private ImageIcon bullet;
    private int x_pos=0;
    private int y_pos = 0;
  
    
    public Bullet(){
        this.bullet = new ImageIcon("Resources/bullet1.png");
        
        
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
 
     
    
     
}
