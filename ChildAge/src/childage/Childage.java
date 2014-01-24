package childage;

import br.com.etyllica.EtyllicaFrame;

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
		
		setMainApplication(new HouseApplication(w,h));
		
	}
	
}

