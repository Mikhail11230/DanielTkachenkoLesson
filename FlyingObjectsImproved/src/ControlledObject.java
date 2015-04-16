import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

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
    /**
     * Collisions - work on one object
     */
	@Override
	public void collide(SpaceObject obj) {
			Point offset = ((SimpleSpaceObject) obj).shape.getOffset();
			boolean collide = ((SimpleSpaceObject) spaceObject).shape.contains(offset);

			if (collide == true) {
				System.err.println("Collide !!!");
				
			}
			
		}
	/**
     * Collisions - work on one object, however, do not work for arraylist of objects
     * can't figure out what the error is for now. 
     */
	/*
	public boolean isColliding(ArrayList<SpaceObject> blockList, SpaceObject object) {
		
		for(SpaceObject spaceObject : blockList){
			Point offset = ((SimpleSpaceObject) object).shape.getOffset();
			boolean collide = ((SimpleSpaceObject) spaceObject).shape.contains(offset);
			
			if (collide == true) {
				System.err.println("Collide !!!");
				return true;
			}
			return false;
		}
		
	return false;
	}
   */

	@Override
	public void keyPressed(KeyEvent e) {
        
		 if (e.getKeyCode() == KeyEvent.VK_LEFT)
		      spaceObject.move(-15, 0);
		    if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		    	spaceObject.move(15, 0);
		    if (e.getKeyCode() == KeyEvent.VK_UP)
	            spaceObject.move(0, -15);
		    if (e.getKeyCode() == KeyEvent.VK_DOWN)
		        spaceObject.move(0, 15);
 
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