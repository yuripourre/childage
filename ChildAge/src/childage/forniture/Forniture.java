package childage.forniture;

import br.com.etyllica.core.Drawable;
import br.com.etyllica.core.video.Graphic;
import br.com.etyllica.layer.GeometricLayer;
import br.com.etyllica.util.SVGColor;
import childage.players.ChildagePlayer;
import childage.tiles.Floor;

public abstract class Forniture extends GeometricLayer implements Drawable, UsableItem{

	protected int coolDown = 200;

	protected int currentCoolDown = 200;

	public Forniture(int x, int y){
		super(x, y, Floor.TILE_SIZE, Floor.TILE_SIZE);
	}

	@Override
	public void draw(Graphic g) {

		g.setColor(SVGColor.ORANGE);

		g.fillRect(this);

		if(currentCoolDown!=coolDown){

			int barSize = 34;

			int offsetY = 30;

			g.setColor(SVGColor.BLACK);

			g.fillRect(x, y+offsetY, barSize+2, 5);

			g.setColor(SVGColor.GREEN);

			int partialCoolDown = ((currentCoolDown*barSize)/coolDown);
			
			g.fillRect(x+1, y+offsetY+1, partialCoolDown, 3);

		}

	}

	public void update(long now){
		
		if(currentCoolDown<coolDown){
			
			currentCoolDown++;
		}
		
	}
	
	public String use(ChildagePlayer player){
		
		if(currentCoolDown==coolDown){

			currentCoolDown = 0;
			
		}
		
		return "";

	}

}
