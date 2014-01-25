package childage.players;

import br.com.etyllica.core.video.Graphic;
import br.com.tide.platform.player.PlayerState;
import childage.Dialog;
import childage.map.Map;

public class HeroPlayer extends ChildagePlayer{
	
	protected Dialog dialog;
		
	public HeroPlayer(int x, int y, String path) {
		super(x, y, path);		
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
		
		map.updatePlayer(this);
		
	}
	
	@Override
	public void draw(Graphic g){
		
		super.draw(g);
		
		dialog.draw(g);
		
	}

	public Dialog getDialog() {
		return dialog;
	}	
		
}
