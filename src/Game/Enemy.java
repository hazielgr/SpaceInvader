package Game;

import java.awt.*;


public class Enemy {
	
	private int life;
	private Image enemy;
	private int x_pos = 150;
	private int y_pos = 150;
	private int speed ;
        private Enemy next;
        
        
	
	public Enemy(){
            this.next=null;
            this.enemy =  Toolkit.getDefaultToolkit().getImage("Resources/enemy.png");
	}
	
	public int getXpos() {
		return this.x_pos;
	}
        
	
	public int getYpos() {
		return y_pos;
	}
	public int getSpeed() {
		return this.speed;
	}
	
	public int getLife() {
		return this.life;
	}
	
	public Image getImage(){
		return this.enemy;
	}
	
	public void moveR() {
		x_pos+=8;
	}
	public void moveL() {
		x_pos-=8;
	}
	public void moveY() {
		y_pos+=1;
	}
        public Enemy getNext(){
            return this.next;
        }
      public void setNext(Enemy e){
            this.next=e;
        }
      
      
}

