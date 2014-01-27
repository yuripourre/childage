package childage;

import childage.tiles.Floor;
import br.com.etyllica.core.Drawable;
import br.com.etyllica.core.video.Graphic;
import br.com.etyllica.gui.Panel;
import br.com.etyllica.layer.ImageLayer;
import br.com.etyllica.layer.TextLayer;

public class Dialog implements Drawable{

	private ImageLayer face;
	
	private ImageLayer carryContainer;
	
	private ImageLayer carryItem = null;
	
	private Panel panel;
	
	private TextLayer text;
	
	public Dialog(int x, int y, float fontSize, String path){
		super();
		
		panel = new Panel(x, y, 480, 100);
		panel.setRoundness(10);
		
		text = new TextLayer(panel.getX()+180, panel.getY()+40, "dialog");
		
		text.setSize(fontSize);
		
		face = new ImageLayer(panel.getX()+12,panel.getY()+12, path);
		face.setW(Floor.TILE_SIZE);
		face.setH(Floor.TILE_SIZE);
		
		carryContainer = new ImageLayer(panel.getX()+86, panel.getY()+8, "carry_container.png");
		
		carryItem = new ImageLayer(carryContainer.getX()+3, carryContainer.getY()+3);
		
	}
	
	public void show(){
		panel.setVisible(true);
		text.setVisible(true);
	}
	
	public void hide(){
		panel.setVisible(false);
		text.setVisible(false);
	}
	
	public void draw(Graphic g){
		panel.draw(g);
		text.draw(g);
		
		face.draw(g);
		carryItem.draw(g);
		carryContainer.draw(g);
	}

	public void changeCarryItem(String path) {
		carryItem = new ImageLayer(carryContainer.getX()+3, carryContainer.getY()+3, path);
		carryItem.setVisible(true);
	}
	
	public void hideCarryItem() {
		carryItem.setVisible(false);
	}

	public TextLayer getText() {
		return text;
	}
	
}
