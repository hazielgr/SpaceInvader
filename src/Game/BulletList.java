/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Interfaz.GameWindow;

public class BulletList {
    private Bullet head;
    private int size;
    
    public BulletList(){
        this.head = null;
        this.size = 0;
    }
    
    public boolean empty(){
        return this.size==0;
    }
    public void addBullet(Bullet bullet) {
        if(this.head == null) {
            this.head = bullet;
            this.size++;
        }
        else {
            Bullet temp = this.head;
            while(temp.getNext()!=null){
                temp=temp.getNext();
            }
            temp.setNext(bullet);
            this.size++;
        }
    }
    
    public Bullet getBullet(int index) {
        int contador=0;
        Bullet temp = this.head;
        while(contador<index) {
            temp = temp.getNext();
            contador+=1;
        }
        return temp;
    } 
    
    
    
    public void DeleteBull(int indice){
        int cont=0;
        if(this.size==0){
            System.out.println("lista vacia 2");
        }
        else{
            Bullet temp=this.head;
            if(this.head.getNext()==null){
                this.head=null;
            }
            while(cont<indice-1){
                temp=temp.getNext();
                cont++;
            }
            if(temp.getNext()==null){
                this.head=null;
            }
            else{
                temp.setNext(temp.getNext().getNext());
            }
            size--;
        }
        
    }
    
    public Bullet getHead(){
        return this.head;
    }
}
