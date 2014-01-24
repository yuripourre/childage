package childage;
import java.awt.Color;

import br.com.etyllica.context.Application;
import br.com.etyllica.core.event.GUIEvent;
import br.com.etyllica.core.event.KeyEvent;
import br.com.etyllica.core.event.PointerEvent;
import br.com.etyllica.core.video.Graphic;


public class HouseApplication extends Application{

	public HouseApplication(int w, int h) {
		super(w, h);
	}

	@Override
	public GUIEvent updateMouse(PointerEvent event) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GUIEvent updateKeyboard(KeyEvent event) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub
		loading = 100;
	}

	@Override
	public void draw(Graphic g) {
		g.setColor(Color.BLUE);
		g.fillRect(0,0,w,h);
		
	}
		
	
}
