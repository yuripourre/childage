package childage;
import java.awt.Color;

import br.com.etyllica.context.Application;
import br.com.etyllica.core.event.GUIEvent;
import br.com.etyllica.core.event.KeyEvent;
import br.com.etyllica.core.event.PointerEvent;
import br.com.etyllica.core.video.Graphic;
import br.com.tide.input.controller.EasyController;
import br.com.tide.input.controller.FirstPlayerController;
import br.com.tide.input.controller.JoystickOneController;
import childage.players.OldMan;
import childage.players.YoungMan;
import childage.tiles.Floor;


public class HouseApplication extends Application{

	private Floor[][] floor;

	private final int floorWidth = 25;
	private final int floorHeight = 18;
	
	private OldMan oldMan;
	
	private YoungMan youngMan;

	public HouseApplication(int w, int h) {
		super(w, h);
	}

	@Override
	public void load() {

		floor = new Floor[floorHeight][floorWidth];

		for(int j=0; j<floorHeight;j++){
			
			for(int i=0; i<floorWidth;i++){
			
				floor[j][i] = new Floor(i*Floor.TILE_SIZE, j*Floor.TILE_SIZE);
				
			}
			
		}
		
		oldMan = new OldMan(30,80);
		//oldMan.setController(new EasyController());
		oldMan.setController(new JoystickOneController());
		
		youngMan = new YoungMan(530,80);
		youngMan.setController(new FirstPlayerController());

		updateAtFixedRate(20);
		
		loading = 100;
	}
	
	public void timeUpdate(long now){
		
		oldMan.update(now);
		
		youngMan.update(now);		
		
	}

	@Override
	public void draw(Graphic g) {
		g.setColor(Color.BLUE);
		g.fillRect(0,0,w,h);
		
		drawTiles(g);
		
		drawPlayers(g);
		
	}
	
	private void drawPlayers(Graphic g){
		oldMan.draw(g);
		youngMan.draw(g);
	}
	
	private void drawTiles(Graphic g){
		
		g.setColor(Color.BLACK);
		
		for(int j=0; j<floorHeight;j++){
			
			for(int i=0; i<floorWidth;i++){
			
				g.drawRect(floor[j][i]);
				
			}
			
		}
		
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
