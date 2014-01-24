package childage.players;

import childage.tiles.Floor;
import br.com.tide.platform.player.Player;
import br.com.tide.platform.player.PlayerState;

public class ChildagePlayer extends Player{

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
		
}
