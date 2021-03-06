package model.slots;

import model.items.Equipable;
import model.items.Shield;
import model.items.TakeableItem;
import model.items.TerminatorTwoHandedWeapon;
import model.items.Weapon;

public class TwoHandedWeaponSlot extends BufferSlot{
	private TerminatorTwoHandedWeapon equippedItem;
	private TerminatorWeaponSlot weaponSlot;
	private ShieldSlot shieldSlot;
	
	public TwoHandedWeaponSlot(TerminatorWeaponSlot weaponSlot, ShieldSlot shieldSlot){
		this.weaponSlot = weaponSlot;
		this.shieldSlot = shieldSlot;
		this.weaponSlot.setTHW(this);
		this.shieldSlot.setTHW(this);
	}

	//**************  UNEQUIP ***************************
	protected Equipable unequipItem() {
		Equipable temp = this.equippedItem;
		this.equippedItem = null;
		this.weaponSlot.drop();
		return temp;
	}
	
	public Equipable unequipShield(){
		return this.shieldSlot.unequip();
	}
	
	public Equipable unequipWeapon(){
		return this.weaponSlot.unequip();
	}
	
	//**********************  EQUIP ******************************
	public boolean equip(TerminatorTwoHandedWeapon thw){
		if (this.weaponSlot.has() || this.shieldSlot.has()) return false;
		else{
			this.weaponSlot.equip(thw);
			this.equippedItem = thw;
			this.send();
			return true;
		}
	}
	
	public boolean equipShield(Shield shield){
		if (this.has()) return false;
		else return this.shieldSlot.equip(shield);
	}
	
	public boolean equipWeapon(Weapon weapon){
		if (this.has()) return false;
		else return this.weaponSlot.equip(weapon);
	}

	public TakeableItem get() {
		return this.equippedItem;
	}

	public int calculateBonus() {
		return this.equippedItem.getBonus();
	}

	public boolean has() {
		return weaponSlot.hasTHW();
	}
	
	public String toString() {
		if (this.has()) return "Weapon:TwoHandedWeapon:" + this.getBonus();
		else return "Weapon:TwoHandedWeapon:-1";
	}
	
    // This is used to send info to update the Observers upon equip
    protected final void send(){
        this.setBonus();
        this.setChanged();  		//notify the Observers of change
        this.notifyObservers();
    }
}
