package game;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;

public class ItemManager {
	
	LinkedList<GameItem> items = new LinkedList<GameItem>(); // Storing all of the items in the game
	
	public void addItem(GameItem temp){ // adds a GameItem to the LinkedList
		items.add(temp);
	}
	
	public void removeItem(GameItem temp){ // removes a GameItem from the LinkedList
		items.remove(temp);
	}
	
	public void tick(){ // Runs the tick() method of all the items in the LinkedList
		for(int i = 0; i<items.size(); i++){
			GameItem temp = items.get(i);
			temp.tick();
		}
	}
	
	public void render(Graphics g){ // Runs the render() method of all the items in the LinkedList
		for(int i = 0; i<items.size(); i++){
			GameItem temp = items.get(i);
			temp.render(g);
		}
	}
}
