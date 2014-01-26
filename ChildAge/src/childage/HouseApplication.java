package childage;
import br.com.etyllica.context.Application;
import br.com.etyllica.core.event.GUIEvent;
import br.com.etyllica.core.event.KeyEvent;
import br.com.etyllica.core.event.PointerEvent;
import br.com.etyllica.core.video.Graphic;
import br.com.etyllica.layer.ImageLayer;
import br.com.tide.input.controller.EasyController;
import br.com.tide.input.controller.FirstPlayerController;
import childage.map.Map;
import childage.players.OldMan;
import childage.players.YoungMan;


public class HouseApplication extends Application{

	private Map map;
	
	private OldMan oldMan;
	
	private YoungMan youngMan;
	
	private ImageLayer house;

	public HouseApplication(int w, int h) {
		super(w, h);
	}

	@Override
	public void load() {

		map = new Map();
		
		oldMan = new OldMan(30,80);
		oldMan.setController(new EasyController());
		
		youngMan = new YoungMan(530,80);
		youngMan.setController(new FirstPlayerController());
		
		house = new ImageLayer("house.png");
		
		map.addPlayer(oldMan);
		
		map.addPlayer(youngMan);

		updateAtFixedRate(50);
		
		loading = 100;
		
	}
	
	public void timeUpdate(long now){
		
		oldMan.update(now, map);
		
		youngMan.update(now, map);
		
		map.update(now);
		
	}

	@Override
	public void draw(Graphic g) {
		//g.setColor(Color.BLUE);
		//g.fillRect(0,0,w,h);
		house.draw(g);
		
		map.draw(g);
		
		drawPlayers(g);
	}
	
	private void drawPlayers(Graphic g){
		
		oldMan.draw(g);
		
		youngMan.draw(g);
		
	}

	@Override
	public GUIEvent updateMouse(PointerEvent event) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GUIEvent updateKeyboard(KeyEvent event) {
		
		oldMan.handleEvent(event);
		
		youngMan.handleEvent(event);
		
		// TODO Auto-generated method stub
		return null;
	}		

}
