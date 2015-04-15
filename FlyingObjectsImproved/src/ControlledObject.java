import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

 /** @author Mikhail
 *Controlled Object class is going to be a ship 
 *User will be able to control ship
 *Movement allowed will be strictly up / down
 *Left right
 *Keyboard is hooked into that class
 **/
public class ControlledObject implements SpaceObject, KeyListener{
	KeyListener keyboard;
	SpaceObject spaceObject;
	public ControlledObject(SpaceObject spaceObject){
	this.spaceObject = spaceObject;
    
	}
	
	@Override
	public void move(int x, int y) {
	
		spaceObject.move(x,y);
		
	}

	

	@Override
	public void rotate(double r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		spaceObject.paint(g);
	    
		
	}

	@Override
	public void collide(SpaceObject obj) {
	
	}

	@Override
	public void keyPressed(KeyEvent e) {
        
		 if (e.getKeyCode() == KeyEvent.VK_LEFT)
		      spaceObject.move(-8, 0);
		    if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		    	spaceObject.move(8, 0);
		    if (e.getKeyCode() == KeyEvent.VK_UP)
	            spaceObject.move(0, -8);
		    if (e.getKeyCode() == KeyEvent.VK_DOWN)
		        spaceObject.move(0, 8);
 
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}