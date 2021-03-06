package childage.forniture;

import childage.players.ChildagePlayer;
import childage.players.Kind;
import childage.tiles.Floor;

public class Ipod extends Forniture{

	public Ipod(int x, int y, FornitureListener listener){
		super(x, y, listener, "itens/ipod.png");
		
		this.layer.setW(Floor.TILE_SIZE);
		
		this.layer.setH(Floor.TILE_SIZE);		
		
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
