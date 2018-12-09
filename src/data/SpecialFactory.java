package data;

public class SpecialFactory implements TileFactory{

	@Override
	public Block createBlock() {		
		return new SpecialBlock();
	}

	@Override
	public Grass createGrass() {
		return new SpecialGrass();
	}
}
