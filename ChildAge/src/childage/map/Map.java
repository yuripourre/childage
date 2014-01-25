package childage.map;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import br.com.etyllica.core.Drawable;
import br.com.etyllica.core.video.Graphic;
import br.com.etyllica.util.SVGColor;
import childage.Dialog;
import childage.forniture.Forniture;
import childage.players.ChildagePlayer;
import childage.players.OldMan;
import childage.tiles.Floor;

public class Map implements Drawable{
	
	private List<Forniture> fornitures;
	
	private Floor[][] floor;
	
	private final int floorWidth = 25;
	
	private final int floorHeight = 18;
	
	public Map(){
		super();
		
		fornitures = new ArrayList<Forniture>();
		
		fornitures.add(new Forniture(20, 20));
		
		floor = new Floor[floorHeight][floorWidth];

		for(int j=0; j<floorHeight;j++){
			
			for(int i=0; i<floorWidth;i++){
			
				floor[j][i] = new Floor(i*Floor.TILE_SIZE, j*Floor.TILE_SIZE);
				
			}
			
		}
		
	}
	
	public void draw(Graphic g){
		
		drawTiles(g);
		
		drawFornitures(g);
		
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
		
	}
	
	public Forniture colide(int bx, int by, int bw, int bh){
		
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
		
	}

	public void updatePlayer(ChildagePlayer player) {
		
		Forniture forniture = colide(player.getX(), player.getY(), player.getW(), player.getH());
			
		if(forniture!=null){
			
			if(player.isAttacking()){
				
				String text = forniture.use();
				
				if(!text.isEmpty()){
					//player.getDialog().setText();
				}
				
			}		
			
			player.undoWalk();
		}
		
	}

}
