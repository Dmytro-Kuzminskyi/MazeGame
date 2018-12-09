package data;

import javax.swing.JLabel;

public class Grass extends Tile {
	
	public Grass() {
		label = new JLabel();
		label.setBounds(0, 0, Game.panelSideSize, Game.panelSideSize);
		this.setLayout(null);
		this.add(label);
	}
}
