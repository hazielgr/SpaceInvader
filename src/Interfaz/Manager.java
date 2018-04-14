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
    private Enemy enemy = new Enemy();
    private Enemy enemy1 = new Enemy();
    private Enemy enemy2 = new Enemy();
    private Enemy enemy3 = new Enemy();
    private Enemy enemy4 = new Enemy();
    private Enemy enemy5 = new Enemy();
    private Basic basic = new Basic();
    private Spaceship spaceship;
    private GameWindow gamewindow;
   
    
    
    
    public Manager(){
        
        this.basic.addEnemy(enemy);
        this.basic.addEnemy(enemy1);
        this.basic.addEnemy(enemy2);
        this.basic.addEnemy(enemy3);
        this.basic.addEnemy(enemy4);
        this.basic.addEnemy(enemy5);
        this.spaceship = new Spaceship();
        
        gamewindow = new GameWindow(this.basic,this.spaceship);
        gamewindow.addKeyListener(spaceship);
        gamewindow.init();
    }
    
    public void showGame(){
        gamewindow.setVisible(true);
    }
}