package childage.forniture;

import childage.players.ChildagePlayer;
import childage.players.Kind;

public class Pinico extends ComplexForniture{

	public Pinico(int x, int y, FornitureListener listener){
		super(x, y, listener, "itens/pinico_vazio.png");

		temporary = new PinicoCheio(this.x, this.y, listener);

		coolDown = 200;
	}

	@Override
	public String use(ChildagePlayer player){

		if(!haveFood){

			if(player.getKind()==Kind.CHILD){

				haveFood = true;
				
				return "I wanna pee!!";

			}else if(player.getKind()==Kind.OLDMAN){

				return "I am fine.";
				
			}
			
		}
		
		if(haveFood){
			
			if(player.getKind()==Kind.OLDMAN){

				//startCoolDown
				super.use(player);
				
				player.carry(temporary);

				haveFood = false;
				
				return "";

			}else if(player.getKind()==Kind.CHILD){

				return "I am fine now.";
			}
			
		}

		return "";
	}

}
