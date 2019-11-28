package game;

import java.awt.Color;
import java.awt.Graphics;

public class Wall extends GameItem {

	private char dir;
	public Wall(double xPos, double yPos, int w, int h, ItemManager man, char di) {
		super(xPos, yPos, w, h, Color.white, man);
		dir = di;
	}
	
	public void render(Graphics g){
		g.setColor(c);
		g.fillRect((int)x, (int)y, width, height);
	}
	
	public void tick(){
		
	}
	
	
}
