package childage.players;

import br.com.etyllica.core.video.Graphic;
import br.com.etyllica.util.SVGColor;

public class OldMan extends ChildagePlayer{

	public OldMan(int x, int y) {
		super(x, y);
	}
	
	@Override
	public void draw(Graphic g){
		
		g.setColor(SVGColor.AQUA);
		
		g.fillRect(this);
		
		g.setColor(SVGColor.BLACK);
		
		g.drawRect(this);
		
	}
	
}
