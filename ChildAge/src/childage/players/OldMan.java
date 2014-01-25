package childage.players;

import childage.Dialog;
import br.com.etyllica.core.video.Graphic;
import br.com.etyllica.util.SVGColor;

public class OldMan extends ChildagePlayer{

	public OldMan(int x, int y) {
		super(x, y);
		
		age = 89;
		
		dialog = new Dialog(20, 480, 28);
		
		dialog.getText().setText("I am an old man");
		
	}
	
	@Override
	public void draw(Graphic g){
		
		g.setColor(SVGColor.AQUA);
		
		g.fillRect(this);
		
		g.setColor(SVGColor.BLACK);
		
		g.drawRect(this);
		
		dialog.draw(g);
		
	}
	
}
