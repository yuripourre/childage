

import br.com.etyllica.EtyllicaFrame;
import br.com.etyllica.core.loader.JoystickLoader;
import childage.HouseApplication;

public class Childage extends EtyllicaFrame {
	
	public Childage(){
		super(1280,720);
	}
	
	public static void main(String[] args) {
		Childage c = new Childage();
		c.init();
	}

	@Override
	public void startGame() {
		
		addLoader(JoystickLoader.getInstance());
		//JoystickLoader.getInstance().start();
		
		setMainApplication(new HouseApplication(w,h));
		
	}
	
}

