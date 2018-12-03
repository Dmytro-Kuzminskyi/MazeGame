package data;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends Tile{
	private int step;
	private JLabel label;
	
	public Player() {
		step = Game.panelSideSize;
		this.setSize(step, step);
		label = new JLabel();
		label.setBounds(0, 0, Game.panelSideSize, Game.panelSideSize);
		this.setLayout(null);
		this.add(label);
	}
	
	public void moveLeft() {
		setLookLeft();
		if (x > 0 && Game.map[x - 1][y] != 0) {
			this.setLocation(this.getX() - step, this.getY());
			x--;
		}
	}
	
	public void moveRight() {
		setLookRight();
		if (x < Game.columns - 1 && Game.map[x + 1][y] != 0) {
	    	this.setLocation(this.getX() + step, this.getY());
	    	x++;
    	}
	}
	
	public void moveUp() {
		setLookUp();
		if(y > 0 && Game.map[x][y - 1] != 0){
	    	this.setLocation(this.getX(), this.getY() - step);
	    	y--;
    	}
	}
	
	public void moveDown() {
		setLookDown();
		if(y < Game.rows-1 && Game.map[x][y + 1] != 0){
	    	this.setLocation(this.getX(), this.getY() + step);
	    	y++;
    	}
	}

	public void setInitialTexture() {
		if (x == 0) setLookRight();
		if (x == Game.columns - 1) setLookLeft();
		if (y == 0) setLookDown();
		if (y == Game.rows - 1) setLookUp();
	}
	
	private void setLookRight() {
		label.setIcon(new ImageIcon("src/res/playerLookRight.png"));
	}
	
	private void setLookLeft() {
		label.setIcon(new ImageIcon("src/res/playerLookLeft.png"));
	}
	
	private void setLookUp() {
		label.setIcon(new ImageIcon("src/res/playerLookUp.png"));
	}
	
	private void setLookDown() {
		label.setIcon(new ImageIcon("src/res/playerLookDown.png"));
	}
}
