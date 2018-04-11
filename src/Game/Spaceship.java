package Game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Spaceship implements KeyListener{
    private int x_pos = 300;
    private int life;
    private int y_pos = 670;
    private Image spaceship;
    private Thread mov;
    
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
    
    public void keyPressed(KeyEvent e) {
        mov = new Thread(new Runnable(){
            public void run(){
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    while(mov.isAlive()){
                        if(x_pos>1060){
                            mov.stop();
                        }
                        else{
                            x_pos+=20;
                        }
                        try {
                            
                            mov.join(10);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Spaceship.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                if(e.getKeyCode() == KeyEvent.VK_LEFT) {
                    while(mov.isAlive()){
                        if(x_pos<20){
                            mov.stop();
                        }
                        else{
                            x_pos-=20;
                        }
                        try {
                            mov.join(10);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Spaceship.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                if(e.getKeyCode() == KeyEvent.VK_SPACE){
                    System.out.println("    Disparo    ");
                    
                }
                try {
                    mov.sleep(40);
                    mov.join();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Spaceship.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        mov.start();
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.x_pos+=0;
            this.mov.stop();
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.x_pos-=0;
            this.mov.stop();
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            
        }
    }

    public void keyTyped(KeyEvent e) {
    }
   
        
}
