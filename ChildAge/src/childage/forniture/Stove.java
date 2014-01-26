package childage.forniture;

import childage.players.ChildagePlayer;
import childage.players.Kind;

public class Stove extends ComplexForniture{

	public Stove(int x, int y, FornitureListener listener){
		super(x, y, listener, "itens/fogao.png");

		temporary = new Fryer(this.x+5, this.y-25, listener);

		coolDown = 200;
	}

	@Override
	public String use(ChildagePlayer player){

		if(!haveFood){

			if(player.getKind()==Kind.OLDMAN){

				haveFood = true;
				
				return "I will make my precious recipe";

			}else if(player.getKind()==Kind.CHILD){

				return "Ouch! It's hot!";
				
			}
			
		}
		
		if(haveFood){
			
			if(player.getKind()==Kind.CHILD){

				//startCoolDown
				super.use(player);
				
				player.carry(temporary);

				haveFood = false;
				
				return "";

			}else if(player.getKind()==Kind.OLDMAN){

				return "Delicious!!";
			}
			
		}

		return "";
	}

}
