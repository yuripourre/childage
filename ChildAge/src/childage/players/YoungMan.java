package childage.players;

import childage.Dialog;

public class YoungMan extends ChildagePlayer{

	public YoungMan(int x, int y) {
		super(x, y, "vx_characters.png");
		
		age = 5;
		
		dialog = new Dialog(420, 480, 20);
		
		dialog.getText().setText("I am a young man");
		
	}
	
}
