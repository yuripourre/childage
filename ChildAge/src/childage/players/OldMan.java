package childage.players;

import childage.Dialog;

public class OldMan extends ChildagePlayer{

	public OldMan(int x, int y) {
		super(x, y, "oldman.png");
		
		kind = Kind.OLDMAN;
		
		dialog = new Dialog(20, 600, 28, "oldman.png");
		
		dialog.getText().setText("I am an old man");
		
	}
	
}
