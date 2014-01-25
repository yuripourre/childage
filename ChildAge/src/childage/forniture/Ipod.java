package childage.forniture;

import childage.players.ChildagePlayer;
import childage.players.Kind;

public class Ipod extends Forniture{

	public Ipod(int x, int y, FornitureListener listener){
		super(x, y, listener);
		
		coolDown = 200;
	}
	
	@Override
	public String use(ChildagePlayer player){
		super.use(player);
		
		if(player.getKind()==Kind.OLDMAN){
			
			return "WHAAAAT IS THIS?!?!";
			
		}else if(player.getKind()==Kind.CHILD){
			
			listener.listenForniture(this);
			
			return "Uh an Ipod!";
		}

		return "";
	}
	
}
