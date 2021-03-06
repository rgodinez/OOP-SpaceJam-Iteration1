package model.occupation;

import model.items.equipment.EquipmentBuilder;
import model.slots.Equipment;
import model.stats.factory.MerchantHunterStatFactory;
import model.stats.factory.StatFactory;
import model.visitor.OccupationVisitor;
import utilities.SpriteSheetUtility;

public class MerchantHunter extends Hunter{
	
	protected StatFactory getStatFactory(Equipment equipment){
		return new MerchantHunterStatFactory(equipment);
	}
	public Equipment createEquipment(EquipmentBuilder eb){
		return eb.buildEquipmentHunterNPC(this);
	}
	public SpriteSheetUtility getSpriteSheet(){
		return new SpriteSheetUtility(this);
	}
	@Override
	public void accept(OccupationVisitor visitor) {
		// TODO Auto-generated method stub
		
	}

}
