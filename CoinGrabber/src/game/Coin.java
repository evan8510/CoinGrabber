package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Coin extends GameItem{

	public Coin(double xPos, double yPos, ItemManager man) {
		super(xPos, yPos, 15, 15, Color.YELLOW, man);
	}
	public void tick(){
		collision(); //checks to see if the coin is touching the player
		super.tick();
	}
	public void render(Graphics g){
		g.setColor(c);
		g.fillOval((int)x, (int)y, width, height);
	}
	public void relocate(){ // sends the coin to a random location
		move(Math.random()*415+20, Math.random()*385+40);
	}
	private void collision(){ // checks if the coin is touching the player
		if(this.getBounds().intersects(manager.items.get(0).getBounds())){
			relocate();
			HUD.SCORE += HUD.HEALTH;
			HUD.HEALTH = 400;
		}
	}
	
	
}
