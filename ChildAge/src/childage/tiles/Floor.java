package childage.tiles;

import br.com.etyllica.layer.GeometricLayer;

public class Floor extends GeometricLayer{

	public static final int TILE_SIZE = 64;
	
	public Floor(int x, int y){
		super(x,y,TILE_SIZE,TILE_SIZE);
	}
	
}
