package childage.players;

import java.util.List;

import br.com.etyllica.layer.StaticLayer;
import br.com.tide.PlayerState;
import childage.map.Window;

public class Monster extends ChildagePlayer {

	private StaticLayer attack;

	private StaticLayer stand;

	private int power = 600;

	private long startAttack = 0;

	private long delayAttack = 3000;

	private Window targetWindow;

	private List<ChildagePlayer> players;

	private ChildagePlayer targetHero = null;

	public Monster(int x, int y, Window targetWindow, List<ChildagePlayer> players){
		super(x, y, "monster.png");

		attack = new StaticLayer("monster_attack.png");

		stand = new StaticLayer(layer.getPath());

		kind = Kind.MONSTER;

		walkSpeed = 4;

		this.targetWindow = targetWindow;

		this.players = players;

	}

	@Override
	public void update(long now){
		super.update(now);
		
		if(!targetWindow.isBroken()){
			
			reachWindow(now);
			
		}else{
			
			this.layer.cloneLayer(stand);
			
			reachHero(now);
		}

		if(isWalking()){

			this.layer.nextFrame();
		}

	}

	private void reachHero(long now){

		boolean goLeft = false;
		boolean goRight = false;
		boolean goUp = false;
		boolean goDown = false;

		if(this.getLayer().getX()+this.getLayer().getTileW()<targetHero.getX()){
			goRight = true;
		}
		else if(this.getLayer().getX()>targetHero.getX()){
			goLeft = true;
		}

		if(this.getLayer().getY()+this.getLayer().getTileH()<targetHero.getY()){
			goDown = true;
		}
		else if(this.getLayer().getY()>targetHero.getY()){
			goUp = true;
		}

		doWalkUp(goUp, now);

		doWalkDown(goDown, now);

		doWalkLeft(goLeft, now);

		doWalkRight(goRight, now);

		//Verify Actions
		if(!goRight&&!goLeft&&!goUp&&!goDown){

			if(!isAttacking()){

				attack();

				startAttack = now;

			}

		}

		if(isAttacking()){

			hitHero(now);

		}

	}

	private void hitHero(long now){

	}

	private void reachWindow(long now){

		boolean goLeft = false;
		
		boolean goRight = false;
		
		boolean goUp = false;
		
		boolean goDown = false;

		if(this.getLayer().getX()+this.getLayer().getTileW()<targetWindow.getX()){
			goRight = true;
		}
		else if(this.getLayer().getX()>targetWindow.getX()){
			goLeft = true;
		}

		if(this.getLayer().getY()+this.getLayer().getTileH()<targetWindow.getY()){
			goDown = true;
		}
		else if(this.getLayer().getY()>targetWindow.getY()){
			goUp = true;
		}

		doWalkUp(goUp, now);

		doWalkDown(goDown, now);

		doWalkLeft(goLeft, now);

		doWalkRight(goRight, now);

		//Verify Actions
		if(!goRight&&!goLeft&&!goUp&&!goDown){

			if(!isAttacking()){

				attack();

				startAttack = now;

			}

		}

		if(isAttacking()){

			hitWindow(now);

			layer.nextFrame();

		}

	}

	@Override
	public void onAttack(){

		if(!targetWindow.isBroken()){

			this.layer.cloneLayer(attack);

		}
		
	}

	public void onStopAttack(){
		this.layer.cloneLayer(stand);
	}

	private void hitWindow(long now){

		if(now>startAttack+delayAttack){
			targetWindow.hit(power);

			stopAttack();

			if(targetWindow.isBroken()){
				aimHero();
			}
		}

	}

	private void aimHero(){
		targetHero = players.get(0);
	}

	private void doWalkUp(boolean goUp, long now){

		if(goUp){
			walkUp();
		}else if(states.contains(PlayerState.WALK_UP)){
			stopWalkUp();
		}

	}

	private void doWalkDown(boolean goDown, long now){

		if(goDown){
			walkDown();
		}else if(states.contains(PlayerState.WALK_DOWN)){
			stopWalkDown();
		}

	}

	private void doWalkLeft(boolean goLeft, long now){

		if(goLeft){
			walkLeft();
		}else if(states.contains(PlayerState.WALK_LEFT)){
			stopWalkLeft();
		}

	}

	private void doWalkRight(boolean goRight, long now){

		if(goRight){
			walkRight();
		}else if(states.contains(PlayerState.WALK_RIGHT)){
			stopWalkRight();
		}

	}

	@Override
	public void onDie(){
		//this.layer.setOpacity(50);
		this.layer.setVisible(false);		
	}

}
