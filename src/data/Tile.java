package data;

import javax.swing.JPanel;

public abstract class Tile extends JPanel{
	protected int x;
	protected int y;
	
	public void setPositionX(int x) {
		this.x = x;
	}
	
	public int getPositionX() {
		return x;
	}

	public void setPositionY(int y) {
		this.y = y;
	}
	
	public int getPositionY() {
		return y;
	}
}
