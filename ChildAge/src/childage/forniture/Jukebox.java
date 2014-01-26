package childage.forniture;

import childage.players.ChildagePlayer;
import childage.players.Kind;

public class Jukebox extends Forniture{	
	
	public Jukebox(int x, int y, FornitureListener listener){
		super(x, y, listener, "itens/vitrola.png");	
		
		coolDown = 200;
	}
	
	@Override
	public String use(ChildagePlayer player){
		super.use(player);
		
		if(player.getKind()==Kind.OLDMAN){
			
			return "Uh a Jukebox!";
			
		}else if(player.getKind()==Kind.CHILD){
			
			listener.listenForniture(this);
			
			return "WHAAAAT IS THIS?!?!";
		}

		return "";
	}
	
}
