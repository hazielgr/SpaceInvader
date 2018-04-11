/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;
import Game.Basic;
import Game.Enemy;
import Game.Spaceship;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Manager {
    private Spaceship spaceship;
    private GameWindow gamewindow;
   
    public Manager(){
        this.spaceship = new Spaceship();
        
        gamewindow = new GameWindow(spaceship);
        gamewindow.addKeyListener(spaceship);
        gamewindow.init();
    }
    
    public void showGame(){
        gamewindow.setVisible(true);
    }
   
}