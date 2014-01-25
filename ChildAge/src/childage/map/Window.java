package childage.map;

import java.awt.Color;

import br.com.etyllica.core.Drawable;
import br.com.etyllica.core.video.Graphic;
import br.com.etyllica.layer.GeometricLayer;

public class Window extends GeometricLayer implements Drawable{
	
	private int resistance = 1000;
	
	public Window(int x, int y, int w, int h){
		super(x, y, w, h);
	}
	
	public void hit(int power){
		
		resistance-=power;
		
		System.out.println("Window Get Hit ("+resistance+")");
		
	}
	
	public void draw(Graphic g){		

		if(!isBroken()){
			g.setColor(Color.GREEN);	
		}else{
			g.setColor(Color.RED);
		}
				
		g.fillRect(this);
		
	}
	
	public boolean isBroken(){
		return resistance<=0;
	}
	
}
