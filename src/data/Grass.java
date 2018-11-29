package data;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Grass extends Tile {
	
	public Grass() {
		JLabel label = new JLabel();
		label.setBounds(0, 0, Game.panelSideSize, Game.panelSideSize);
		label.setIcon(new ImageIcon("src/res/grass.png"));
		this.setLayout(null);
		this.add(label);
	}
}
