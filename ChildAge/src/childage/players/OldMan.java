package childage.players;

import childage.Dialog;

public class OldMan extends ChildagePlayer{

	public OldMan(int x, int y) {
		super(x, y, "vx_characters.png");
		
		age = 89;
		
		dialog = new Dialog(20, 480, 28);
		
		dialog.getText().setText("I am an old man");
		
	}
	
}
