package Game;

import java.awt.*;


public class Enemy {
	private boolean movX = true;
        private boolean movY = true;
	private int life;
	private Image enemy;
	private int x_pos;
	private int y_pos;
	private int speed;
        private Enemy next;
        
        
	
	public Enemy(){
            this.x_pos=150;
            this.y_pos=150;
            this.next=null;
            this.enemy =  Toolkit.getDefaultToolkit().getImage("Resources/enemy.png");
            this.speed = 9;
	}
	
	public int getXpos() {
            return this.x_pos;
	}
        
	public int getYpos() {
            return this.y_pos;
	}
	public void setSpeed(int speed) {
            this.speed =speed;
	}
	
	public int getLife() {
            return this.life;
	}
	
	public Image getImage(){
            return this.enemy;
	}
	
	public void moveR() {
            this.x_pos+=this.speed;
	}
	public void moveL() {
            this.x_pos-=this.speed;
	}
	public void moveY() {
            this.y_pos+=1;
	}
        public Enemy getNext(){
            return this.next;
        }
      public void setNext(Enemy e){
            this.next=e;
        }
      
      public void setMovX(boolean movimiento) {
		this.movX = movimiento;
	}
	
	public boolean getMovX() {
		return this.movX;
	}
	public void setMovY(boolean movimiento) {
		this.movY = movimiento;
	}
	
	public boolean getMovY() {
		return this.movY;
	}
      
}

