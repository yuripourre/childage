package childage.map;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import br.com.etyllica.core.Drawable;
import br.com.etyllica.core.video.Graphic;
import br.com.etyllica.layer.AnimatedLayer;
import br.com.etyllica.util.SVGColor;
import childage.forniture.Stove;
import childage.forniture.Forniture;
import childage.forniture.FornitureListener;
import childage.forniture.Ipod;
import childage.forniture.TemporaryForniture;
import childage.players.ChildagePlayer;
import childage.players.Monster;
import childage.tiles.Floor;

public class Map implements Drawable, FornitureListener{

	private List<ChildagePlayer> players = new ArrayList<ChildagePlayer>();

	private List<Window> windows = new ArrayList<Window>();

	private List<Monster> monsters = new ArrayList<Monster>();

	private List<Forniture> fornitures = new ArrayList<Forniture>();

	private List<Forniture> temporaryFornitures = new ArrayList<Forniture>();

	private Floor[][] floor;

	private final int floorWidth = 20;

	private final int floorHeight = 10;

	public Map(){
		super();

		fornitures.add(new Ipod(100, 100, this));

		fornitures.add(new Ipod(490, 190, this));

		fornitures.add(new Stove(900, 120, this));


		windows.add(new Window(180, 60, 90, 16));

		windows.add(new Window(400, 60, 90, 16));

		windows.add(new Window(200, 160, 16, 90));

		windows.add(new Window(200, 280, 16, 90));


		monsters.add(new Monster(180, 20, windows.get(0), players));

		monsters.add(new Monster(10, 120, windows.get(2), players));


		floor = new Floor[floorHeight][floorWidth];

		int offsetY = 40;

		for(int j=0; j<floorHeight;j++){

			for(int i=0; i<floorWidth;i++){

				floor[j][i] = new Floor(i*Floor.TILE_SIZE, offsetY+j*Floor.TILE_SIZE);

			}

		}

	}

	public void draw(Graphic g){

		drawTiles(g);

		drawFornitures(g);

		drawWindows(g);

		drawMonsters(g);

	}

	private void drawMonsters(Graphic g){

		for(Monster monster: monsters){
			monster.draw(g);
		}

	}

	private void drawTiles(Graphic g){

		g.setColor(Color.BLACK);

		for(int j=0; j<floorHeight;j++){

			for(int i=0; i<floorWidth;i++){

				g.drawRect(floor[j][i]);

			}

		}
	}

	private void drawFornitures(Graphic g){

		g.setColor(SVGColor.CRIMSON);

		for(Forniture forniture: fornitures){
			forniture.draw(g);
		}

		for(Forniture forniture: temporaryFornitures){
			forniture.draw(g);
		}

	}

	private void drawWindows(Graphic g){

		for(Window window: windows){
			window.draw(g);
		}

	}

	private Forniture colide(int bx, int by, int bw, int bh){

		for(Forniture forniture: fornitures){

			if(forniture.colideRect(bx, by, bw, bh)){
				return forniture;
			}

		}

		return null;

	}
	
	public void update(long now){

		for(Forniture forniture: fornitures){

			forniture.update(now);

		}

		for(Monster monster: monsters){

			monster.update(now);

		}

		for(Forniture forniture: temporaryFornitures){

			for(Monster monster: monsters){

				monsterColision(monster, forniture);

			}

		}

	}

	public void updatePlayer(ChildagePlayer player) {

		AnimatedLayer layer = player.getLayer();

		Forniture forniture = colide(layer.getX(), layer.getY(), layer.getTileW(), layer.getTileH());

		if(forniture!=null){

			if(player.isAttacking()){

				String text = forniture.use(player);

				if(!text.isEmpty()){

					player.getDialog().getText().setText(text);

				}

			}		

			player.undoWalk();

		}else{

			if(player.isSpecialAttacking()){

				if(player.isCarringItem()){

					TemporaryForniture carried = player.getCarried();

					TemporaryForniture clone = cloneTemporaryForniture(player.getX(), player.getY(), carried);

					temporaryFornitures.add(clone);

					listenForniture(clone);

					player.dropItem();

				}

			}

		}

	}

	private TemporaryForniture cloneTemporaryForniture(int x, int y, TemporaryForniture forniture){

		TemporaryForniture clone = new TemporaryForniture(x, y, this, forniture.getPath());

		return clone;

	}

	@Override
	public void listenForniture(Forniture forniture) {

		for(Monster monster: monsters){

			monsterColision(monster, forniture);

		}

	}
	
	private void monsterColision(Monster monster, Forniture forniture){
		
		if(monster.colideRect(forniture.getRange().getX(), forniture.getRange().getY(), forniture.getRange().getW(), forniture.getRange().getH())){
			monster.die();
		}
		
	}

	public void addPlayer(ChildagePlayer player) {

		players.add(player);

	}

}
