/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Game.Basic;
import Game.Bullet;
import Game.Enemy;
import Game.Spaceship;
import java.awt.Color;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author mario
 */
public class GameWindow extends JFrame {
    private ImageIcon imageBackground;
   
    private Basic basic;
    private Spaceship spaceship;
    public static Enemy temp2;
    private int paintEne;
    private int limitX = 530;
    private Bullet bullet;
    private Container contenedor;
    private Thread movE;
    private int cont2=5;
    private int cont=0;
    public static int cont1=0;
    
    
    
    public GameWindow(Basic basic, Spaceship spaceship){
        this.basic = basic;
        
        this.spaceship = spaceship;
        this.imageBackground = new ImageIcon("Resources/background.jpg");
        this.bullet = spaceship.getBullet();
        
        
        
        this.movE = new Thread(new Runnable(){
        public void run(){
            while(movE.isAlive()){
                try {
                    if(spaceship.getBullMov()==true){
                        Bullet temp3 = spaceship.getBullets().getHead();
                        while(temp3!=null){
                        temp3.move();
                        temp3.getlbl().setBounds(temp3.getXpos(), temp3.getYpos(),80,60);
                        contenedor.add(temp3.getlbl());
                        temp3=temp3.getNext();
                        }
                        movE.join(20);
                    }
                    else{
                    contenedor.add(enemyp);
                    movE.join(20);
                    }
                    contenedor.repaint();
                    
                } catch (InterruptedException ex) {
                    
                    Logger.getLogger(GameWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    });
      
    }
    
    
    public void init(){
        setTitle("Space Invaders");
        //no deja que el tamano de la ventana cambie
        setResizable(false);
        //quita la barra de arriba y no deja mover la ventana
        setUndecorated(true);
        //colo icono a la aplicacion
        setIconImage(spaceship.getImage());
        setSize(1500,800);
        //ubica la ventana en el centro de la ventana
        setLocationRelativeTo(null);
        //agrega bordes al panel principal de la ventana
        getRootPane().setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.decode("#2F4F4F")));
        
        JLabel lbl = new JLabel();
        lbl.setBounds(300, 300,300, 300);
        lbl.setIcon(imageBackground);
        lbl.setBorder(BorderFactory.createMatteBorder(0,5, 0, 0, Color.decode("#2F4F4F")));
        
        
        
        
        JPanel panels =  new JPanel();
        panels.setPreferredSize(new Dimension(300,300));
        panels.setLayout(new BorderLayout());
        panels.add(lbl);
        
         
        contenedor = getContentPane();
        contenedor.setBackground(Color.black);
        contenedor.add(panels,BorderLayout.EAST);
        
        contenedor.add(spacep);

        movE.start();
        
        
    }
    
    private JPanel enemyp = new JPanel(){
    public void paintComponent(Graphics g){
        Enemy temp = basic.getHead();
        paintEne=0;
        if(temp==null){
            System.out.println("NEXT LEVEL");
        }
        while(temp !=null){
            g.drawImage(temp.getImage(),temp.getXpos()+paintEne,temp.getYpos(),100,50,this);
            if(temp.getXpos()<limitX & temp.getMovX()==true){
		temp.moveR();
            }
            else if(temp.getXpos()>limitX & temp.getMovY()==true) {
		for(int i=0;i<30;i+=1 ) {
                    temp.moveY();    
		}
		temp.setMovX(false);
		temp.setMovY(false);
            } 
            else if(temp.getXpos()>limitX & temp.getMovX()==false) {
		temp.moveL();	
            }
            else if(temp.getXpos()<limitX & temp.getMovX()==false & temp.getXpos()>9) {
		temp.moveL();
            }
            else if(temp.getXpos()<9 & temp.getMovY()==false) {
                for(int i=0;i<30;i+=1 ) {
                    temp.moveY();
                }
                temp.setMovX(true);
                temp.setMovY(true);
            }
            temp=temp.getNext();
            paintEne+=110;        
        }
    }
    };
    
    private JPanel spacep = new JPanel(){
    public void paintComponent(Graphics g){
      if(basic.empty()==true){
          g.drawImage(spaceship.getImage(),spaceship.getXpos(),spaceship.getYpos(),110,110,this);
      }
      else{
        while(cont<=cont2){
        temp2=basic.getEnemy(cont);
        int pos = GameWindow.getCont(cont);
            if(temp2.getXpos()+pos-30<bullet.getXpos() & bullet.getXpos()<temp2.getXpos()+pos+30 & temp2.getYpos()-30<bullet.getYpos() & bullet.getYpos()<temp2.getYpos()+30 & bullet.getMov()==true ){
                limitX+=110;
                contenedor.remove(bullet.getlbl());
                bullet.remove();
                basic.DeleteEne(cont);
                g.drawImage(spaceship.getImage(),spaceship.getXpos(),spaceship.getYpos(),110,110,this);
                bullet.setMov(false);
                cont2--;
                break;
            }
            else{
            cont++;
            }
        }
        cont=0;
        
      }
      g.drawImage(spaceship.getImage(),spaceship.getXpos(),spaceship.getYpos(),110,110,this);
      
      
    }
    };     
    
    public  static int getCont(int x){
        int conteo=110*x;
        return conteo;
    }
       
}
