package childage.house;

import br.com.etyllica.core.video.Graphic;
import childage.forniture.Forniture;
import childage.players.ChildagePlayer;

public class Wall extends Forniture{
	
	public Wall(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	
	@Override
	public void draw(Graphic g) {
		
		/*g.setColor(Color.BLUE);
		g.setAlpha(60);
		g.fillRect(layer);
		g.setAlpha(100);*/
		
	}
	
	@Override
	public String use(ChildagePlayer player){
		return "";
	}
	
}
