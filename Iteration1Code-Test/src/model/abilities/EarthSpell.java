package model.abilities;

import utilities.EarthSpellSoundEffect;
import utilities.SoundEffect;
import model.entity.Entity;

public class EarthSpell extends BaneAreaOfAffect{
	private int damage = 12;
	private int mana = 11;
	private int radius = 1;

	public EarthSpell(Entity entity) {
		super(entity);
	}
	public int getDamage() {
		SoundEffect gogo = new EarthSpellSoundEffect();
		return  this.entity.getSkillValue("Bane") * damage;
	}

	public int getManaRequirement() {
		return mana;
	}
	@Override
	public int getRadius() {
		return radius;
	}

}
