package childage.players;

import childage.Dialog;

public class YoungMan extends ChildagePlayer{

	public YoungMan(int x, int y) {
		super(x, y, "child.png");
		
		kind = Kind.CHILD;
		
		this.layer.setSpeed(200);
		
		dialog = new Dialog(760, 600, 20, "child.png");
		
		dialog.getText().setText("I am a child.");
		
	}
	
}
