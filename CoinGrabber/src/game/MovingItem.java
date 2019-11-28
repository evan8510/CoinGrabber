package game;

import java.awt.Color;
import java.awt.Graphics;

//Base class for all items that will move: Players, Enemies, etc.
public class MovingItem extends GameItem{

	
	protected double xVel, yVel; // Values associated with the direction the
								 //object will move and how fast it will move
	
	
	//Constructor that makes the default moving-item
	public MovingItem(double xPos, double yPos, int w, int h, Color col, double xSpeed, double ySpeed, ItemManager man) {
		super(xPos, yPos, w, h, col, man);
		xVel = xSpeed;
		yVel = ySpeed;
	}
	
	public void setXVel(double xSpeed){ //setting X Direction and Speed
		xVel = xSpeed;
	}
	
	public void setYVel(double ySpeed){ //setting Y Direction and Speed
		yVel = ySpeed;
	}

	@Override
	public void tick() { // Essentially just saying each tick move the item by the velocities
		x+=xVel;
		y+=yVel;
	}

	@Override
	public void render(Graphics g) { // Drawing the item
		g.setColor(c);
		g.fillRect((int)x, (int)y, width, height);
	}

}
