package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

// General Abstract Class that is going to be the base of all game objects from player to menu items
public class GameItem {
	
	protected double x, y; //Location of the object
	protected Color c;
	protected int width, height;
	protected ItemManager manager;
	public GameItem(double xPos, double yPos, int w, int h, Color col, ItemManager man){
		x = xPos;
		y = yPos;
		width = w;
		height = h;
		c = col;
		manager = man;
	}
	
	public void tick(){
		// Code that must be run relating to the object logic-wise
		
	}
	public void render(Graphics g){
		// Code that must be run relating to the object graphics-wise
		g.setColor(c);
		g.fillOval((int)x, (int)y, width, height);
	}
	
	public void setX(double xPos){ //setting X Location
		x = xPos;
	}
	public void setY(double yPos){ //setting Y Location
		y = yPos;
	}
	public void move(double xPos, double yPos){ //setting Location
		setX(xPos);
		setY(yPos);
	}
	public double getX(){ //returning X Location
		return x;
	}
	public double getY(){ //returning Y Location
		return y;
	}
	
	final Rectangle getBounds(){ // method to return the Rectangle the GameItem fits into
		Rectangle temp = new Rectangle((int)x,(int)y, width, height);
		return temp;
	}
}
