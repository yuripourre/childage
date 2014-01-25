package childage.forniture;

import br.com.etyllica.core.video.Graphic;
import br.com.etyllica.layer.ImageLayer;
import childage.players.ChildagePlayer;
import childage.players.Kind;

public class Fogao extends Forniture{

	private ImageLayer fryer;

	private boolean haveFood = false;

	public Fogao(int x, int y, FornitureListener listener){
		super(x, y, listener, "itens/fogao.png");

		fryer = new ImageLayer(this.x+10, this.y+20, "itens/panela.png");

		coolDown = 200;
	}

	@Override
	public String use(ChildagePlayer player){
		super.use(player);

		if(!haveFood){

			if(player.getKind()==Kind.OLDMAN){

				//listener.listenForniture(this);

				haveFood = true;
				
				return "I will make my precious recipe";

			}else if(player.getKind()==Kind.CHILD){

				return "Ouch! It's hot!";
			}
			
		}
		
		if(haveFood){
			
			if(player.getKind()==Kind.CHILD){

				listener.listenForniture(this);

				haveFood = true;
				
				return "Carry Item";

			}else if(player.getKind()==Kind.OLDMAN){

				return "Delicious!!";
			}
			
		}

		return "";
	}
	
	@Override
	public void draw(Graphic g){
		
		super.draw(g);
		
		if(haveFood){
			fryer.draw(g);
		}
		
	}

}
