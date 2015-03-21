package model.behavior;

import utilities.Directions;
import utilities.HurtSoundEffect;
import utilities.SoundEffect;
import model.entity.Entity;
import model.entity.EntityEffectHandler;

public class Attack implements Behavior{
	
	public Attack(){}
	
	public void perform(Entity attacker,Entity theAttacked) {
		EntityEffectHandler.applyDamage(theAttacked, attacker.attack());
		int oppositeDirection = Directions.getOppositeDirection(theAttacked.getDirection());
		attacker.setDirection(oppositeDirection);
		SoundEffect effect = new HurtSoundEffect();
	}

	public void getBuffs() {}
}
