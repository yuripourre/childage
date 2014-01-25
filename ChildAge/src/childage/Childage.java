package childage;

import br.com.etyllica.EtyllicaFrame;
import br.com.etyllica.core.loader.JoystickLoader;

public class Childage extends EtyllicaFrame {
	
	public Childage(){
		super(800,600);
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

