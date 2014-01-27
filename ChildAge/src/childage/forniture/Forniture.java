package childage.forniture;

import java.awt.Color;

import br.com.etyllica.core.Drawable;
import br.com.etyllica.core.video.Graphic;
import br.com.etyllica.layer.GeometricLayer;
import br.com.etyllica.layer.ImageLayer;
import br.com.etyllica.util.SVGColor;
import childage.players.ChildagePlayer;
import childage.tiles.Floor;

public abstract class Forniture extends GeometricLayer implements Drawable, UsableItem{

	protected int coolDown = 200;

	protected int currentCoolDown = 200;
	
	protected ImageLayer layer;
	
	protected FornitureListener listener;
	
	private GeometricLayer range;

	public Forniture(int x, int y, int w, int h){
		super(x,y,w,h);
		layer = new ImageLayer(x, y, w, h); 
	}
	
	public Forniture(int x, int y, FornitureListener listener, String path){
		super(x, y, Floor.TILE_SIZE, Floor.TILE_SIZE);
		
		range = new GeometricLayer(x-Floor.TILE_SIZE, y-Floor.TILE_SIZE, Floor.TILE_SIZE*3, Floor.TILE_SIZE*3);
		
		layer = new ImageLayer(x, y, path); 
		
		this.listener = listener; 
		
	}

	@Override
	public void draw(Graphic g) {

		layer.draw(g);
		
		//drawRange(g);

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
	
	private void drawRange(Graphic g){
		
		g.setColor(Color.GREEN);
		g.setAlpha(70);
		g.fillRect(range);
		g.setAlpha(100);
		
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

	public GeometricLayer getRange() {
		return range;
	}

	public FornitureListener getListener() {
		return listener;
	}

	public void setListener(FornitureListener listener) {
		this.listener = listener;
	}

}
