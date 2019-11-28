package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{

	private ItemManager manager;
	public KeyInput(ItemManager man){
		manager = man;
	}
	
	public void keyPressed(KeyEvent e){
		int event = e.getKeyCode();
		if(event == KeyEvent.VK_W ){
			GameItem temp = manager.items.get(0);
			((MovingItem)temp).setYVel(-1);
		}
		if(event == KeyEvent.VK_S){
			MovingItem temp = (MovingItem) manager.items.get(0);
			temp.setYVel(1);
		}
		if(event == KeyEvent.VK_A){
			MovingItem temp = (MovingItem) manager.items.get(0);
			temp.setXVel(-1);
		}
		if(event == KeyEvent.VK_D){
			MovingItem temp = (MovingItem) manager.items.get(0);
			temp.setXVel(1);
		}
		if(event == KeyEvent.VK_ESCAPE) System.exit(0);
	}
	
	public void keyReleased(KeyEvent e){
		int event = e.getKeyCode();
		if(event == KeyEvent.VK_W ){
			GameItem temp = manager.items.get(0);
			((MovingItem)temp).setYVel(0);
		}
		if(event == KeyEvent.VK_S){
			GameItem temp = manager.items.get(0);
			((MovingItem)temp).setYVel(0);
		}
		if(event == KeyEvent.VK_A){
			GameItem temp = manager.items.get(0);
			((MovingItem)temp).setXVel(0);
		}
		if(event == KeyEvent.VK_D){
			GameItem temp = manager.items.get(0);
			((MovingItem)temp).setXVel(0);
		}
	}
}
