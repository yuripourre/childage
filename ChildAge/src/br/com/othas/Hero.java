package br.com.othas;

import java.util.List;

import br.com.etyllica.util.SVGColor;

public abstract class Hero extends NPC{

	public Hero(int x, int y, String rightPath, String leftPath) {
		super(x, y, rightPath, leftPath);
	}
	
	@Override
	public void update(long now, List<Character> targets) {
		super.update(now);
		
		if(isAttacking()){
		
			for(Character target: targets){
				if(colide(target)){
					target.beignHit(this, now);
				}
			}
			
		}
		
		this.lifeBarColor = SVGColor.GREEN;
		
		for(Character target: targets){
			if(colide(target)){
				this.lifeBarColor = SVGColor.ROYAL_BLUE;
			}
		}
		
	}
	
	public void updateAsNPC(long now, List<Character> targets) {
		super.update(now, targets);
	}
	
	private boolean colide(Character target){
		return layer.colideRetangular(target.layer);
	}
	
}
