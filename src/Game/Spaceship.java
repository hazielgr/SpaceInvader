package Game;

import java.awt.*;


public class Spaceship{
    private int x_pos = 300;
    private int life;
    private int y_pos = 670;
    private Image spaceship;
    
    public Spaceship(){
        this.spaceship = Toolkit.getDefaultToolkit().getImage("Resources/Spaceship.png");
    }

    public Image getImage() {
        return this.spaceship;
    }
	
	
    public int getXpos() {
        return x_pos;
    }
    
    public int getYpos() {
        return y_pos;
    }
	
    public void setYpos(int y_pos) {
	this.y_pos=y_pos;
    }
	
    public void setXpos(int x_pos) {
	this.x_pos=x_pos;
    }
    
   
        
}
