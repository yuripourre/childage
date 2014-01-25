package childage.players;

public class Monster extends ChildagePlayer{

	public Monster(int x, int y){
		super(x, y, "vx_characters.png");
		
		kind = Kind.MONSTER;
		
	}
	
}
