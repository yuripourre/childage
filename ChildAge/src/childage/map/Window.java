package childage.map;

import br.com.etyllica.core.Drawable;
import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.layer.GeometricLayer;
import br.com.etyllica.layer.ImageLayer;
import br.com.etyllica.layer.StaticLayer;

public class Window extends GeometricLayer implements Drawable{
	
	private StaticLayer normalLayer;
	
	private StaticLayer brokenLayer;
	
	private ImageLayer layer;
	
	private int resistance = 1000;
	
	private int xTarget;
	
	private int yTarget;
	
	public Window(int x, int y, String normalPath, String brokenPath){
		super(x, y);
		
		xTarget = 10;
		
		yTarget = 10;
		
		normalLayer = new StaticLayer(normalPath);
		
		brokenLayer = new StaticLayer(brokenPath);
		
		layer = new ImageLayer(x, y);
		
		layer.cloneLayer(normalLayer);
		
	}
	
	public void hit(int power){
		
		resistance-=power;
		
		if(isBroken()){
			layer.cloneLayer(brokenLayer);
		}
		
	}
	
	public void draw(Graphic g){		

		layer.draw(g);
		
		/*if(!isBroken()){
			g.setColor(Color.GREEN);	
		}else{
			g.setColor(Color.RED);
		}
				
		g.fillRect(this);*/
		
	}
	
	public boolean isBroken(){
		return resistance<=0;
	}

	public int getxTarget() {
		return xTarget;
	}

	public void setxTarget(int xTarget) {
		this.xTarget = xTarget;
	}

	public int getyTarget() {
		return yTarget;
	}

	public void setyTarget(int yTarget) {
		this.yTarget = yTarget;
	}
	
}
