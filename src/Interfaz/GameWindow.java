/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Game.Basic;
import Game.Enemy;
import Game.Spaceship;
import java.awt.Color;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author mario
 */
public class GameWindow extends JFrame {
    private ImageIcon imageBackground;
    private Spaceship spaceship;
    private Thread movE;
    private Container contenedor;
    private int paintEne;
    private Basic basic;
    private Enemy enemy = new Enemy();
    private Enemy enemy2 = new Enemy();
    private Enemy enemy3 = new Enemy();

    
    public GameWindow(Spaceship spaceship){
        this.spaceship = spaceship;
        this.basic = new Basic();
        basic.addEnemy(enemy);
        basic.addEnemy(enemy2);
        basic.addEnemy(enemy3);
        this.imageBackground = new ImageIcon("Resources/background.jpg");
        this.movE = new Thread(new Runnable(){
        public void run(){
            while(movE.isAlive()){
                try {
                    contenedor.add(enemyp);
                    contenedor.repaint();
                    movE.sleep(20);
                    
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
    
    private JPanel spacep = new JPanel(){
    public void paintComponent(Graphics g){
        g.drawImage(spaceship.getImage(),spaceship.getXpos(),spaceship.getYpos(),110,110,this);
        
    }
    };  
    
    private JPanel enemyp = new JPanel(){
    public void paintComponent(Graphics g){
        Enemy temp = basic.getHead();
        paintEne=0;
        if(temp==null){
            System.out.println("NEXT LEVEL");
        }
        while(temp !=null){
            g.drawImage(temp.getImage(),temp.getXpos()+paintEne,temp.getYpos(),100,50,this);
            if(temp.getXpos()<530 & temp.getMovX()==true){
		temp.moveR();
            }
            else if(temp.getXpos()>530 & temp.getMovY()==true) {
		for(int i=0;i<30;i+=1 ) {
                    temp.moveY();    
		}
		temp.setMovX(false);
		temp.setMovY(false);
            } 
            else if(temp.getXpos()>530 & temp.getMovX()==false) {
		temp.moveL();	
            }
            else if(temp.getXpos()<530 & temp.getMovX()==false & temp.getXpos()>9) {
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
    
    
    
}
