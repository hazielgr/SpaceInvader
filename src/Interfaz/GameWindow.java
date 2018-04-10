/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Game.Basic;
import Game.Spaceship;
import java.awt.Color;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author mario
 */
public class GameWindow extends JFrame {
    private ImageIcon imageBackground;
    private Spaceship spaceship;

    private Container contenedor;

    
    public GameWindow(Spaceship spaceship){
        this.spaceship = spaceship;
        this.imageBackground = new ImageIcon("Resources/background.jpg");

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

        
    }
    
}
