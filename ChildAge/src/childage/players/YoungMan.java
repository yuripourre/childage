package childage.players;

import childage.Dialog;
import br.com.etyllica.core.video.Graphic;
import br.com.etyllica.util.SVGColor;

public class YoungMan extends ChildagePlayer{

	public YoungMan(int x, int y) {
		super(x, y);
		
		age = 5;
		
		dialog = new Dialog(420, 480, 20);
		
		dialog.getText().setText("I am a young man");
		
	}
	
	@Override
	public void draw(Graphic g){
		
		g.setColor(SVGColor.WOOD_BROWN);
		
		g.fillRect(this);
		
		g.setColor(SVGColor.BLACK);
		
		g.drawRect(this);
		
		dialog.draw(g);
		
	}
	
}
