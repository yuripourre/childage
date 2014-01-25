package childage.forniture;

import childage.players.ChildagePlayer;

public class Ipod extends Forniture{

	public Ipod(int x, int y){
		super(x, y);
		
		coolDown = 200;		
	}
	
	public String use(ChildagePlayer player){
		super.use();
		
		if(player.getAge()>10){
			return "";	
		}else{
			return "WHAAAAT IS THIS?!?!";
		}		

	}
	
}
