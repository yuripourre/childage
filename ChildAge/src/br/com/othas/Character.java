package br.com.othas;

import java.awt.Color;
import java.util.List;

import br.com.etyllica.core.video.Graphic;
import br.com.etyllica.layer.AnimatedLayer;
import br.com.etyllica.layer.StaticLayer;
import br.com.etyllica.util.SVGColor;
import br.com.tide.platform.player.Player;
import br.com.tide.platform.player.PlayerState;

public abstract class Character extends Player{

	protected AnimatedLayer layer = null;

	private StaticLayer rightLayer = null;

	private StaticLayer leftLayer = null;

	protected Color lifeBarColor = SVGColor.GREEN; 

	public Character(int x, int y, String rightPath, String leftPath) {
		super(x,y,32,64);

		rightLayer = new StaticLayer(rightPath);

		leftLayer = new StaticLayer(leftPath);

		layer = new AnimatedLayer(x,y,32,64);
		layer.setFrames(6);
		layer.setStopped(false);

		onWalkRight();

	}

	@Override
	public void draw(Graphic g) {

		layer.draw(g);

		drawLifeBar(g);

	}

	private void drawLifeBar(Graphic g){

		g.setColor(Color.BLACK);
		g.fillRect(x, y+h+4, w, 4);

		int lifeW = (int)(((w-2)*health)/100);

		g.setColor(lifeBarColor);
		g.fillRect(x+1, y+h+5, lifeW, 2);
	}

	@Override
	public void onWalkLeft(){
		layer.cloneLayer(leftLayer);
	}

	@Override
	public void onWalkRight(){
		layer.cloneLayer(rightLayer);
	}

	@Override
	public void onStand(){

		layer.setFrames(6);

		layer.setYImage(layer.getTileH()*0);
		layer.setXImage(layer.getTileW()*0);
	}

	@Override
	public void onAttack(){

		layer.setFrames(4);

		layer.setXImage(layer.getTileW()*0);
		layer.setYImage(layer.getTileH()*2);
	}

	@Override
	public void onBeignHit(Player attacker) {

		//Calculate damage
		if(health>0){

			health += calculateDefenseDamage(attacker);

			layer.setFrames(3);

			layer.setXImage(layer.getTileW()*0);
			layer.setYImage(layer.getTileH()*1);

		}else{
			die();
		}

	}
	
	@Override
	public void onDie(){
		
		layer.setFrames(1);

		layer.setXImage(layer.getTileW()*4);
		layer.setYImage(layer.getTileH()*5);
		layer.setXTile(64);
		layer.setTileH(64);

	}

	@Override
	public void update(long now){
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

		if(isWalking()||isAttacking()||isBeignHit()){
			layer.nextFrame();
		}

	}

	@Override
	public void setX(int x){
		this.x = x;
		this.layer.setX(x);
	}

	@Override
	public void setY(int y){
		this.y = y;
		this.layer.setY(y);
	}

	public abstract void update(long now, List<Character> targets);

	public float calculateDefenseDamage(Player attacker){
		
		return -55;
	}

}
