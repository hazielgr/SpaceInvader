package Game;

import Interfaz.GameWindow;

public class Basic extends Enemy{
	private Enemy head;
	private int size;

        
	public Basic() {
		this.head = null;
		this.size = 0;
                
	}
	
       
	public boolean empty() {
		return this.size == 0;
	}

	public void addEnemy(Enemy enemy) {
		if(this.head == null) {
                    this.head = enemy;
                    this.size++;
		}
		else {
                    Enemy temp = this.head;
                    while(temp.getNext()!=null){
                        temp=temp.getNext();
                    }
                    temp.setNext(enemy);
                    this.size++;
		}
	}
	
        public Enemy getEnemy(int index) {
		int contador=0;
		Enemy temp = this.head;
		while(contador<index) {
			temp = temp.getNext();
			contador+=1;
		}
		return temp;
	}
        
        public Enemy getHead(){
            return this.head;
        }
        
        public void DeleteEn(){
            if (this.size==0){
                System.out.println("lista vacia");
            }
            else{
                Enemy temp=this.head;
                this.head=temp.getNext();
                size--;
            }
        }
        
        public void DeleteEne(int indice){
            int cont=0;
            GameWindow.temp2 = this.getEnemy(indice);
            if(this.size==0){
                System.out.println("lista vacia 2");
            }
            else{
                Enemy temp=this.head;
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
        
        
}
