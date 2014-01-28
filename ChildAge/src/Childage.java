

import sound.MultimediaLoader;
import br.com.etyllica.EtyllicaFrame;
import br.com.etyllica.context.Application;
import childage.HouseApplication;
import childage.menu.MainMenu;

public class Childage extends EtyllicaFrame {
	
	public Childage(){
		super(1280,720);
	}
	
	public static void main(String[] args) {
		Childage c = new Childage();
		c.init();
	}

	@Override
	public Application startApplication() {
		
		addLoader(MultimediaLoader.getInstance());
		
		//addLoader(JoystickLoader.getInstance());
		
		//JoystickLoader.getInstance().start();
		
		//return new HouseApplication(w,h);
		return new MainMenu(w,h);
		
	}
	
}

