package childage.map;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.etyllica.core.Drawable;
import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.core.graphics.SVGColor;
import br.com.etyllica.layer.AnimatedLayer;
import br.com.tide.PlayerState;
import childage.forniture.Forniture;
import childage.forniture.FornitureListener;
import childage.forniture.Ipod;
import childage.forniture.Jukebox;
import childage.forniture.Pinico;
import childage.forniture.Sock;
import childage.forniture.Stove;
import childage.forniture.TemporaryForniture;
import childage.house.Wall;
import childage.players.ChildagePlayer;
import childage.players.Monster;

public class Map implements Drawable, FornitureListener{

	private List<ChildagePlayer> players = new ArrayList<ChildagePlayer>();

	private List<Window> windows = new ArrayList<Window>();

	private List<Monster> monsters = new ArrayList<Monster>();

	private List<Forniture> fornitures = new ArrayList<Forniture>();

	private List<TemporaryForniture> temporaryFornitures = new ArrayList<TemporaryForniture>();

	private static final long FORNITURE_DELAY = 2000;

	private static final long WAVE_DELAY = 4000;

	private long lastWave = 1;

	private int monsterKilled = 0;

	private int activeMonsters = 0;

	public Map() {
		super();

		//Left Window
		Window leftWindow = new Window(165, 210, "windows/left_window.png", "windows/left_window_broken.png");

		leftWindow.setxTarget(-120);

		windows.add(leftWindow);

		//Right Window
		Window rightWindow = new Window(1092, 470, "windows/right_window.png", "windows/right_window_broken.png");

		rightWindow.setxTarget(50);

		windows.add(rightWindow);

		//Upper Left Window
		Window upperLeftWindow = new Window(379, 53, "windows/upper_left_window.png", "windows/upper_left_window_broken.png");

		upperLeftWindow.setyTarget(-110);

		windows.add(upperLeftWindow);

		//Upper Right Window
		Window upperRightWindow = new Window(760, 53, "windows/upper_right_window.png", "windows/upper_right_window_broken.png");

		upperRightWindow.setyTarget(-110);

		//Upper Right Window
		windows.add(upperRightWindow);


		fornitures.add(new Jukebox(320, 180, this));

		fornitures.add(new Ipod(490, 190, this));

		fornitures.add(new Stove(896, 185, this));

		fornitures.add(new Pinico(325, 448, this));

		fornitures.add(new Sock(969, 460, this));

		fornitures.add(new Wall(200, 128, 886, 45));

		fornitures.add(new Wall(206, 355, 300, 45));

		fornitures.add(new Wall(188, 168, 45, 200));

		fornitures.add(new Wall(193, 416, 45, 200));

		fornitures.add(new Wall(462, 380, 40, 95));

		//Down
		fornitures.add(new Wall(200, 630, 886, 50));

		//Left
		fornitures.add(new Wall(1055, 197, 40, 430));

		fornitures.add(new Wall(793, 350, 260, 65));

		fornitures.add(new Wall(777, 292, 40, 116));

	}

	public void draw(Graphic g) {

		drawFornitures(g);

		drawWindows(g);

		drawMonsters(g);

		g.setColor(Color.WHITE);
		g.drawShadow(980, 60, "Monsters Killed: "+monsterKilled);

	}

	private void drawMonsters(Graphic g) {

		for(Monster monster: monsters) {
			monster.draw(g);
		}

	}

	private void drawFornitures(Graphic g) {

		g.setColor(SVGColor.CRIMSON);

		for(Forniture forniture: fornitures) {
			forniture.draw(g);
		}

		for(Forniture forniture: temporaryFornitures) {
			forniture.draw(g);
		}

	}

	private void drawWindows(Graphic g) {

		for(Window window: windows) {
			window.draw(g);
		}

	}

	private Forniture colide(int bx, int by, int bw, int bh) {

		for(Forniture forniture: fornitures) {

			if(forniture.colideRect(bx, by, bw, bh)) {
				return forniture;
			}

		}

		return null;

	}

	private boolean activeWave = true;

	public void update(long now) {

		//System.out.println("Now: "+now);
		//System.out.println("Last Wave: "+lastWave);
		//System.out.println("Result: "+now/WAVE_DELAY);

		if(now>lastWave+WAVE_DELAY) {

			if(activeWave) {

				for(Window window: windows) {

					createMonster(window);

				}

				lastWave = now;

				activeWave = false;
			}

		}

		for(Forniture forniture: fornitures) {

			forniture.update(now);

		}

		for(Monster monster: monsters) {

			monster.update(now);

		}

		for(int i=temporaryFornitures.size()-1;i>=0;i--) {

			TemporaryForniture forniture = temporaryFornitures.get(i);

			for(Monster monster: monsters) {

				monsterColision(monster, forniture);

			}

			if(now>forniture.getDropped()+FORNITURE_DELAY) {
				temporaryFornitures.remove(i);
			}

		}

		//activeNextWave(now);

	}
	
	private void activeNextWave(long now) {
		
		if(!activeWave) {
			
			if(monsterKilled==activeMonsters) {

				activeWave = true;

				lastWave = now;

			}
		}
		
	}

	private void createMonster(Window window) {

		Random random = new Random();

		if(random.nextInt(10)>1) {

		}

		activeMonsters++;
		monsters.add(new Monster(window.getX()+window.getxTarget(), window.getY()+window.getyTarget(), window, players));

	}

	public void updatePlayer(ChildagePlayer player, long now) {

		AnimatedLayer layer = player.getLayer();

		Forniture forniture = colide(layer.getX(), layer.getY(), layer.getTileW(), layer.getTileH());

		if(forniture!=null) {

			if(player.isAttacking()) {

				String text = forniture.use(player);

				if(!text.isEmpty()) {

					player.getDialog().getText().setText(text);

				}

			}		

			player.undoWalk();

		} else {

			if(player.hasState(PlayerState.SPECIAL_ATTACK)) {

				if(player.isCarringItem()) {

					TemporaryForniture carried = player.getCarried();

					TemporaryForniture clone = cloneTemporaryForniture(player.getX(), player.getY(), carried);

					temporaryFornitures.add(clone);

					listenForniture(clone);

					clone.setDropped(now);

					player.dropItem();

				}

			}

		}

	}

	private TemporaryForniture cloneTemporaryForniture(int x, int y, TemporaryForniture forniture) {

		TemporaryForniture clone = new TemporaryForniture(x, y, this, forniture.getPath());

		return clone;

	}

	@Override
	public void listenForniture(Forniture forniture) {

		for(Monster monster: monsters) {

			monsterColision(monster, forniture);

		}

	}

	private boolean monsterColision(Monster monster, Forniture forniture) {

		if(monster.getLayer().colideRect(forniture.getRange().getX(), forniture.getRange().getY(), forniture.getRange().getW(), forniture.getRange().getH())) {

			if(monster.getLayer().isVisible()) {

				monsterKilled++;

				monster.die();				

			}

			return true;
		}

		return false;

	}

	public void addPlayer(ChildagePlayer player) {

		players.add(player);

	}

}
