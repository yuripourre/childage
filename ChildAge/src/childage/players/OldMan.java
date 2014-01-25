package childage.players;

import childage.Dialog;

public class OldMan extends ChildagePlayer{

	public OldMan(int x, int y) {
		super(x, y, "vx_characters.png");
		
		kind = Kind.OLDMAN;
		
		dialog = new Dialog(20, 480, 28);
		
		dialog.getText().setText("I am an old man");
		
		layer.setNeedleX(layer.getTileW()*3*2);
		
	}
	
}
