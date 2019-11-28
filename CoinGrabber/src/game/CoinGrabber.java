package game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

public class CoinGrabber extends Canvas implements Runnable{ // making it a component & implementing runnable
	
	private static final long serialVersionUID = -2035519044879265651L;
	
	private ItemManager manager; // what will be used to store & access the GameItems
	private HUD hud;
	private Thread thread; // thread
	private boolean running = false; // boolean value to indicate if and when the game is running
	public static void main(String[] args) {
		new CoinGrabber();
		
	}
	
	private void render(){ // render method calls all the render methods throughout
		BufferStrategy bs = this.getBufferStrategy(); // used to make it better
		if(bs==null){
			this.createBufferStrategy(2); // in the event that there isn't one in place create one
			return; // after making it leave the render() method
		}
		Graphics g = bs.getDrawGraphics(); // declaring the Graphics variable to draw all that must be drawn
		g.setColor(Color.black);
		g.fillRect(0, 0, GUI.WIDTH, GUI.HEIGHT); // giving a black background
		
		manager.render(g); // drawing out all the GameItems
		hud.render(g);
		g.dispose();
		bs.show();
	}
	
	private void tick(){
		manager.tick(); // runs the tick() method of all of the GameItems
		hud.tick();
	}

	public CoinGrabber(){
		new GUI(480,"Coin Grabber", this); // builds the window
		manager = new ItemManager(); // instantiates the manager
		hud = new HUD();
		this.addKeyListener(new KeyInput(manager)); // attaches a key listener for input. Uses the KeyInput class to process input
		manager.addItem(new Player(manager)); // adding in the player
		manager.addItem(new Coin(200, 200, manager));
		manager.addItem(new Wall(20, 40, 430, 5, manager, 'w'));
		manager.addItem(new Wall(20, 440, 430, 5, manager, 'a'));
		manager.addItem(new Wall(20, 40, 5, 400, manager, 's'));
		manager.addItem(new Wall(450, 40, 5, 402, manager, 'd'));
		run();
	}
	
	public synchronized	void start(){
		thread = new Thread(this);
		thread.start(); // these 3 lines are run by GUI to signal that the game has begun
		running = true;
	}
	
	@Override
	public void run() {
		this.requestFocus();
		double timePassed= 0; // starts at 0
		double last = System.nanoTime(); // starts at the current time that the system is at
		double now;
		while(running){
			if(running)render();
			now = System.nanoTime(); // set to the current time
			timePassed = now-last; // the timePassed is equal to the current time - the time started
			if(timePassed>5){
				tick(); 
				last = now; // sets the last to now
			}
		}
	}

}
