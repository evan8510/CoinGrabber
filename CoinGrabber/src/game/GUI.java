package game;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


// The window the game will be in
public class GUI extends Canvas {
	
	private static final long serialVersionUID = -6619849589168700887L;
	
	public static int HEIGHT, WIDTH;
	
	// Constructor for the game's window that features it's height, width, and what it'll say at the top
	public GUI(int width, String title, CoinGrabber cg){
		WIDTH = width;
		HEIGHT = width*12/9;
		JFrame frame = new JFrame(title); // Creates the window and gives it the title
		
		frame.setPreferredSize(new Dimension(WIDTH, HEIGHT)); // sets the size of the window
		frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		frame.setMaximumSize(new Dimension(WIDTH,HEIGHT));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // "X" button closes
		frame.setResizable(false); // Can't change the size of the window
		frame.setLocationRelativeTo(null); // Makes it start in the middle
		
		frame.add(cg); // putting the game into the frame
		frame.setVisible(true); // You can now see the window
		cg.start(); // starting the game
	}
	
}
