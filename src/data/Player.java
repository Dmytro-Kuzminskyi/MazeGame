package data;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends Tile{
	private int step;
	private TileManager tileManager;
	
	public Player() {
		step = Game.panelSideSize;
		label = new JLabel();
		label.setBounds(0, 0, Game.panelSideSize, Game.panelSideSize);
		this.setLayout(null);
		this.add(label);
	}
	
	public void moveLeft() {
		setLookLeft(tileManager.getFactory());
		if (x > 0 && Game.map[x - 1][y] != 0) {
			this.setLocation(this.getX() - step, this.getY());
			x--;
		}
	}
	
	public void moveRight() {
		setLookRight(tileManager.getFactory());
		if (x < Game.columns - 1 && Game.map[x + 1][y] != 0) {
	    	this.setLocation(this.getX() + step, this.getY());
	    	x++;
    	}
	}
	
	public void moveUp() {
		setLookUp(tileManager.getFactory());
		if(y > 0 && Game.map[x][y - 1] != 0){
	    	this.setLocation(this.getX(), this.getY() - step);
	    	y--;
    	}
	}
	
	public void moveDown() {
		setLookDown(tileManager.getFactory());
		if(y < Game.rows-1 && Game.map[x][y + 1] != 0){
	    	this.setLocation(this.getX(), this.getY() + step);
	    	y++;
    	}
	}

	public void setInitialTexture(TileManager tileManager) {
		this.tileManager = tileManager;
		if (x == 0) setLookRight(tileManager.getFactory());
		if (x == Game.columns - 1) setLookLeft(tileManager.getFactory());
		if (y == 0) setLookDown(tileManager.getFactory());
		if (y == Game.rows - 1) setLookUp(tileManager.getFactory());
	}
	
	private void setLookRight(TileFactory factory) {
		if (factory.getClass() == SpecialFactory.class) 
			label.setIcon(new ImageIcon("src/res/playerLookRightSpecial.png"));
		else 
			label.setIcon(new ImageIcon("src/res/playerLookRight.png"));
	}
	
	private void setLookLeft(TileFactory factory) {
		if (factory.getClass() == SpecialFactory.class)
			label.setIcon(new ImageIcon("src/res/playerLookLeftSpecial.png"));
		else
			label.setIcon(new ImageIcon("src/res/playerLookLeft.png"));
	}
	
	private void setLookUp(TileFactory factory) {
		if (factory.getClass() == SpecialFactory.class)
			label.setIcon(new ImageIcon("src/res/playerLookUpSpecial.png"));
		else
			label.setIcon(new ImageIcon("src/res/playerLookUp.png"));
	}
	
	private void setLookDown(TileFactory factory) {
		if (factory.getClass() == SpecialFactory.class)
			label.setIcon(new ImageIcon("src/res/playerLookDownSpecial.png"));
		else
			label.setIcon(new ImageIcon("src/res/playerLookDown.png"));
	}
}
