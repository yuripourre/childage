package childage.forniture;

import br.com.etyllica.core.video.Graphic;
import br.com.etyllica.util.SVGColor;
import childage.players.ChildagePlayer;

public class Ipod extends Forniture{

	public Ipod(int x, int y){
		super(x, y);
		
		coolDown = 200;
	}
	
	public String use(ChildagePlayer player){
		super.use(player);
		
		if(player.getAge()>10){
			return "WHAAAAT IS THIS?!?!";
		}else{
			return "Uh an Ipod!";			
		}

	}
	
	public void draw(Graphic g){
		
		g.setColor(SVGColor.BLACK);

		g.fillRect(this);

		if(currentCoolDown!=coolDown){

			int barSize = 34;

			int offsetY = 30;

			g.setColor(SVGColor.BLACK);

			g.fillRect(x, y+offsetY, barSize+2, 5);

			g.setColor(SVGColor.GREEN);

			int partialCoolDown = ((currentCoolDown*barSize)/coolDown);
			
			g.fillRect(x+1, y+offsetY+1, partialCoolDown, 3);

		}
		
	}
	
}
