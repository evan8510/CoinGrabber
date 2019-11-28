package game;

import java.awt.Color;
import java.awt.Graphics;

public class HUD{
	public static double HEALTH = 400;
	public static int SCORE = 0;
	
	public void render(Graphics g){
		g.setColor(Color.green);
		g.fillRect(40, 520, (int)HEALTH, 40);
		g.drawString("Score: " + SCORE, 40, 570);
		//g.setColor(Color.white);
		//g.drawRect(20, 40, 430, 400);
	}
	
	public void tick(){
		HEALTH-= 0.3;
		if(HEALTH<=0){
			System.out.println("You lost with a score of " + SCORE);
			System.exit(0);
		}
	}
}
