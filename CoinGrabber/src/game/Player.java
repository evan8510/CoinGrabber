package game;

import java.awt.Color;

public class Player extends MovingItem{

	public Player(ItemManager man) {
		super(70, 70, 32, 32, Color.RED, 0, 0, man);
	}
	
	public boolean isTouching(GameItem wall){
		if(this.getBounds().intersects(wall.getBounds()))
			return true;
		return false;
	}
	
	public void tick(){
		super.tick();
		if(x>418) setX(418);
		if(x<25) setX(25);
		if(y<45) setY(45);
		if(y>408) setY(408);
	}

}
