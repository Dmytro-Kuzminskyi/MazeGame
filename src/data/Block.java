package data;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Block extends Tile {
	
	public Block() {
		JLabel label = new JLabel();
		label.setBounds(0, 0, Game.panelSideSize, Game.panelSideSize);
		label.setIcon(new ImageIcon("src/res/block.png"));
		this.setLayout(null);
		this.add(label);
	}
}
