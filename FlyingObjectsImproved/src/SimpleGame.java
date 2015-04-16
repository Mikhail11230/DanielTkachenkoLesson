import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;

/**
 * A very simple example of how to use the Game base class.
 * 
 * Here, we provide a constructor for our game, override the JPanel
 * paintComponent() method, and write a simple main() method that creates and
 * starts the game.
 * 
 * @author sdexter72
 *
 */
public class SimpleGame extends Game implements KeyListener{

	/**
	 * The lone 'object' in our simple game.
	 * Adding Another object that will simulate FallingSpinningAsteroid
	 * And Ship that is being controlled by Keyboard input
	 */
	ArrayList<FallingSpinningObject> blockList;
	FallingSpinningObject block;
	ControlledObject ship;
	/**
	 * This constructor invokes the super constructor, then creates a ship
	 * object (which doesn't do very much)
	 * 
	 * @param name
	 * @param inWidth
	 * @param inHeight
	 */
	public SimpleGame(String name, int inWidth, int inHeight) {
       
		super(name, inWidth, inHeight);
		blockList = new ArrayList();
		setBackground(Color.BLACK);
		setFocusable(true);
		Point[] shipShape = { new Point(210, 100), new Point(190, 90),
				new Point(200, 100), new Point(190, 110) };

		//ship = new ControlledObject(new SimpleSpaceObject(shipShape, new Point(200, 200), -90));
		
		Point[] blockShape = { new Point(200, 100), new Point(200, 100),
				new Point(200, 150), new Point(150, 150), new Point(150, 100) };
		
		Point[] flyingShape = { new Point(210, 100), new Point(190, 90),
				new Point(200, 100), new Point(190, 110) };
		
		//block = new FallingSpinningObject(new SimpleSpaceObject(blockShape, new Point(200,200), -90));
	    ship = new ControlledObject(new SimpleSpaceObject(flyingShape, new Point (200,200), -90));
	    this.addKeyListener(ship);
	    //block = new FallingSpinningObject(new SimpleSpaceObject(blockShape, new Point(Math.random() * 400, Math.random() * 400), -90));
	    // generating 5 asteroids at random location;
	    Random rad = new Random();
		for (int i = 0; i < 5; i++) {
			FallingSpinningObject block = new FallingSpinningObject(
					new SimpleSpaceObject(blockShape, new Point(rad.nextInt(350 - 50) + 50, 200), -90));
			blockList.add(block);
		}
	}
	

	/**
	 * Draw the ship in white.
	 */

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		ship.paint(g);
		
		//Creating list of blocks 
		for (FallingSpinningObject block : blockList) {
			block.paint(g);
		}
		//creating collisions with every block
		for (FallingSpinningObject block : blockList) {
			ship.collide(block.fallSpinObject);
		}
		//updating health from collisions of every block
		for (FallingSpinningObject block : blockList) {
			ship.getHealth(block.fallSpinObject);
		}
		//checking if ship is dead after collision with every block
		for (FallingSpinningObject block : blockList){
			ship.isDead(block.fallSpinObject);
		}
		
	}


	/**
	 * In main, we create a new SimpleGame, make sure it has the keyboard focus
	 * (which it will need when we implement code to control game action with
	 * keyboard), and start the game.
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		SimpleGame game = new SimpleGame("Simple Game", 400, 900);
		game.requestFocus();
		game.startGame();
			
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}