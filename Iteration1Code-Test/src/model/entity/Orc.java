package model.entity;

import utilities.DeathSoundEffect;
import utilities.SoundEffect;
import model.behavior.Attack;
import model.behavior.IdleBehavior;
import model.behavior.Patrol;
import model.behavior.Stand;
import model.occupation.OrcTerminator;

public class Orc extends NPC {
	
	public Orc(){
		super(new OrcTerminator());
		this.engagedState.setState(new Attack(this));
		this.preferredState.setState(new Stand(this));
	}
	
	public String toString() {
		return name+"NPC:Orc";
	}

	public void makeDeathSoundEffect() {
		SoundEffect effect = new DeathSoundEffect();
	}
	
}
