package Game;

import Interfaz.GameWindow;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class Spaceship implements KeyListener {
    private int x_pos;
    private int life;
    private int y_pos;
    private Image spaceship;
    private Bullet bullet;
    private Thread mov;
    private boolean bullMov = false;
    private BulletList bullL;
    
    public Spaceship(){
        this.bullet = new Bullet();
        this.bullL = new BulletList();
        this.y_pos = 670;
        this.x_pos = 300;
        this.spaceship = Toolkit.getDefaultToolkit().getImage("Resources/Spaceship.png");
    }

    public Image getImage() {
        return this.spaceship;
    }
	
	
    public int getXpos() {
        return this.x_pos;
    }
    
    public int getYpos() {
        return this.y_pos;
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
                    createBull();
                    bullMov=true;
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

        @Override
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

    @Override
    public void keyTyped(KeyEvent e) {
    }
    
    public Bullet getBullet(){
        return this.bullet;
    }
    
    public void createBull(){
        Bullet bull = new Bullet();
        bull.setXpos(this.x_pos+5);
        bullL.addBullet(bull);
        
    }
    
    public boolean getBullMov(){
        return this.bullMov;
    }
    
    public BulletList getBullets(){
        return this.bullL;
    }

}
