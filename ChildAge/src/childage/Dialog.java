package childage;

import br.com.etyllica.core.Drawable;
import br.com.etyllica.core.video.Graphic;
import br.com.etyllica.gui.Panel;
import br.com.etyllica.layer.TextLayer;

public class Dialog implements Drawable{

	private Panel panel;
	
	private TextLayer text;
	
	public Dialog(int x, int y, float fontSize){
		super();
		
		panel = new Panel(x, y, 360, 100);
		
		text = new TextLayer(panel.getX()+40, panel.getY()+30, "dialog");
		
		text.setSize(fontSize);
		
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
	}

	public TextLayer getText() {
		return text;
	}
	
}
