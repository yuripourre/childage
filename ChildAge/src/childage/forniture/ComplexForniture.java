package childage.forniture;

import br.com.etyllica.core.video.Graphic;

public abstract class ComplexForniture extends Forniture{

	protected TemporaryForniture temporary;
	
	protected boolean haveFood = false;
	
	public ComplexForniture(int x, int y, FornitureListener listener,
			String path) {
		super(x, y, listener, path);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphic g){
		
		super.draw(g);
		
		if(haveFood){
			temporary.draw(g);
		}
		
	}
	
}
