package model.items;

import model.visitor.EquipableVisitor;
import model.visitor.ItemVisitor;
import model.visitor.WeaponVisitor;

public class TerminatorBrawling extends TerminatorWeapon{

	public TerminatorBrawling(int attack) {
		super(attack);
	}

	public void accept(ItemVisitor visitor) {
		visitor.accept(this);
	}

	public void accept(EquipableVisitor visitor) {
		visitor.accept(this);
	}
	
	public String toString() {
		return "Weapon:TerminatorBrawling:" + this.getBonus();
	}

	public void accept(WeaponVisitor visitor) {
		visitor.accept(this);
	}
}
