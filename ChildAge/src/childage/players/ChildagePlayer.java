package childage.players;

import java.awt.Color;

import br.com.etyllica.core.video.Graphic;
import br.com.etyllica.layer.AnimatedLayer;
import br.com.etyllica.util.SVGColor;
import br.com.tide.platform.player.Player;
import br.com.tide.platform.player.PlayerState;
import childage.Dialog;
import childage.forniture.Forniture;
import childage.forniture.TemporaryForniture;
import childage.map.Map;
import childage.tiles.Floor;

public class ChildagePlayer extends Player{

	protected Kind kind = Kind.CHILD;
	
	protected Dialog dialog;
	
	public boolean usingItem = false;
	
	protected AnimatedLayer layer = null;

	protected Color lifeBarColor = SVGColor.GREEN;
	
	private TemporaryForniture carried = null;
	
	public ChildagePlayer(int x, int y, String path) {
		super(x, y, Floor.TILE_SIZE, Floor.TILE_SIZE);
		
		walkSpeed = 20;
		
		layer = new AnimatedLayer(x, y, Floor.TILE_SIZE, Floor.TILE_SIZE, path);
		
		layer.setAnimaEmX(true);
		
		layer.setFrames(3);
		
	}
	
	public void update(long now){
		super.update(now);
		
		walk();
	}
	
	public void walk(){
		
		if(state.contains(PlayerState.WALK_RIGHT)){
			this.setOffsetX(walkSpeed);
		}else if(state.contains(PlayerState.WALK_LEFT)){
			this.setOffsetX(-walkSpeed);
		}

		if(state.contains(PlayerState.WALK_DOWN)){
			this.setOffsetY(walkSpeed);
		}else if(state.contains(PlayerState.WALK_UP)){
			this.setOffsetY(-walkSpeed);
		}
	}
	
	public void update(long now, Map map){
		super.update(now);
		
		if(state.contains(PlayerState.WALK_RIGHT)){			
			this.setOffsetX(walkSpeed);
		}else if(state.contains(PlayerState.WALK_LEFT)){
			this.setOffsetX(-walkSpeed);
		}

		if(state.contains(PlayerState.WALK_DOWN)){
			this.setOffsetY(walkSpeed);
		}else if(state.contains(PlayerState.WALK_UP)){
			this.setOffsetY(-walkSpeed);
		}
		
		if(isWalking()){
			layer.nextFrame();
		}
		
		map.updatePlayer(this, now);
		
	}
	
	@Override
	public void setX(int x){
		this.x = x;
		layer.setX(x);
	}
	
	@Override
	public void setY(int y){
		this.y = y;
		layer.setY(y);
	}
	
	@Override
	public void draw(Graphic g){
		
		layer.draw(g);
		
		if(dialog!=null){
			dialog.draw(g);	
		}		
		
	}
	
	@Override
	public void onWalkRight(){
		layer.setYImage(layer.getTileH()*2);
	}
	
	@Override
	public void onWalkLeft(){
		layer.setYImage(layer.getTileH()*1);
	}
	
	@Override
	public void onWalkUp(){
		
		if(!state.contains(PlayerState.WALK_RIGHT)&&!state.contains(PlayerState.WALK_LEFT)){
			layer.setYImage(layer.getTileH()*3);
		}
		
	}
	
	@Override
	public void onWalkDown(){
		
		if(!state.contains(PlayerState.WALK_RIGHT)&&!state.contains(PlayerState.WALK_LEFT)){
			layer.setYImage(layer.getTileH()*0);
		}
		
	}
	
	@Override
	public void onStopWalkRight(){
		
		if(state.contains(PlayerState.WALK_UP)){
			onWalkUp();
		}
		
		if(state.contains(PlayerState.WALK_DOWN)){
			onWalkDown();
		}
		
	}
	
	@Override 
	public void onStopWalkLeft(){
		onStopWalkRight();
	}
	
	@Override
	public void attack(){
		state.add(PlayerState.ATTACK);
		onAttack();
	}
	
	@Override
	public void onAttack(){
		usingItem = true;
	}
	
	@Override
	public void onStopAttack(){
		usingItem = false;
	}
	
	public void undoWalk(){
		
		int walkSpeed = -this.walkSpeed;
		
		if(state.contains(PlayerState.WALK_RIGHT)){
			this.setOffsetX(walkSpeed);
		}else if(state.contains(PlayerState.WALK_LEFT)){
			this.setOffsetX(-walkSpeed);
		}

		if(state.contains(PlayerState.WALK_DOWN)){
			this.setOffsetY(walkSpeed);
		}else if(state.contains(PlayerState.WALK_UP)){
			this.setOffsetY(-walkSpeed);
		}
		
	}

	public Dialog getDialog() {
		return dialog;
	}

	public Kind getKind() {
		return kind;
	}
	
	public boolean colide(Forniture forniture){
		return layer.colideRect(forniture.getX(), forniture.getY(), forniture.getW(), forniture.getH());
	}

	public AnimatedLayer getLayer() {

		return layer;
	}
	
	public void carry(TemporaryForniture forniture){
		this.carried = forniture;
	}
	
	public boolean isCarringItem(){
		return carried!=null;
	}

	public TemporaryForniture getCarried() {
		return carried;
	}

	public void dropItem() {
		carried = null;
	}
	
}
