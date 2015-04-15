import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
	    
	    block = new FallingSpinningObject(new SimpleSpaceObject(blockShape, new Point (200,200), -90));
	    
	    this.addKeyListener(ship);
	    
	    
	}

	/**
	 * Draw the ship in white.
	 */

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		ship.paint(g);
		block.paint(g);
		
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