package childage.forniture;

import childage.players.ChildagePlayer;
import childage.players.Kind;

public class Sock extends Forniture{

	public Sock(int x, int y, FornitureListener listener){
		super(x, y, listener, "itens/sock.png");
		
		coolDown = 200;
	}
	
	@Override
	public String use(ChildagePlayer player){
		super.use(player);
		
		if(player.getKind()==Kind.OLDMAN){
			
			listener.listenForniture(this);
			
			return "WHAAAAT THIS SMELL!?";
			
		}else if(player.getKind()==Kind.CHILD){
			
			return "My favorite sock!";
		}

		return "";
	}
	
}
