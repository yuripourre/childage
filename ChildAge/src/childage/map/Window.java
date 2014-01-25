package childage.map;

import java.awt.Color;

import br.com.etyllica.core.Drawable;
import br.com.etyllica.core.video.Graphic;
import br.com.etyllica.layer.GeometricLayer;

public class Window extends GeometricLayer implements Drawable{

	public Window(int x, int y, int w, int h){
		super(x, y, w, h);
	}
	
	public void draw(Graphic g){
		
		g.setColor(Color.GREEN);
		
		g.fillRect(this);
		
	}
	
}
