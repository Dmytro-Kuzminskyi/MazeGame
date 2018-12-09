package data;

public class DefaultFactory implements TileFactory{
	
	@Override
	public Block createBlock() {		
		return new DefaultBlock();
	}

	@Override
	public Grass createGrass() {
		return new DefaultGrass();
	}
}
