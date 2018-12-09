package data;

public class TileManager {
	private TileFactory factory;
	
	public TileManager(String factoryType) {
		if (factoryType.equals("SPECIAL"))
			factory =  new SpecialFactory();
		else 
			factory = new DefaultFactory();
	}
	
	public Tile createTile(int id) {
		if (id == 0) return factory.createBlock();
		else return factory.createGrass();
	}
	
	public TileFactory getFactory() {
		return factory;
	}
}
