package childage.players;

import java.awt.Color;

import br.com.etyllica.core.Drawable;
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

public class ChildagePlayer extends Player implements Drawable {

	protected Kind kind = Kind.CHILD;

	protected Dialog dialog;

	public boolean usingItem = false;

	protected AnimatedLayer layer = null;

	protected Color lifeBarColor = SVGColor.GREEN;

	private TemporaryForniture carried = null;

	protected int walkSpeed = 5;

	protected long hitDelay = 200;

	public ChildagePlayer(int x, int y, String path) {
		super();

		walkSpeed = 20;

		layer = new AnimatedLayer(x, y, Floor.TILE_SIZE, Floor.TILE_SIZE, path);

		layer.setAnimaEmX(true);

		layer.setFrames(3);

	}

	@Override
	public void update(long now) {
		super.update(now);
		
		if(isBeignHit()) {
			
			if(now-wasHit>hitDelay) {
				this.stand();
			}
			
		} else {
			walk();
		}
		
		layer.animate(now);

	}

	private void walk(){

		if(state.contains(PlayerState.WALK_RIGHT)){
			this.layer.setOffsetX(walkSpeed);
		}else if(state.contains(PlayerState.WALK_LEFT)){
			this.layer.setOffsetX(-walkSpeed);
		}

		if(state.contains(PlayerState.WALK_DOWN)){
			this.layer.setOffsetY(walkSpeed);
		}else if(state.contains(PlayerState.WALK_UP)){
			this.layer.setOffsetY(-walkSpeed);
		}
	}

	public void update(long now, Map map){
		super.update(now);

		walk();

		if(isWalking()){
			layer.animate(now);			
		}

		map.updatePlayer(this, now);
		
	}
	
	public int getX() {
		return layer.getX();
	}
	
	public int getY() {
		return layer.getY();
	}

	public void setX(int x){
		layer.setX(x);
	}

	public void setY(int y){
		layer.setY(y);
	}

	@Override
	public void draw(Graphic g){

		layer.draw(g);


	}	

	public void drawDialog(Graphic g){

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
			this.layer.setOffsetX(walkSpeed);
		}else if(state.contains(PlayerState.WALK_LEFT)){
			this.layer.setOffsetX(-walkSpeed);
		}

		if(state.contains(PlayerState.WALK_DOWN)){
			this.layer.setOffsetY(walkSpeed);
		}else if(state.contains(PlayerState.WALK_UP)){
			this.layer.setOffsetY(-walkSpeed);
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
		this.dialog.changeCarryItem(forniture.getPath());
	}

	public boolean isCarringItem(){
		return carried!=null;
	}

	public TemporaryForniture getCarried() {
		return carried;
	}

	public void dropItem() {
		carried = null;
		this.dialog.hideCarryItem();
	}

}
