package childage.players;

import childage.map.Map;
import childage.tiles.Floor;
import br.com.etyllica.core.event.KeyEvent;
import br.com.tide.platform.player.Player;
import br.com.tide.platform.player.PlayerState;

public class ChildagePlayer extends Player{

	public boolean usingItem = false;
	
	public ChildagePlayer(int x, int y) {
		super(x, y, Floor.TILE_SIZE, Floor.TILE_SIZE);
	}
	
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
		
		map.updatePlayer(this);
		
	}
	
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
	
	@Override
	public void handleEvent(KeyEvent event){
		super.handleEvent(event);
		
		if(event.isKeyDown(controller.getButtonA())){
			usingItem = true;
		}else if(event.isKeyUp(controller.getButtonA())){
			usingItem = false;
		}
		
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

	public boolean isUsingItem() {
		return usingItem;
	}

	public void setUsingItem(boolean usingItem) {
		this.usingItem = usingItem;
	}
	
}
