package gameView;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class GameViewStarted extends JPanel implements Runnable {
	Thread gameThread;
	protected boolean running;
	
	
	/**
	 * 
	 * Creates the game canvas. The canvas is a labeled window of the given
	 * dimensions.
	 * 
	 * @param name
	 *            String used to label the game window
	 * @param inWidth
	 *            Width of the game canvas
	 * @param inHeight
	 *            Height of the game canvas
	 */
	
	public GameViewStarted(String name, int inWidth, int inHeight) {
		JFrame frame = new JFrame(name);
		frame.setSize(inWidth, inHeight);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(this);
		
		frame.setVisible(true);
		frame.setResizable(false);

		running = true;		
		gameThread = new Thread(this);
	}
	
	/**
	 * Starts the 'animation' loop of the game
	 */
	
	public void startGame() {
		gameThread.start();
	}
	
	/**
	 * Specifies the basic action of the game animation
	 */
	
	@Override
	public void run() {
		while (running) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				System.err.println("Game interrupted.");
			}
			repaint();
		}

	}

}

