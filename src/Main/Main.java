/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Game.Spaceship;
import Interfaz.GameWindow;

/**
 *
 * @author mario
 */
public class Main {
    public static void main(String args[]){
        Spaceship nave = new Spaceship();
        GameWindow ventana = new GameWindow(nave);
        ventana.init();
        ventana.show();
    }
}
