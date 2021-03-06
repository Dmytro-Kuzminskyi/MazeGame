package data;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Game extends JFrame{
	public static int rows = 20;
	public static int columns = 20;
	public static int panelSideSize = 25;
	public static int map[][] = new int[rows][columns];
	private TileManager tileManager;
	private Tile tile;
	private Player player;
	private Finish finish;
	
	public Game(String path) {
		player = new Player();
		this.add(player);
		this.setSize(columns*panelSideSize + 6, rows*panelSideSize + 29);
		this.setTitle(getClass().getSimpleName());
		this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);   
        loadMap(path);
        drawMap();
        this.addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				
				if(key == KeyEvent.VK_W || key == KeyEvent.VK_UP){
					player.moveUp();
				}
				if(key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT){
					player.moveLeft();
				}
				if(key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN){
					player.moveDown();
				}
				if(key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT){
					player.moveRight();
				}
				
				if(player.getPositionX() == finish.getPositionX() && player.getPositionY() == finish.getPositionY()){
					JOptionPane.showMessageDialog(null, "Congratulations, you've beaten the level!", "End Game", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}
				repaint();
			}

			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyReleased(KeyEvent e) {}

        });
        this.setVisible(true);
	}
	
	private void loadMap(String path) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(path));
			StringBuilder sb = new StringBuilder();
			tileManager = new TileManager(br.readLine());
			String line = br.readLine();
			while(line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			String mapStr = sb.toString();
			int counter = 0;
			for (int y = 0; y < rows; y++) {
				for (int x = 0; x < columns; x++) {
					String mapChar = mapStr.substring(counter, counter + 1);
					if(!mapChar.equals("\r\n") && !mapChar.equals("\n")&& !mapChar.equals("\r")) {
						map[x][y] = Integer.parseInt(mapChar);
					} else {
						x--;
					}
					counter++;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Unable to load map");
		} catch (IOException e) {
			System.out.println("IOErrors");
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private void drawMap() {
		tile = null;
		for (int y = 0; y < rows; y++) {
			for (int x = 0; x < columns; x++) {
				tile = tileManager.createTile(map[x][y]);
				tile.setPositionX(x);
				tile.setPositionY(y);
				tile.setSize(panelSideSize, panelSideSize);
				tile.setLocation(x*panelSideSize, y*panelSideSize);
				tile.setVisible(true);
				this.add(tile);
				if (map[x][y] == 2) {
					player.setPositionX(x);
					player.setPositionY(y);
					player.setInitialTexture(tileManager);
					player.setSize(panelSideSize, panelSideSize);
					player.setLocation(x*panelSideSize, y*panelSideSize);
					player.setVisible(true);
				}
				if (map[x][y] == 3) {
					finish = new Finish();
					finish.setPositionX(x);
					finish.setPositionY(y);
				}
			}
		}
		repaint();
	}
}