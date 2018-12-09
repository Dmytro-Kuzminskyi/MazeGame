package data;

import javax.swing.JLabel;

public class Block extends Tile{
	
	public Block() {
		label = new JLabel();
		label.setBounds(0, 0, Game.panelSideSize, Game.panelSideSize);
		this.setLayout(null);
		this.add(label);
	}
}
